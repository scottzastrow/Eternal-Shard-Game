/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/
import java.util.ArrayList;

public class Region {
    String regionName;
    String regionDescription;
    ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>();
    ArrayList<NPC> npcs = new ArrayList<NPC>();
    ArrayList<Inventory> stuff = new ArrayList<Inventory>();

    public Region(){}
    public Region(String regionName, String regionDescription){
        this.regionName = regionName;
        this.regionDescription = regionDescription;
    }
    public void addPuzzle(Puzzle puzzle){
        puzzles.add(puzzle);
    }
    public void addNPC(NPC npc){
        npcs.add(npc);
    }
    public void addInventory(Inventory inventory){
        stuff.add(inventory);
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }
}
