package com.example.edvisor;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DataBase_Implementation implements DB_Interface {
    Db_Helper db;

    public DataBase_Implementation(Context context)
    {
        db=new Db_Helper(context);
    }

    @Override
    public ArrayList<Edvisor> load_Edvisor() {
        Cursor cursor=db.load_data_Edvisor();
        if (cursor.getCount()==0)
        {
            return new ArrayList<Edvisor>();
        }

        else
        {
            ArrayList<Edvisor> data=new ArrayList<Edvisor>();
            while (cursor.moveToNext())
            {
                Edvisor temp= new Edvisor();
                temp.id = cursor.getInt(0);
                temp.Name = cursor.getString(1);
                temp.average_rating = cursor.getFloat(2);
                temp.expert_in = cursor.getString(3);
                data.add(temp);
            }

            return data;
        }


    }

    @Override
    public ArrayList<Edvisor> load_Customer() {
        return null;
    }

    public void deleteall_Customer()
    {
        db.deleteall_Customer();
    }
    public void deleteall_Edvisor()
    {
        db.deleteall_Edvisor();
    }

    @Override
    public boolean Save_Mesage(ArrayList<String> chat) {
        return false;
    }

    @Override
    public boolean Save_Customer(Customer customer) {
        boolean check= db.Add_data_Customer(customer);
        return check;
    }

    @Override
    public boolean Save_Booking(Booking customer) {
        return false;
    }

    @Override
    public boolean Save_Edvisor(ArrayList<Edvisor> edvisor) {
        for (Edvisor e : edvisor) {
            db.Add_data_Edvisor(e);
        }
        return true;
    }
}
