/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/
import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    private int level;
    private int currency;
    private boolean weapon;
    private Region region;
    private int shards;
    private String quest;
    private int gameState;
    //private ArrayList<String> quests = new ArrayList<String>();

    public Player() {
    }

    public Player(String name){
        this.name = name;
    }
    public Player(String name, int health, int level, int currency, boolean weapon, Region region){
        this.name = name;
        this.health = health;
        this.level = level;
        this.currency = currency;
        this.weapon = weapon;
        this.region = region;
    }
    public void move(Region newRegion){
        this.region = newRegion;
        System.out.println("You are in Region: " + newRegion.regionName);
    }
    public void interact(String interactionType){
        System.out.println("You choose to " + interactionType);
    }
    public void addCurrency(int coins){
        currency+=coins;
    }
    public void removeCurrency(int coins){
        currency-=coins;
    }
    public void takeDamage(int damage){
        health -= damage;
    }
    public void getHealthier(int boost){
        health+= boost;
    }
    public void takeShard(int pieceOfShards){
        shards-=pieceOfShards;
    }
    public void addShard(int pieceOfShards){
        shards+=pieceOfShards;
    }
    public void completeQuest(String questName){
        //quests.add(questName);
        quest = questName;
        System.out.println("You have completed " + quest);
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void levelUp(){
        this.level += 1;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public boolean isWeapon() {
        return weapon;
    }

    public void setWeapon(boolean weapon) {
        this.weapon = weapon;
    }

    public int getShards() {
        return shards;
    }

    public void setShards(int shards) {
        this.shards = shards;
    }
}
