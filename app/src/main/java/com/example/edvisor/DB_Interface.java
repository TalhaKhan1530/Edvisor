package com.example.edvisor;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public interface DB_Interface {

public boolean Save_Mesage(ArrayList<String> chat,DatabaseReference myRef);
public boolean Save_Customer(Customer customer,DatabaseReference myRef);


public boolean Save_Booking(ArrayList<Booking> booking,DatabaseReference myRef);

public boolean Save_Edvisor(ArrayList<Edvisor> edvisor,DatabaseReference myRef);



}
