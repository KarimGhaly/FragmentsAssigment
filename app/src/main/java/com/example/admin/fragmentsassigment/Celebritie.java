package com.example.admin.fragmentsassigment;

/**
 * Created by Admin on 9/14/2017.
 */

public class Celebritie {
    String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    int Age;
    int ImageID;
    String Description;

    public Celebritie(String name, int age, int imageID, String description) {
        Name = name;
        Age = age;
        ImageID = imageID;
        Description = description;
    }
}
