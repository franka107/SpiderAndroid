package com.example.proyectofinal.Model;

public class MoveModel {
    private int robot;
    private String direction;

    public MoveModel(String direction , int robot) {
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