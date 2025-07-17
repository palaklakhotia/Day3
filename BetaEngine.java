package com.example.rocket;

public class BetaEngine implements Engine {
    @Override
    public int getMass() {
        return 10000;
    }
    @Override
    public int getLiftPower() {
        return 150000;
    }
}
