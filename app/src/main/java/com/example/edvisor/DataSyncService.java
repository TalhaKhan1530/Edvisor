package com.example.edvisor;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.Toast;

public class DataSyncService extends Service {

    private final IBinder binder = new LocalBinder();

    public void onCreate() {

        System.out.println("service started");
    }

    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this,"Service starting",Toast.LENGTH_SHORT).show();


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
