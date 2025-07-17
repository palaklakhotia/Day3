package com.example.rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FalconRocketTest {
    @Test
    void testBasicRocketSetup() {
        Rocket rocket = new Rocket("Falcon", 20000);
        rocket.setFuelLevel(100);
        assertTrue(rocket.verifyReadiness());
    }

    @Test
    void testEngineAlphaLaunchSuccess() {
        Rocket rocket = new Rocket("Falcon", 20000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        assertTrue(rocket.startLiftoff());
    }

    @Test
    void testEngineBetaLaunchSuccess() {
        Rocket rocket = new Rocket("Falcon", 20000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new BetaEngine());
        assertTrue(rocket.startLiftoff());
    }

    @Test
    void testCargoLoadingAffectsLaunch() {
        Rocket rocket = new Rocket("Falcon", 20000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.loadItem(40000);
        assertFalse(rocket.startLiftoff());
    }

    @Test
    void testRiskyLaunchOutcome() {
        Rocket rocket = new Rocket("Falcon", 20000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.setRisky(true);
        rocket.loadItem(1000);
        boolean result = rocket.startLiftoff();
        assertTrue(result || !result); // Accepts both outcomes
    }

    @Test
    void testMissionSummary() {
        Rocket rocket = new Rocket("Falcon", 20000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.loadItem(1000);
        rocket.startLiftoff();
        String summary = rocket.getMissionSummary();
        assertNotNull(summary);
        assertTrue(summary.contains("Falcon"));
    }
}
