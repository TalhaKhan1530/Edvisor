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

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference().child("worker");
    DatabaseReference myRef2=database.getReference().child("customer");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Intent intent = getIntent();
       // customer = (Customer) intent.getSerializableExtra("customer");
        //worker = (Edvisor) intent.getSerializableExtra("worker");
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                customer = (Customer) dataSnapshot.getValue(Customer.class);

                System.out.println(customer.name);
                System.out.println("connected to database");
            }

            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                worker = (ArrayList<Edvisor>) dataSnapshot.getValue();
                System.out.println("connected to database");
            }

            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });

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

        Intent intent = new Intent(this,Past_Appointments.class);
        intent.putExtra("customer",customer);
        intent.putExtra("worker",worker);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReciever, new IntentFilter("broadmessage"));
        startActivity(intent);
    }
   public BroadcastReceiver mMessageReciever = new BroadcastReceiver() {
       @Override
       public void onReceive(Context context, Intent intent) {
           System.out.println(intent.getStringExtra("broadmessage"));
       }
   };
}