package com.example.user.pmipenggolongandarah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.user.pmipenggolongandarah.mAdapters.PendonorListAdapter;
import com.example.user.pmipenggolongandarah.mDatas.PendonorDarah;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PendonorDarahActivity extends AppCompatActivity {
    private PendonorDarah pendonorDarah;
    private DatabaseReference reference;
    private PendonorListAdapter pendonorListAdapter;
    private List<PendonorDarah> pendonorDarahList;
    private ListView lvpendonorDarah;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendonor_darah);

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.PD_title);

        lvpendonorDarah = (ListView)findViewById(R.id.lv_pendonorDarah);
        initData();
    }

    private void initData() {
        pendonorDarahList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("pendonor_darah/");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    pendonorDarah = snapshot.getValue(PendonorDarah.class);
                    pendonorDarahList.add(pendonorDarah);
                }

                pendonorListAdapter = new PendonorListAdapter(getApplicationContext(), pendonorDarahList);
                lvpendonorDarah.setAdapter(pendonorListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
