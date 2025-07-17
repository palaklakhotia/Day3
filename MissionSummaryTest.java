package com.example.rocket;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MissionSummaryTest {
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
}
