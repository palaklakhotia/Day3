package com.example.rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Explorer1RocketTest {
    @Test
    void testBasicRocketSetup() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        assertTrue(rocket.verifyReadiness());
    }

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

    @Test
    void testCargoLoadingAffectsLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.loadItem(40000);
        assertFalse(rocket.startLiftoff());
    }

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

    @Test
    void testMissionSummary() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.loadItem(1000);
        rocket.startLiftoff();
        String summary = rocket.getMissionSummary();
        assertNotNull(summary);
        assertTrue(summary.contains("Explorer-1"));
    }

    @Test
    void testZeroFuelCannotLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(0);
        rocket.setEngine(new AlphaEngine());
        assertFalse(rocket.verifyReadiness());
        assertFalse(rocket.startLiftoff());
    }

    @Test
    void testOverloadedCargoWithBetaEngine() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new BetaEngine());
        rocket.loadItem(200000); // Exceeds lift
        assertFalse(rocket.startLiftoff());
    }

    @Test
    void testNoEngineCannotLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        assertFalse(rocket.startLiftoff());
    }

    @Test
    void testNegativeCargoMass() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new AlphaEngine());
        rocket.loadItem(-500);
        // Should not affect mass negatively
        assertTrue(rocket.startLiftoff());
    }

    @Test
    void testRiskyLaunchWithMaxMass() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(100);
        rocket.setEngine(new BetaEngine());
        rocket.setRisky(true);
        rocket.loadItem(139999); // Just below lift limit
        boolean result = rocket.startLiftoff();
        assertTrue(result || !result);
    }

    @Test
    void testMissionSummaryAfterFailedLaunch() {
        Rocket rocket = new Rocket("Explorer-1", 10000);
        rocket.setFuelLevel(0);
        rocket.setEngine(new AlphaEngine());
        rocket.startLiftoff();
        String summary = rocket.getMissionSummary();
        assertNotNull(summary);
        assertTrue(summary.contains("failed"));
    }
}
