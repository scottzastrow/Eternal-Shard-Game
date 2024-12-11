/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/
public class NPC {
    private String name;
    private String description;
    private int health;
    private int attackPower;
    private boolean isDefeated;

    public NPC(){}
    public NPC(String name, int health, int attackPower){
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.isDefeated = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }
}
