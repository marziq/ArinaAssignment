package Arina;

public class Persons {
    private String name;
    private String address;
    private String contactNumber;

    //default constructor and constructor
    Persons(){
    }
    Persons(String name, String address, String contactNumber){
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    //getters and setters
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getContactNumber(){
        return contactNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    @Override
    public String toString(){
        return "Name: " + name + ". Address: " + address + ". Contact Number: " + contactNumber;
    }

}
