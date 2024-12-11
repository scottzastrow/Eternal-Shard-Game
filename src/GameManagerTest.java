/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    @org.junit.jupiter.api.Test
    void verifyPlayerName() {
        Player player = new Player();
        player.setName("Scott");
        assertEquals("Scott", player.getName());
    }

    @org.junit.jupiter.api.Test
    void verifyRegionName(){
        Region region = new Region();
        region.setRegionName("Carpathian Mountains");
        assertEquals("Carpathian Mountains", region.regionName);
    }
}