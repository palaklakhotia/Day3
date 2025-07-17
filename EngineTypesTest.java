package com.example.rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EngineTypesTest {
    @Test
    void testEngineAlphaLaunchSuccess() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        assertTrue(rocket.startLiftoff());
    }

    @Test
    void testEngineBetaLaunchSuccess() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new BetaEngine());
        assertTrue(rocket.startLiftoff());
    }
}
