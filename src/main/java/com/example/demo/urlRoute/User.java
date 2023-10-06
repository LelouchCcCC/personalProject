package com.example.demo.urlRoute;

public class User {
    private String name;
    private int passwd;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passwd=" + passwd +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPasswd() {
        return passwd;
    }

    public void setPasswd(int passwd) {
        this.passwd = passwd;
    }

    public User(String name, int passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public User() {
    }
}
