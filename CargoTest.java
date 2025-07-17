package com.example.rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CargoTest {
    @Test
    void testCargoLoadingAffectsLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.loadItem(40000);
        assertFalse(rocket.startLiftoff());
    }
}
