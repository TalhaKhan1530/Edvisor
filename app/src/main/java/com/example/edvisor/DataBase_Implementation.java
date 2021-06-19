package com.example.edvisor;

import android.content.Context;
import android.database.Cursor;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class DataBase_Implementation implements DB_Interface {
    Db_Helper db;
    ArrayList<Edvisor> edvisor;
    ArrayList<Booking> booking;
    ArrayList<Edvisor>[] a2;
    Edvisor edvisor1;
    Object obj=new Object();
    Semaphore available = new Semaphore(0);

    public DataBase_Implementation(Context context)
    {

    }


    @Override
    public boolean Save_Booking(ArrayList<Booking> booking , DatabaseReference myRef) {
        myRef.setValue(booking);
        return true;

    }

    @Override
    public boolean Save_Edvisor(ArrayList<Edvisor> edvisor, DatabaseReference myRef) {
        myRef.setValue(edvisor);
        return true;
    }



    @Override
    public boolean Save_Mesage(ArrayList<String> chat, DatabaseReference myRef) {
        return false;
    }

    @Override
    public boolean Save_Customer(Customer customer,DatabaseReference myRef) {
        myRef.setValue(customer);

        return true;


    }


}
