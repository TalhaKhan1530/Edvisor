package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Customer_login extends AppCompatActivity {

    Customer customer;
    ArrayList<Edvisor> worker=new ArrayList<>();
    Intent intentpast ;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference().child("worker");
    DatabaseReference myRef2=database.getReference().child("customer");
    DatabaseReference myRef3=database.getReference().child("booking");
    ArrayList<Booking> booking=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Intent intent = getIntent();
        //customer = (Customer) intent.getSerializableExtra("customer");
        //worker = (ArrayList<Edvisor>) intent.getSerializableExtra("worker");


    }

    public void Book_Appointment(View v) {

        Intent intent = new Intent(this,BookAppointment.class);
        intent.putExtra("customer",customer);
        intent.putExtra("worker",worker);
        startActivity(intent);
    }
    public void Show_Booking_Appointments(View v) {

        Intent intent = new Intent(this,Show_current_Booking.class);
        intent.putExtra("customer",customer);
        intent.putExtra("worker",worker);
        startActivity(intent);
    }
    public void chat(View v)
    {
        Intent intent = new Intent(this,Send_chat.class);
        startActivity(intent);
    }
    public void Show_Booking_Past(View v) {

        intentpast = new Intent(this,Past_Appointments.class);
        intentpast.putExtra("customer",customer);
        intentpast.putExtra("worker",worker);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReciever, new IntentFilter("broadmessage"));

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                booking = (ArrayList<Booking>) dataSnapshot.getValue();
                System.out.println("booking "+booking.get(0));
                intentpast.putExtra("bookingpast",booking);



            }

            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });

        startActivity(intentpast);

    }
   public BroadcastReceiver mMessageReciever = new BroadcastReceiver() {
       @Override
       public void onReceive(Context context, Intent intent) {
           System.out.println(intent.getStringExtra("broadmessage"));
       }
   };

    public void Connect(View v)
    {
        Intent intent = new Intent(this,SiteWebView.class);
        startActivity(intent);
    }
}