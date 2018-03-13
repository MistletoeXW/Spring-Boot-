package com.Mistletoe.Domain;

import java.io.Serializable;

//用户领域对象，可以看成是用户数据表的对象映射，每个字段对应一个属性。
//领域对象一般要实现Serializble接口，以便可以序列化
public class User implements Serializable {
    private int userId;
    private String userName;
    private String Password;
    private String Note;

    public void setUserId(int id){ userId = id; }
    public void setUserName(String name){ userName =name; }
    public void setPassword(String password){ Password = password; }
    public void setNote(String note){ Note = note; }

    public int getUserId(){ return userId;}
    public String getUserName(){return userName;}
    public String getPassword(){return Password;}
    public String getNote() {return Note;}


}
