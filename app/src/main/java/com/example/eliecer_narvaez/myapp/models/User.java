package com.example.eliecer_narvaez.myapp.models;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Benavides on 22/10/16.
 */

public class User  {




    String name;
    @SerializedName("password")
    String password;
    @SerializedName("email")

    String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name;
    }
}
