package com.example.edvisor;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Booking implements Serializable {
    public int id;
    public int expert_id;
    public int customer_id;
    public boolean current_status;
    public String description;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public String getcontent()
    {

        String customer=new String();
        String worker=new String();
        if (id==1)
        {
            worker="Bilal";

        }
        else if(id==123)
        {
            worker="arsalan";
        }
        else
        {
            worker="Umer";
        }



        return "Booking id:"+id + "   Expert name: "+worker+" ( "+expert_id + ")";
    }



}
