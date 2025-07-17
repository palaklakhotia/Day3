package com.example.rocket;

public class AlphaEngine implements Engine {
    @Override
    public int getMass() {
        return 5000;
    }
    @Override
    public int getLiftPower() {
        return 50000;
    }
}
