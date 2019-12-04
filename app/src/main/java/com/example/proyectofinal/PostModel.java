package com.example.proyectofinal;

public class PostModel {
    private int robot;
    private String direction;

    public PostModel(String direction , int robot) {
        this.direction = direction;
        this.robot = robot;
    }

    public String getDirection() {
        return direction;
    }
    public int getRobot() {
        return robot;
    }

}