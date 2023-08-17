package src.main.java.com.adventureGame;;
import java.util.Scanner;


public class Game {
    private Scanner input = new Scanner(System.in);
    public Player player;
    public Location location;
    public void start(){
        System.out.println("Welcome to game!!!");
        System.out.println("What's your name?: ");
        String playerName = input.nextLine();
        player =  new Player(playerName);

        System.out.println("Game is starting! You must select a hero!");
        System.out.println("For Samurai type 1,\nFor Archer type 2,\nFor Knight type 3\n\nChoice? : ");
        String select = input.nextLine();
        player.selectChar(select);

        System.out.println("Hi " + player.getCharName() + " " + player.getName() + "!");
    };




}
