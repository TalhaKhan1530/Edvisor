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
        return id + " "+customer_id+" "+expert_id;
    }
}
