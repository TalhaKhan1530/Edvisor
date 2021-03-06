package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Show_current_Booking extends AppCompatActivity {
    ArrayList<Booking> bookingdb =new ArrayList<>();
    Show_current_booking_ListAdapter myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Customer customer = (Customer) intent.getSerializableExtra("customer");

        bookingdb = (ArrayList<Booking>) intent.getSerializableExtra("booking");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_current__booking);


        ListView list=(ListView) findViewById(R.id.current_booking);
/*
        Booking o1=new Booking();
        o1.id=1;
        o1.customer_id=1;
        o1.expert_id=2;
        o1.current_status=false;
        Booking o2=new Booking();
        o2.id=6;
        o2.customer_id=5;
        o2.expert_id=4;
        o2.current_status=false;
        ArrayList<Booking> send=new ArrayList<Booking>();
        send.add(o1);
        send.add(o2);

 */

        myListView=new Show_current_booking_ListAdapter(this,bookingdb);
        System.out.println("current"+bookingdb);
        list.setAdapter(myListView);


    }
}