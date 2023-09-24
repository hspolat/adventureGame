package src.main.java.com.adventureGame;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public Player player;
    public void start(){
        System.out.println("Welcome to game!!!");
        System.out.println("What's your name?: ");
        String playerName = input.nextLine();
        player =  new Player(playerName);

        System.out.println("""
        ------------------------------
        Now you must select a Hero!
        """);
        player.selectChar();
        System.out.println("Hi " + player.getGameChar().getName() + " " + player.getName() + "!");

        Location location;

        while(true){
            System.out.println("------------------------------");
            player.printInfo();
            System.out.println();
            System.out.println("""
                    --------------- Areas ---------------
                    Select an option (eg 1, 2)
                    
                    SafeHouse: 1 >> You are in safe in this area.\s
                    ToolStore: 2 >> You can buy armor or weapons in this area.
                    Cave     : 3 >> Battle area! Zombies living there.
                    Forest   : 4 >> Battle area! Vampires living there.\s
                    River    : 5 >> Battle area! Bears living there.\s
                    Exit: 0
                    """
            );
            String select = input.nextLine();
            switch (select) {
                case "1" -> location = new SafeHouse(player);
                case "2" -> location = new ToolStore(player);
                case "3" -> {
                    if (this.player.getInventory().isHasFood()) {
                        System.out.println("Your mission was completed in this area! Try another battle area.");
                        continue;
                    } else {
                        location = new Cave(player);
                    }
                }
                case "4" -> {
                    if (this.player.getInventory().isHasFireWood()) {
                        System.out.println("Your mission is completed in this area! Try another battle area.");
                        continue;
                    } else {
                        location = new Forest(player);
                    }
                }
                case "5" -> {
                    if (this.player.getInventory().isHasWater()) {
                        System.out.println("Your mission is completed in this area! Try another battle area.");
                        continue;
                    } else {
                        location = new River(player);
                    }
                }
                case "0" -> location = null;
                default -> location = new SafeHouse(player);
            }

            if (location == null){
                System.out.println(location);
                System.out.println("Good Bye..");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
            if(this.player.getInventory().isHasWater() && this.player.getInventory().isHasFood() && this.player.getInventory().isHasFireWood()) {
                System.out.println("""
                        ***********************************************************************************
                        *                                  Y O U  W I N                                   *
                        ***********************************************************************************                             
                        """);
                break;
            }
        }

    }
}
