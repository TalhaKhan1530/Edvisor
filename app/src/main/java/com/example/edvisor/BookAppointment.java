package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class BookAppointment extends AppCompatActivity {

    Customer customer;
    Edvisor worker;
    ListView list;
    Booking booking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("customer");
        worker = (Edvisor) intent.getSerializableExtra("worker");
        setContentView(R.layout.activity_book_appointment);
        list =(ListView) findViewById( R.id.listbooking);
        ArrayAdapter arrayAdapter;
        ArrayList<Edvisor> arrayList = new ArrayList<Edvisor>();
        arrayList.add(worker);
        arrayAdapter = new Expert_List_adapter(this,arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                booking = new Booking();
                booking.customer_id = customer.id;

                Context context=getApplicationContext();
                CharSequence text = "Booking Successful";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();

            }
        });

    }


}

