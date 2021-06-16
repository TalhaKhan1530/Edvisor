package com.example.edvisor;

import java.util.ArrayList;

public interface DB_Interface {

public boolean Save_Mesage(ArrayList<String> chat);
public boolean Save_Customer(Customer customer);

public boolean Save_Booking(Booking customer);

public boolean Save_Edvisor(ArrayList<Edvisor> edvisor);
    public ArrayList<Edvisor> load_Edvisor();
    public ArrayList<Edvisor> load_Customer();


}
