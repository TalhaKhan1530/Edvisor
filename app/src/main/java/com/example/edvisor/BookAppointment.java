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
    Edvisor worker;
    ListView list;
    Booking booking;
    ArrayList<Booking> booking2=new ArrayList<>();
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference().child("booking");
    ArrayAdapter arrayAdapter;
    ArrayList<Edvisor> arrayList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        customer = (Customer) intent.getSerializableExtra("customer");
        worker = (Edvisor) intent.getSerializableExtra("worker");
        setContentView(R.layout.activity_book_appointment);
        list =(ListView) findViewById( R.id.listbooking);

         arrayList = new ArrayList<Edvisor>();

        arrayList.add(worker);
        Edvisor worker2=new Edvisor();
        worker2.id=123;
        worker2.average_rating=3;
        worker2.Name="name";
        arrayList.add(worker2);
        arrayAdapter = new Expert_List_adapter(this,arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                booking = new Booking();
                booking.customer_id = customer.id;
                booking.expert_id = arrayList.get(i).id;
                booking.current_status=true;
                //db.add(booking);
                booking2.add(booking);
                myRef.setValue(booking2);
                booking = new Booking();
                booking.customer_id = 123;
                booking.expert_id = arrayList.get(i).id;
                booking.current_status=true;
                myRef.setValue(booking2);




                System.out.println("customer id   "+booking.expert_id);
                Context context=getApplicationContext();
                CharSequence text = "Booking Successful";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context,text,duration);
                toast.show();

            }
        });
    }


}

