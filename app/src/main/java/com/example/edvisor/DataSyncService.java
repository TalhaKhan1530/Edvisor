package com.example.edvisor;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DataSyncService extends Service {
    Context context;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef=database.getReference().child("worker");
    ArrayList<Edvisor> workerdb=new ArrayList<>();
    private final IBinder binder = new LocalBinder();

    public void onCreate() {

        System.out.println("service started");
    }

    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this,"Service starting",Toast.LENGTH_SHORT).show();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                System.out.println("worker db ");
                System.out.println((ArrayList<Edvisor>) dataSnapshot.getValue());
                for(DataSnapshot snap:dataSnapshot.getChildren())
                {
                    workerdb.add(snap.getValue(Edvisor.class));
                }
                System.out.println("children"+workerdb);
                System.out.println(workerdb.getClass());

                Intent intent2 = new Intent("custom-message");
                intent2.putExtra("worker",workerdb);

                LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);

            }
            @Override
            public void onCancelled(DatabaseError error) {

                System.out.println("failed to connect");
            }
        });
        //////////////////////////

        return START_NOT_STICKY;
    }

    public IBinder onBind(Intent intent){
        return binder;
    }

    public void onDestroy(){
        Toast.makeText(this,"Service stopped",Toast.LENGTH_SHORT).show();
    }

    public class LocalBinder extends Binder{
        public DataSyncService getService(){
            return DataSyncService.this;
        }
    }

    public String getStatus(){
        return "synchronization in progress";
    }

}
