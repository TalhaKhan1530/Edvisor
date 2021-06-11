package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
}