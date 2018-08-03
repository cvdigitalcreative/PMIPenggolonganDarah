package com.example.user.pmipenggolongandarah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.pmipenggolongandarah.mAdapters.MenuListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnTentang;
    private Button btnStok;
    private Button btnPendonor;
    private Button btnEvent;
    private Button btnInformasi;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

        btnTentang = (Button)findViewById(R.id.tentang);
        btnPendonor = (Button)findViewById(R.id.pendonor);
        btnStok = (Button)findViewById(R.id.stok);
        btnEvent = (Button)findViewById(R.id.event);
        btnInformasi = (Button)findViewById(R.id.informasi);

        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TentangDarahActivity.class);
                startActivity(intent);
            }
        });

        btnStok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StokDarahActivity.class);
                startActivity(intent);
            }
        });

        btnPendonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PendonorDarahActivity.class);
                startActivity(intent);
            }
        });

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventPMIActivity.class);
                startActivity(intent);
            }
        });

        btnInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InformasiActivity.class);
                startActivity(intent);
            }
        });
    }
}
