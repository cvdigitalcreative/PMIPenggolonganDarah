package com.example.user.pmipenggolongandarah.mAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.pmipenggolongandarah.R;

import java.util.List;

/**
 * Created by USER on 14/08/2017.
 */

public class MenuListAdapter extends BaseAdapter {
    private Context context;
    private List<String> listMenu;

    public MenuListAdapter(Context context, List<String> listMenu) {
        this.context = context;
        this.listMenu = listMenu;
    }

    @Override
    public int getCount() {
        return listMenu.size();
    }

    @Override
    public Object getItem(int i) {
        return listMenu.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String listItem = (String)this.getItem(i);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_menu, viewGroup, false);
        }

        TextView menu = (TextView) view.findViewById(R.id.list_menu);
        menu.setText(listItem);

        return view;
    }
}
