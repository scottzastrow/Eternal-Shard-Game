/*
Java Code Author: Scott Zastrow
StoryLine Author: ChatGPT
Course: SEIS_610
Date: 12/04/24
Project: Hackathon
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quest {
    private int gameLevel;
    private String choice;
    private int decision;
    ArrayList<String> conflict = new ArrayList<>();

    Scanner userInput = new Scanner(System.in);

    public void startQuest(World world, Player player) throws IOException {
        gameLevel = player.getLevel();
        player.setQuest(world.regions.get(gameLevel).regionName);
        System.out.println("\nYou are currently in the " + world.regions.get(gameLevel).getRegionName());
        System.out.println(player.getName()+", "+ world.regions.get(gameLevel).regionDescription);
        System.out.print("Do you wish to continue Y | N: ");
        choice = userInput.next();
        if (choice.equals("y") || choice.equals("Y")) {
            displayMenu(player);
            GameManager.saveGame();
            conflictOne(world, player);
        }
        else {
            GameManager.saveGame();
            System.exit(0);
        }
        endQuest(world,player);
    }
    public void endQuest(World world, Player player) throws IOException {
        if(player.getLevel()<3) {
            System.out.print("Do you wish to continue Y | N: ");
            choice = userInput.next();
            if (choice.equals("y") || choice.equals("Y")) {
                displayMenu(player);
                GameManager.saveGame();
                conflictTwo(world, player);
            } else {
                GameManager.saveGame();
                System.exit(0);
            }
        }
        else
            closeQuest(world,player);
    }
    public void conflictOne(World world, Player player) throws IOException {
        System.out.println(world.regions.get(gameLevel).npcs.getFirst().getDescription());
        System.out.print("What is your decision? ");
        decision = userInput.nextInt();
        if(decision == 1){
            fightBattleOne(world,player);
        }
        else if(decision == 2){
            getPuzzleOne(world);
            conflictMenu();
            decision = userInput.nextInt();
            if(decision == 1){
                getAnswerOne(world, player);
            }
            else  if(decision == 2){
                getHintOne(world);
                getAnswerOne(world, player);
            }
        }
        else if(decision == 3){
            withdrawCoins(world,player,5);
        }
    }
    public void conflictTwo(World world, Player player) throws IOException {
        System.out.println(world.regions.get(gameLevel).npcs.getLast().getDescription());
        System.out.print("What is your decision? ");
        decision = userInput.nextInt();
        if(decision == 1){
            fightBattleTwo(world,player);
        }
        else if(decision == 2){
            getPuzzleTwo(world);
            conflictMenu();
            decision = userInput.nextInt();
            if(decision == 1){
                getAnswerTwo(world, player);
            }
            else  if(decision == 2){
                getHintTwo(world);
                getAnswerTwo(world, player);
            }
        }
        else if(decision == 3){
            withdrawCoins(world,player,7);
        }
    }
    public void fightBattleOne(World world, Player player) throws IOException {
        int enemy = world.regions.get(gameLevel).npcs.getFirst().getAttackPower();
        int challenger = player.getHealth();
        if(challenger-enemy<0){
            System.out.println("Sorry you are not strong enough to defeat " + world.regions.get(gameLevel).npcs.getFirst().getName());
            conflictOne(world,player);
        }
        else{
            player.takeDamage(enemy);
            player.addShard(1);
            player.setGameState(1);
            GameManager.saveGame();
            System.out.println("You are Victorious against " + world.regions.get(gameLevel).npcs.getFirst().getName());
            endQuest(world,player);
        }
    }
    public void fightBattleTwo(World world, Player player) throws IOException {
        int enemy = world.regions.get(gameLevel).npcs.getLast().getAttackPower();
        int challenger = player.getHealth();
        if(challenger-enemy<0 && player.getShards()<6){
            System.out.println("Sorry you are not strong enough to defeat " + world.regions.get(gameLevel).npcs.getLast().getName());
            conflictTwo(world,player);
        }
        else{
            player.takeDamage(enemy);
            player.addShard(1);
            System.out.println("Shards: " +player.getShards());
            player.setGameState(0);
            player.levelUp();
            GameManager.saveGame();
            System.out.println("You are Victorious against " + world.regions.get(gameLevel).npcs.getLast().getName());
            if(player.getLevel()<3) {
                startQuest(world, player);
            }
            else
                closeQuest(world,player);
        }
    }
    public void withdrawCoins(World world, Player player, int coins) throws IOException {
        if(player.getCurrency()-coins < 0){
            System.out.println("Sorry you don't have enough coins. Want to Try something else?");
            if(player.getGameState()==0) {
                conflictOne(world, player);
            }
            else if(player.getGameState()==1){
                conflictTwo(world,player);
            }
        }
        else{
            player.setCurrency(player.getCurrency()-coins);
            player.addShard(1);
            if(player.getGameState() == 0) {
                System.out.print(world.regions.get(gameLevel).npcs.getFirst().getName() + " Has accepted your offer!\n");
                player.setGameState(1);
            }
            else if(player.getGameState() == 1) {
                System.out.print(world.regions.get(gameLevel).npcs.getLast().getName() + " Has accepted your offer!\n");
                player.setGameState(0);
                player.levelUp();
                if(player.getLevel()<3) {
                    startQuest(world, player);
                }
                else
                    closeQuest(world,player);
            }
            GameManager.saveGame();
        }
    }
    public void getPuzzleOne(World world){
        System.out.println("\nSolve this riddle: \n");
        System.out.println(world.regions.get(gameLevel).puzzles.getFirst().getQuestion());
    }
    public void getPuzzleTwo(World world){
        System.out.println("\nSolve this riddle: \n");
        System.out.println(world.regions.get(gameLevel).puzzles.getLast().getQuestion());
    }
    public void getHintOne(World world){
        System.out.println(world.regions.get(gameLevel).puzzles.getFirst().getHint());
    }
    public void getHintTwo(World world){
        System.out.println(world.regions.get(gameLevel).puzzles.getLast().getHint());
    }
    public void getAnswerOne(World world, Player player) throws IOException {
        String correctAnswer = world.regions.get(gameLevel).puzzles.getFirst().getAnswer();
        int answerNumber =0;
        System.out.println("You have 4 choices:");
        List<String> abcd = new ArrayList<>();
        abcd.add(world.regions.get(gameLevel).puzzles.getFirst().getAltAnswerOne());
        abcd.add(world.regions.get(gameLevel).puzzles.getFirst().getAltAnswerTwo());
        abcd.add(world.regions.get(gameLevel).puzzles.getFirst().getAltAnswerThree());
        abcd.add(world.regions.get(gameLevel).puzzles.getFirst().getAnswer());
        Collections.shuffle(abcd);
        for(int i=0; i<abcd.size();i++) {
            if (abcd.get(i).equals(world.regions.get(gameLevel).puzzles.getFirst().getAnswer())){
                correctAnswer = abcd.get(i);
                answerNumber = i+1;
        }
            System.out.println(i+1 +". " + abcd.get(i));
        }
        System.out.print("Your Answer: ");
        decision = userInput.nextInt();
        if(decision == answerNumber){
            System.out.println("Correct! The Answer is " + correctAnswer);
            player.addShard(1);
            player.setGameState(1);
            GameManager.saveGame();
        }
        else{
            System.out.println("Incorrect. Try Again or Try something else.");
            conflictOne(world,player);
        }

    }
    public void getAnswerTwo(World world,Player player) throws IOException {
        String correctAnswer = world.regions.get(gameLevel).puzzles.getLast().getAnswer();
        int answerNumber =0;
        System.out.println("You have 4 choices:");
        List<String> abcd = new ArrayList<>();
        abcd.add(world.regions.get(gameLevel).puzzles.getLast().getAltAnswerOne());
        abcd.add(world.regions.get(gameLevel).puzzles.getLast().getAltAnswerTwo());
        abcd.add(world.regions.get(gameLevel).puzzles.getLast().getAltAnswerThree());
        abcd.add(world.regions.get(gameLevel).puzzles.getLast().getAnswer());
        Collections.shuffle(abcd);
        for(int i=0; i<abcd.size();i++) {
            if (abcd.get(i).equals(world.regions.get(gameLevel).puzzles.getLast().getAnswer())){
                correctAnswer = abcd.get(i);
                answerNumber = i+1;
            }
            System.out.println(i+1 +". " + abcd.get(i));
        }
        System.out.print("Your Answer: ");
        decision = userInput.nextInt();
        if(decision == answerNumber){
            System.out.println("Correct! The Answer is " + correctAnswer);
            player.addShard(1);
            player.setGameState(0);
            player.levelUp();
            GameManager.saveGame();
            if(player.getLevel()<3) {
                startQuest(world, player);
            }
            else
                closeQuest(world,player);
        }
        else{
            System.out.println("Incorrect. Try Again or Try something else.");
            conflictTwo(world,player);
        }
    }
    public void conflictMenu(){
        System.out.println("""
                You have two choices:
                1.	Solve the Riddle
                2.	Get a little Hint""");
        System.out.print("What say you? ");
    }
    public void displayMenu(Player player) {
        String theMenu = "\n"+player.getName()+ " | Quest: " + player.getQuest() + " | Health: " + player.getHealth() + " | Coins: " + player.getCurrency() + " | Shards " + player.getShards()+" | Level "+ (gameLevel+1);
        System.out.println(theMenu);
        for (int i = 0; i < theMenu.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public void closeQuest(World world, Player player){
        System.out.println("*******"+"Thanks for Playing "+"*******");
        System.out.println("******Echoes of the Eternal Shard******");
        System.out.println("""
                
                  You place the shards in the center of the Voidcaller’s realm,
                  initiating the ritual. A brilliant light erupts, engulfing the
                  Voidcaller. The shadows scream and writhe, consumed by the radiance.
                  As the light fades, the Voidcaller is no more. The shards, now spent,
                  dissolve into golden dust that spreads across the land, restoring life and balance.""");
        player.setShards(0);
        displayMenu(player);
    }
}
