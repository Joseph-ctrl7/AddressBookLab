package com.example.demo;

import java.util.*;

import jakarta.persistence.*;


@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<BuddyInfo> myBuddies;

    public AddressBook(){
        myBuddies = new LinkedList<>();
    }

    public AddressBook(int id){
        myBuddies = new LinkedList<>();
    }

    public void addBuddy(BuddyInfo buddy)
    {
        myBuddies.add(0, buddy);
    }

    public String removeBuddy(int index)
    {
        if(index <= myBuddies.size()-1){
            return myBuddies.remove(index).toString();
        }
        return "you do not have any buddies!";
    }


    public List<BuddyInfo> getMyBuddies(){
        return myBuddies;
    }

    public void setMyBuddies(List<BuddyInfo> myBuddies) {
        this.myBuddies = myBuddies;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public int size() {
        return myBuddies.size();
    }

    public String printBuddyInfo() {
        String str = "";
        if (myBuddies.size() == 0) {
            return "you ain't got buddies fam";
        }
        for (int i = 0; i < myBuddies.size(); i++) {
            str += myBuddies.get(i).toString();
        }
        return str;
    }



        public static void main(String[] args) {
        System.out.println("Address Book");
        BuddyInfo buddy = new BuddyInfo(1L,"Tom", "613");
        BuddyInfo buddy2 = new BuddyInfo(2L,"James", "424");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.addBuddy(buddy2);
        addressBook.removeBuddy(1);
    }


}

