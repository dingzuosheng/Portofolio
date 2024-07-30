package com.ding.portofolio.model;


import java.util.Arrays;

public enum Role{
    ADMIN("Admin"),
    USER("User");

    private final String text;
    private Role(String value){
        this.text = value;
    }

    public String getText(){
        return this.text;
    }

    public static Role fromValue(String value){
        for(Role role: values()){
            if(role.text.equalsIgnoreCase(value)){
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value + ", Allowed values are "+ Arrays.toString(values()));
    }

}
