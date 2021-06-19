package com.example.edvisor;

import java.io.Serializable;

public class Complaint implements Serializable {
    public int customer_id;
    public int worker_id;
    public String text;
}
