package org.learnings.streams.Enum;

public enum City {
    MUMBAI("Mumbai"), 
    DELHI("Delhi"), 
    BANAGLORE("Banaglore"), 
    NOIDA("Noida");

    public final String value;

    City(String value){
        this.value = value;
    }
}
