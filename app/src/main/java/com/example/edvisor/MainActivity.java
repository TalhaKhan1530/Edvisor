package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Customer customer1;
    Edvisor worker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void customer_login(View v) {
        customer1=new Customer();
        customer1.id=1;
        customer1.name="Ali";
        customer1.payment_method="Cash";
        worker= new Edvisor();
        worker.Name="Bilal";
        worker.id=1;
        worker.expert_in="Law";
        worker.average_rating=4.3f;


        Intent intent = new Intent(this, Customer_login.class);
        intent.putExtra("customer",customer1);
        intent.putExtra("worker",worker);
        startActivity(intent);

    }
}