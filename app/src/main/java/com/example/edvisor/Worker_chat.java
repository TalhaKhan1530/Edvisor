package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Worker_chat extends AppCompatActivity {
    ArrayList<String> chat=new ArrayList<>();
    ArrayList<String> chat2=new ArrayList<>();
    EditText chattext;
    TextView textview;
    Button button;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("message");

    DatabaseReference myRefc = database.getReference().child("customer");

    DatabaseReference myRef2 = database.getReference().child("message2");

    ListView myListView;
    ArrayAdapter<String> arrayAdapter;
    ListView myListView2;
    ArrayAdapter<String> arrayAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        //textview=findViewById(R.id.textview);
        chattext=findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);


        myListView = findViewById(R.id.mylistview);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chat);
        myListView.setAdapter(arrayAdapter);

        myListView2 = findViewById(R.id.mylistview2);
        arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chat2);
        myListView2.setAdapter(arrayAdapter2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String chat=chattext.getText().toString();

                chat.add("customer : "+chattext.getText().toString());

                myListView.setAdapter(arrayAdapter);

                myRef.setValue(chat);
                //DatabaseReference newRef = myRef.child("message").push();
                //newRef.setValue(chat);

                //myRef.endAt(String.valueOf(chat));
                chattext.setText("");
                //textview.setText(chat);

            }
        });



        myRef2.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                {
                    //String value = dataSnapshot.getValue(String.class);
                    ArrayList<String> value = new ArrayList<>();
                    //System.out.println(dataSnapshot.getValue());
                    value = (ArrayList<String>) dataSnapshot.getValue();
                    System.out.println(value);

                    chat.clear();
                    for (String i : value) {
                        chat.add(i);
                    }
                    value.clear();
                    System.out.println("connected to database");

                    myListView.setAdapter(arrayAdapter);
                }

            }
            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });
        ////////////////////////////////////////////////////////////worker
        myRef.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                {

                    ArrayList<String> value2 = new ArrayList<>();
                    //System.out.println(dataSnapshot.getValue());
                    value2 = (ArrayList<String>) dataSnapshot.getValue();
                    System.out.println(value2);

                    chat2.clear();
                    for (String i : value2) {
                        chat2.add(i);
                    }
                    value2.clear();
                    System.out.println("connected to worker");

                    myListView2.setAdapter(arrayAdapter2);
                }

            }
            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });






    }
}