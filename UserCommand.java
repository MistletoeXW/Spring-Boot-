package com.Mistletoe.Controller;

public class UserCommand {
    private String userName;
    private String Password;

    public void setUserName(String name){userName = name;}
    public void setPassword(String password){Password = password;}

    public String getUserName(){return userName;}
    public String getPassword(){return Password;}
}
