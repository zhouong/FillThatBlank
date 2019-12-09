package com.example.something;

public class Player {
    private String name;

    private String response;

    private int points = 0;

    //setter and getter for name;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //setter and getter for response
    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    //setter and getter for points
    public void addPoints() {
        points++;
    }

    public int getPoints() {
        return points;
    }
}
