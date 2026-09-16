package com.example.demo;

public class Logique {


    public int factorielle(int nb){
        if(nb==1||nb==0) return 1;
        else return nb*factorielle(nb-1);
    }
}
