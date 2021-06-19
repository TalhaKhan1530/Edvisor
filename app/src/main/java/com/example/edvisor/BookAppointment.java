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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;



public class BookAppointment extends AppCompatActivity {

    Customer customer;
    ArrayList<Edvisor> worker=new ArrayList<>();
    ListView list;
    Booking booking;
    ArrayList<Booking> booking2=new ArrayList<>();
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference().child("booking");
    ArrayAdapter arrayAdapter;
    ArrayList<Edvisor> arrayList ;
   // DataBase_Implementation db=new DataBase_Implementation(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intent intent = getIntent();
       // customer = (Customer) intent.getSerializableExtra("customer");
        //worker = (ArrayList<Edvisor>) intent.getSerializableExtra("worker");
        setContentView(R.layout.activity_book_appointment);
        list =(ListView) findViewById( R.id.listbooking);


        Edvisor worker2=new Edvisor();
        worker2.id=123;
        worker2.average_rating=3;
        worker2.Name="name";
        worker=new ArrayList<Edvisor>();
        worker.add(worker2);
        worker.add(worker2);
        arrayAdapter = new Expert_List_adapter(this,worker);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Context context=getApplicationContext();
                CharSequence text = "Booking Successful";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();

            }
        });
    }


}

