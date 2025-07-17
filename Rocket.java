package com.example.rocket;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
    private String model;
    private int baseMass;
    private int fuelLevel;
    private Engine engine;
    private List<Integer> cargo;
    private boolean risky;
    private boolean launched;
    private boolean launchSuccess;
    private String missionSummary;

    public Rocket(String model, int baseMass) {
        this.model = model;
        this.baseMass = baseMass;
        this.fuelLevel = 0;
        this.cargo = new ArrayList<>();
        this.risky = false;
        this.launched = false;
        this.launchSuccess = false;
        this.missionSummary = "";
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void loadItem(int itemMass) {
        if (itemMass > 0) {
            cargo.add(itemMass);
        }
    }

    public void setRisky(boolean risky) {
        this.risky = risky;
    }

    public boolean verifyReadiness() {
        return fuelLevel == 100;
    }

    public boolean startLiftoff() {
        if (!verifyReadiness()) {
            launched = true;
            launchSuccess = false;
            missionSummary = "Launch failed: Fuel not full for " + model;
            return false;
        }
        if (engine == null) {
            launched = true;
            launchSuccess = false;
            missionSummary = "Launch failed: No engine for " + model;
            return false;
        }
        int totalMass = baseMass + engine.getMass();
        for (int m : cargo) totalMass += m;
        if (totalMass > engine.getLiftPower()) {
            launched = true;
            launchSuccess = false;
            missionSummary = "Launch failed: Too heavy for engine for " + model;
            return false;
        }
        if (risky) {
            // 50% chance of failure for risky launches
            launchSuccess = Math.random() > 0.5;
        } else {
            launchSuccess = true;
        }
        launched = true;
        missionSummary = launchSuccess ? "Launch succeeded for " + model : "Launch failed: Risky launch for " + model;
        return launchSuccess;
    }

    public String getMissionSummary() {
        if (!launched) return "No launch attempted for " + model;
        if (launchSuccess) return "Mission succeeded for " + model;
        return missionSummary + " (failed)";
    }
}
