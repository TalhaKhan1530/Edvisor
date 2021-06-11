package com.example.edvisor;

import java.io.Serializable;

public class Edvisor implements Serializable {
    public String Name;
    public int id;
    public float average_rating;
    public String expert_in;


    public String get_content() {
        return this.Name + " " + this.expert_in + " " + this.average_rating;
    }

}