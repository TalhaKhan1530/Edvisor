package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Customer_login extends AppCompatActivity {

    Customer customer;
    Edvisor worker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("customer");
        worker = (Edvisor) intent.getSerializableExtra("worker");
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

}