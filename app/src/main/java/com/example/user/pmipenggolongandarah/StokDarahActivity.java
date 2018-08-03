package com.example.user.pmipenggolongandarah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.pmipenggolongandarah.mAdapters.StokListAdapter;
import com.example.user.pmipenggolongandarah.mDatas.StokDarah;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StokDarahActivity extends AppCompatActivity {
    private ListView lvStok;
    private List<StokDarah> stokList;
    private StokListAdapter stokAdapter;
    private StokDarah stokDarah;
    private DatabaseReference reference;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok_darah);

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.SD_title);

        lvStok = (ListView)findViewById(R.id.lvStok);
        initData();
    }

    private void initData() {
        stokList = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("stok_darah/");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    stokDarah = snapshot.getValue(StokDarah.class);
                    stokList.add(stokDarah);
                }

                stokAdapter = new StokListAdapter(getApplicationContext(), stokList);
                lvStok.setAdapter(stokAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
