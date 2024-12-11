/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/
public class Inventory {
    private String name;
    private String description;
    private int strength;
    private int cost;

    public Inventory() {
    }

    public Inventory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Inventory(String name, String description, int strength) {
        this.name = name;
        this.description = description;
        this.strength = strength;
    }

    public Inventory(String name, int cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public Inventory(String name, String description, int strength, int cost) {
        this.name = name;
        this.description = description;
        this.strength = strength;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

