package com.example.user.pmipenggolongandarah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.user.pmipenggolongandarah.mAdapters.EventListAdapter;
import com.example.user.pmipenggolongandarah.mDatas.EventPMI;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EventPMIActivity extends AppCompatActivity {
    private DatabaseReference reference;
    private EventListAdapter eventListAdapter;
    private EventPMI eventPMI;
    private List<EventPMI> eventPMIs;
    private ListView lvEvent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_pmi);

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.EPMI_title);

        lvEvent = (ListView)findViewById(R.id.lvEvent);
        initData();
    }

    private void initData() {
        eventPMIs = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("event_pmi/");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    eventPMI = snapshot.getValue(EventPMI.class);
                    eventPMIs.add(eventPMI);
                }

                eventListAdapter = new EventListAdapter(getApplicationContext(), eventPMIs);
                lvEvent.setAdapter(eventListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
