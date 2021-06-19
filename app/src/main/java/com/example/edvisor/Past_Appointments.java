package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Past_Appointments extends AppCompatActivity {
    ArrayList<Booking> send;
    Adapter_past_Appointments myListView;
    Customer customer2;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("customer");
    DatabaseReference myRef2 = database.getReference().child("booking");
    ArrayList<Booking> booking=new ArrayList<>();
    ListView list;
    ArrayList<Booking> bookingpast=new ArrayList<>();

    protected void onStart() {


        super.onStart();

        Intent intent = getIntent();
        final Customer customer = (Customer) intent.getSerializableExtra("customer");
//        Edvisor worker = (Edvisor) intent.getSerializableExtra("worker");

        bookingpast= (ArrayList<Booking>) intent.getSerializableExtra("bookingpast");
        setContentView(R.layout.activity_show_current__booking);


        list = (ListView) findViewById(R.id.current_booking);

        Booking o1 = new Booking();
        o1.id = 1;
        o1.customer_id = 1;
        o1.expert_id = 2;
        o1.current_status = false;
        Booking o2 = new Booking();
        o2.id = 6;
        o2.customer_id = 5;
        o2.expert_id = 4;
        o2.current_status = false;
        send = new ArrayList<Booking>();
        send.add(o1);
        send.add(o2);
        myRef2.setValue(send);

        Context context = this;
        myListView = new Adapter_past_Appointments(this, send, context);
        list.setAdapter(myListView);

        System.out.println("booking in on start "+booking);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        System.out.println("on create instane");
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                booking = (ArrayList<Booking>) dataSnapshot.getValue();
                System.out.println("booking "+booking.get(0));


            }

            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });
    }
public void getdata() {
    System.out.println("on start instane");
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                booking = (ArrayList<Booking>) dataSnapshot.getValue();
                System.out.println("booking "+booking.getClass());


            }

            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });




}


}