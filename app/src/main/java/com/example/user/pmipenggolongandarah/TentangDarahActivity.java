package com.example.user.pmipenggolongandarah;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TentangDarahActivity extends AppCompatActivity {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_darah);

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.TGD_title);

        listView = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new com.example.user.pmipenggolongandarah.mAdapters.ExpandableListAdapter(this, listDataHeader, listHashMap);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();
        String desc;

        listDataHeader.add("Golongan Darah A");
        listDataHeader.add("Golongan Darah B");
        listDataHeader.add("Golongan Darah AB");
        listDataHeader.add("Golongan Darah O");
        listDataHeader.add("Syarat Calon Pendonor");
        listDataHeader.add("Orang Tidak Boleh Donor");

        List<String> golDarA = new ArrayList<>();
        desc = getResources().getString(R.string.DeskGolA);
        golDarA.add(desc);

        List<String> golDarB = new ArrayList<>();
        desc = getResources().getString(R.string.DeskGolB);
        golDarB.add(desc);

        List<String> golDarAB = new ArrayList<>();
        desc = getResources().getString(R.string.DeskGolAB);
        golDarAB.add(desc);

        List<String> golDarO = new ArrayList<>();
        desc = getResources().getString(R.string.DeskGolO);
        golDarO.add(desc);

        List<String> syaratCP = new ArrayList<>();
        desc = getResources().getString(R.string.SyaratCalonPendonor);
        syaratCP.add(desc);

        List<String> notDonor = new ArrayList<>();
        desc = getResources().getString(R.string.OrangTidakBolehDonor);
        notDonor.add(desc);

        listHashMap.put(listDataHeader.get(0), golDarA);
        listHashMap.put(listDataHeader.get(1), golDarB);
        listHashMap.put(listDataHeader.get(2), golDarAB);
        listHashMap.put(listDataHeader.get(3), golDarO);
        listHashMap.put(listDataHeader.get(4), syaratCP);
        listHashMap.put(listDataHeader.get(5), notDonor);

    }
}
