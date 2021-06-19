package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Rating_Complaint_Fav_Clicker extends AppCompatActivity {

    EditText textContent;
    EditText textContent_complain;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("rating");
    DatabaseReference myRef2 = database.getReference().child("complain");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating__complaint__fav__clicker);
        Intent intent = getIntent();
    }

    public void add_Rating(View v) {

        Rating r1=new Rating();
        r1.booking_id=1;
        r1.rating_id=1;
        r1.worker_id=1;
        textContent = (EditText) findViewById(R.id.editTextNumber);
        String s1= textContent.getText().toString();
        r1.rating= Float.parseFloat(s1);
        myRef.setValue(r1);


    }
    public void Complaint(View v){
        Complaint complaint = new Complaint();
        complaint.customer_id = 1;
        complaint.worker_id=1;
        textContent_complain = (EditText) findViewById(R.id.complain);
        String s2 = textContent_complain.getText().toString();
        complaint.text = s2;
        myRef2.setValue(complaint);
        //complaint.text = "Never take SMD as elective or even core, if it is core leave degree";
    }

}