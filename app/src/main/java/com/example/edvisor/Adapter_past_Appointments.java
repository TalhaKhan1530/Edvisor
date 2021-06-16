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

import androidx.activity.result.contract.ActivityResultContracts;

import java.util.ArrayList;

public class Adapter_past_Appointments extends ArrayAdapter<Booking> {

    Context our_context;

    private ArrayList<Booking> notes;

    public Adapter_past_Appointments(Context context, ArrayList<Booking> notes,Context our_context) {
        super(context, 0, notes);
        this.our_context=our_context;
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
            button.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            //CheckBox button = (CheckBox)((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.check_right_checkbox,null);
            //rootView.addView(button);
            button.setText("X");
            button.setId(2);
            layout.addView(button);

            TextView text = new TextView(getContext());
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
            text.setId(1);


            layout.addView(text);

            Button button2 = new Button(getContext());
            button2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            //CheckBox button = (CheckBox)((LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.check_right_checkbox,null);
            //rootView.addView(button);
            button2.setText("Option");
            button2.setId(4);
            button2.setRight(5);
            layout.addView(button2);


            convertView = layout;
        }

        TextView text = (TextView) convertView.findViewById(1);
        text.setText(note.getcontent());

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

        Button button2 = (Button) convertView.findViewById(4);
        // button.setText("Add");
        button2.setTag(note);

        button2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent= new Intent (our_context,Rating_Complaint_Fav_Clicker.class);
                our_context.startActivity(intent);


            }
        });
        return convertView;
    }

}

