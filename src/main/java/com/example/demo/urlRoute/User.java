package com.example.demo.urlRoute;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "用户类")
public class User {
    @Schema(description = "名字")
    private String name;
    @Schema(description = "密码")
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
