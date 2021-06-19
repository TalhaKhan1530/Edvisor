package com.example.edvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.localbroadcastmanager.*;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    Customer customer1;
    Edvisor worker;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("customer");
    DatabaseReference myRef2 = database.getReference().child("worker");
    DataBase_Implementation db;
    DataSyncService dataService;
    ConnectivityReceiver receiver;
    ArrayList<Edvisor> workers=new ArrayList<>();
    boolean bound = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBase_Implementation db = new DataBase_Implementation(this);


        customer1=new Customer();
        customer1.id=123;
        customer1.name="noor";
        customer1.payment_method="card";
        db.Save_Customer(customer1,myRef);

        worker= new Edvisor();
        worker.Name="Bilal";
        worker.id=1;
        worker.expert_in="Law";
        worker.average_rating=4.3f;
        workers.add(worker);
        worker= new Edvisor();
        worker.Name="arslan";
        worker.id=123;
        worker.expert_in="advocate";
        worker.average_rating=4.3f;
        workers.add(worker);
        db.Save_Edvisor(workers,myRef2);



       /* MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        */
        // AdRequest adRequest = new AdRequest.Builder().build();
        // mAdView.loadAd(adRequest);


        setContentView(R.layout.activity_main);

        System.out.println("on create instance");

    }
    private void showMessage(String message){
        Toast toast = Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void customer_login(View v) {



        Intent intent = new Intent(this, Customer_login.class);
        intent.putExtra("customer",customer1);
        intent.putExtra("worker",worker);
        Intent intent2 = new Intent("brodmessage");
        intent2.putExtra("broadmessage", "broad cast message sent");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);

        //////////////////////////////////// load customer
        myRef.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {

                customer1 = (Customer) dataSnapshot.getValue(Customer.class);
                System.out.println("customer1  "+customer1.name);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });
        ////////////////////////////////////// loasd workersssss
        myRef2.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
               workers=new ArrayList<Edvisor>();
            }

            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });

        startActivity(intent);

    }
    private ServiceConnection connection = new ServiceConnection(){

        public void onServiceConnected(ComponentName className, IBinder binder){
            dataService = ((DataSyncService.LocalBinder) binder).getService();
            bound = true;

            showMessage(dataService.getStatus());
        }

        public void onServiceDisconnected(ComponentName className){
            bound = false;
        }
    };
    Context context = this;
    protected void onStart(){
        super.onStart();
        Intent intent = new Intent(this,DataSyncService.class);
      bindService(intent,connection, Context.BIND_AUTO_CREATE);
    }

    protected void onStop(){
        super.onStop();
        if(bound){
        unbindService(connection);
        }
    }

    protected void onDestroy(){
      //  unregisterReceiver(receiver);
        super.onDestroy();
    }
}