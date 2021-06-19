package com.example.edvisor;

import java.time.LocalDateTime;

public class Booking {
    public int id;
    public int expert_id;
    public int customer_id;
    public boolean current_status;
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
        else
        {
            worker="arsalan";
        }

        return "Booking id:"+id + "   Expert name: "+worker+" ( "+expert_id + ")";
    }
}
