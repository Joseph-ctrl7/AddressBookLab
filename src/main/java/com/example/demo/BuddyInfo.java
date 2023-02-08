package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String phoneNumber;

    public BuddyInfo(){
    }

    public BuddyInfo(String name){
        this.name = name;
    }

    public BuddyInfo(String name, String number){
        this.name = name;
        this.phoneNumber = number;
    }
    public BuddyInfo(Long id, String name, String phoneNumber){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String toString(){
        String str = "";
        str = str + name + "#";
        str = str + phoneNumber + "";
        return str;
    }



}