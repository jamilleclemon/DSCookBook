package com.example.myrecipeapp;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")

public class Post extends ParseObject {

    public static final String KEY_TITLE = "Title";
    public static final String KEY_DESCRIPTION ="Descpiption";
    public static final String  KEY_IMAGE ="Image";
    public static final String  KEY_USER ="username";


    public String getTitle(){
    return getString(KEY_TITLE);
    }
    public  void setTitle(String Title){
        put(KEY_TITLE,Title);
}
    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION,description);
    }

    public ParseFile getImage (){
        return getParseFile(KEY_IMAGE);
    }
    public void setImage (ParseFile parseFile){
        put(KEY_IMAGE,parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser username){
        put (KEY_USER,username);
    }
}
