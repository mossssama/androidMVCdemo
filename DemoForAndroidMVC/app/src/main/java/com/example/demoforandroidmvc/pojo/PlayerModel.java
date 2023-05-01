package com.example.demoforandroidmvc.pojo;

/*(4) PlayerModel is Model M */
public class PlayerModel {
    String name;
    String position;
    int yearOfBirth;

    public PlayerModel(String name, String position, int yearOfBirth) {
        this.name = name;
        this.position = position;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    
}
