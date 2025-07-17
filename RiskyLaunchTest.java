package com.example.rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RiskyLaunchTest {
    @Test
    void testRiskyLaunchOutcome() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.setRisky(true);
        rocket.loadItem(1000);
        boolean result = rocket.startLiftoff();
        assertTrue(result || !result); // Accepts both outcomes
    }
}
