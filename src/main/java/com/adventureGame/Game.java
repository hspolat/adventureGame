package src.main.java.com.adventureGame;

import java.sql.SQLOutput;
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
        Now you must select a Hero!\s 
        """);
        player.selectChar();
        System.out.println("Hi " + player.getGameChar().getName() + " " + player.getName() + "!");

        Location location = null;

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
            location = switch (select) {
                case "1" -> new SafeHouse(player);
                case "2" -> new ToolStore(player);
                case "3" -> new Cave(player);
                case "4" -> new Forest(player);
                case "5" -> new River(player);
                case "0" -> null;
                default -> new SafeHouse(player);
            };
            if (location == null){
                System.out.println("Good Bye..");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }

    }
}
