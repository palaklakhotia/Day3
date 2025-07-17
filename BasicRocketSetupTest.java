package com.example.rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BasicRocketSetupTest {
    @Test
    void testBasicRocketSetup() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        assertTrue(rocket.verifyReadiness());
    }
}
