package com.example.sqlitedb.contact_info;

public class MyContacts {
    String Id;
    String Name;
    String Mobile;
    String Email;
    String Address;

    String Relation;

    public MyContacts(String id,String name, String mobile,String email, String address,  String relation) {
        Id = id;
        Name = name;
        Mobile = mobile;
        Address = address;
        Email = email;
        Relation = relation;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public MyContacts() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRelation() {
        return Relation;
    }

    public void setRelation(String relation) {
        Relation = relation;
    }
}
