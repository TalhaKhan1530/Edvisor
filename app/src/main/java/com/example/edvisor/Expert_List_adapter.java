package com.example.edvisor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;

public class Expert_List_adapter extends ArrayAdapter<Edvisor> {


    private ArrayList<Edvisor> notes;

    public Expert_List_adapter(Context context, java.util.ArrayList<Edvisor> notes) {
        super(context, 0, notes);
        this.notes = notes;
    }


    @SuppressLint("ResourceType")
    public View getView(int position, View convertView, ViewGroup parent) {
        Edvisor note = getItem(position);
        if (convertView == null) {
            LinearLayout layout = new LinearLayout(getContext());
            layout.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            layout.setOrientation(LinearLayout.HORIZONTAL);

            TextView text = new TextView(getContext());
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            text.setId(1);
            layout.addView(text);

            convertView = layout;
        }

        @SuppressLint("ResourceType") TextView text = (TextView) convertView.findViewById(1);
        text.setText(note.get_content());

        return convertView;
    }


}