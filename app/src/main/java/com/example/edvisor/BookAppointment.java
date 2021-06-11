package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class BookAppointment extends AppCompatActivity {

    Customer customer;
    Edvisor worker;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("customer");
        worker = (Edvisor) intent.getSerializableExtra("worker");
        setContentView(R.layout.activity_book_appointment);
        list =(ListView) findViewById( R.id.listbooking);
        ArrayAdapter arrayAdapter;
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(worker.get_content());
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            }
        });

    }


}

