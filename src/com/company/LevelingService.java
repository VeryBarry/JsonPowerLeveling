package com.company;

/**
 * Created by VeryBarry on 9/21/16.
 */
public class LevelingService {
    int currentLevel;
    int desiredLevel;
    double cost;
    String playerClass;
    String playerServer;
    
    LevelingService(){
        
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getDesiredLevel() {
        return desiredLevel;
    }

    public void setDesiredLevel(int desiredLevel) {
        this.desiredLevel = desiredLevel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getPlayerServer() {
        return playerServer;
    }

    public void setPlayerServer(String playerServer) {
        this.playerServer = playerServer;
    }
}
