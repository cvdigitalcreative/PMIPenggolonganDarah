package com.example.user.pmipenggolongandarah.mAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.pmipenggolongandarah.R;
import com.example.user.pmipenggolongandarah.mDatas.EventPMI;

import java.util.List;

/**
 * Created by USER on 14/08/2017.
 */

public class EventListAdapter extends BaseAdapter {
    private Context context;
    private List<EventPMI> eventPMIs;

    public EventListAdapter(Context context, List<EventPMI> eventPMIs) {
        this.context = context;
        this.eventPMIs = eventPMIs;
    }

    @Override
    public int getCount() {
        return eventPMIs.size();
    }

    @Override
    public Object getItem(int i) {
        return eventPMIs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        EventPMI eventPMI = (EventPMI)getItem(i);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_event_pmi, viewGroup, false);
        }

        TextView tgl = (TextView)view.findViewById(R.id.tanggal_event);
        TextView tmp = (TextView)view.findViewById(R.id.tempat_event);
        TextView jam = (TextView)view.findViewById(R.id.jam_event);

        tgl.setText(eventPMI.getTanggal());
        tmp.setText(eventPMI.getTempat());
        jam.setText(eventPMI.getJam());

        return view;
    }
}
