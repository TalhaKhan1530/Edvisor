package com.example.edvisor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Show_current_booking_ListAdapter extends ArrayAdapter<Booking> {


    private ArrayList<Booking> notes;

    public Show_current_booking_ListAdapter(Context context, ArrayList<Booking> notes) {
        super(context, 0, notes);
        this.notes = notes;
    }


    @SuppressLint("ResourceType")
    public View getView(int position, View convertView, ViewGroup parent) {
        final Booking note = getItem(position);
        if (convertView == null) {
            LinearLayout layout = new LinearLayout(getContext());
            layout.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            layout.setOrientation(LinearLayout.HORIZONTAL);

            Button button = new Button(getContext());

            //CheckBox button = (CheckBox)((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.check_right_checkbox,null);
            //rootView.addView(button);
            button.setId(2);
            button.setText("X");
            layout.addView(button);

            TextView text = new TextView(getContext());
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            text.setId(1);
            convertView = layout;
        }

        TextView text = (TextView) convertView.findViewById(1);
        text.setText("View my View");

        Button button = (Button) convertView.findViewById(2);
        // button.setText("Add");
        button.setTag(note);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                notes.remove(notes.indexOf(note));
                notifyDataSetChanged();

            }
        });
                return convertView;
    }


}

