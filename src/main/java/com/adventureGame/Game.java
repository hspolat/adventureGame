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

        player.selectChar();
        System.out.println("###########################################");
        System.out.println("Hi " + player.getCharName() + " " + player.getName() + "!");

        Location location = null;

        while(true){

            System.out.println("Game is starting! Select an option.");
            System.out.println("################## Areas #########################\nSafeHouse: 1 >> You are in safe in this area. \nToolStore: 2 >> You can buy armor or weapons in this area.");
            String select = input.nextLine();
            switch (select){
                case "1":
                    location = new SafeHouse(player);
                    break;
                case "2":
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }

    };




}
