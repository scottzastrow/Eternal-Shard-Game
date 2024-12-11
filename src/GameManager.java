/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
--------------
Default settings
name=player
health=10
level=0
currency=10
weapon=false
shards=0
quest=Kyrthael Forest
gamestate=0
--------------
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class GameManager {
    public static LinkedHashMap<String, String> map = new LinkedHashMap<>();
    public static Player player = new Player();
    public static  World world = new World();

    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        world.addRegions();
        loadGame();
        Quest quest = new Quest();
        System.out.println("***Echoes of the Eternal Shard***");
        if(player.getLevel()== 0) {
            System.out.println("*Welcome to the world of " + world.name + "*\n\n" + world.description);
        }
        if(player.getName().equals("player")) {
            System.out.print("What is your name my friend? ");
            player.setName(userInput.next());
        }
        else
            System.out.println("Welcome back " + player.getName()+ "!");
        if(player.getGameState()==0)
            quest.startQuest(world,player);
        else
            quest.endQuest(world,player);
    }
    public static void updateMap(){
        map.put("name", player.getName());
        map.put("health",String.valueOf(player.getHealth()));
        map.put("level",String.valueOf(player.getLevel()));
        map.put("currency",String.valueOf(player.getCurrency()));
        map.put("weapon",String.valueOf(player.isWeapon()));
        map.put("shards",String.valueOf(player.getShards()));
        map.put("quest",player.getQuest());
        map.put("gamestate",String.valueOf(player.getGameState()));
    }
    public static void saveGame() throws IOException{
        updateMap();
        Path path = Paths.get("data.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write("");
        }
        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
            for(Map.Entry<String, String> entry: map.entrySet()){
                writer.write((entry.getKey())+"="+entry.getValue()+"\n");
            }
        }
    }
    public static void updatePlayer(){
        player.setName(map.get("name"));
        player.setHealth(Integer.parseInt(map.get("health")));
        player.setLevel(Integer.parseInt(map.get("level")));
        player.setCurrency(Integer.parseInt(map.get("currency")));
        player.setWeapon(map.get("weapon").equals("true"));
        player.setShards(Integer.parseInt(map.get("shards")));
        player.setQuest(map.get("quest"));
        player.setGameState(Integer.parseInt(map.get("gamestate")));
    }
    //////Load Game Updates Map and Player//////
    public static void loadGame() throws IOException{
        Path filePath = Paths.get("data.txt");
        map.clear();
        try(BufferedReader reader = Files.newBufferedReader(filePath)){
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split("=",2);
                if(parts.length >1){
                    map.put(parts[0],parts[1]);
                }
            }
        }
        updatePlayer();
    }
}