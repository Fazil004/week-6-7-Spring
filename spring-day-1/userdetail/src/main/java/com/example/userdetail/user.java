package com.example.userdetail;

public class user {
    String name;
    int age;
    String email;

    public user (){}
    public user(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public String getName() { return name;}
    public int getAge() { return age;}
    public String getEmail() { return email;}

    public void setName(String name) { this.name = name;}
    public void setAge(int age) { this.age = age;}
    public void setEmail(String email) { this.email = email;}
}
