package com.example.user.pmipenggolongandarah.mAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.pmipenggolongandarah.R;
import com.example.user.pmipenggolongandarah.mDatas.PendonorDarah;

import java.util.List;

/**
 * Created by USER on 14/08/2017.
 */

public class PendonorListAdapter extends BaseAdapter {
    private Context context;
    private List<PendonorDarah> pendonorDarahList;

    public PendonorListAdapter(Context context, List<PendonorDarah> pendonorDarahList) {
        this.context = context;
        this.pendonorDarahList = pendonorDarahList;
    }

    @Override
    public int getCount() {
        return pendonorDarahList.size();
    }

    @Override
    public Object getItem(int i) {
        return pendonorDarahList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PendonorDarah pendonorDarah = (PendonorDarah)getItem(i);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_pendonor_darah, viewGroup, false);
        }

        TextView nama = (TextView)view.findViewById(R.id.nama);
        TextView alamat = (TextView)view.findViewById(R.id.alamat);
        TextView gol_darah = (TextView)view.findViewById(R.id.gol_darah);
        TextView no_hp = (TextView)view.findViewById(R.id.no_hp);
        TextView tanggal_daftar = (TextView)view.findViewById(R.id.tanggal_daftar);

        nama.setText(pendonorDarah.getNama());
        gol_darah.setText(pendonorDarah.getGol_darah());
        alamat.setText(pendonorDarah.getAlamat());
        no_hp.setText(pendonorDarah.getNo_hp());
        tanggal_daftar.setText(pendonorDarah.getTanggal_daftar());

        return view;
    }
}
