package src.main.java.com.adventureGame;
import java.util.Scanner;
public class Player {
    private int damage;
    private int healthy;
    private int money;
    private String name;
    //private String charName;
    private GameChar gameChar;
    private Inventory inventory;
    public static Scanner input =  new Scanner(System.in);
    public void selectChar(){
        System.out.println("For Samurai type 1,\nFor Archer type 2,\nFor Knight type 3\n\nChoice? : ");
        String select = input.nextLine();
        switch (select){
            case "1":
                this.setGameChar(new Samurai());
                break;
            case "2":
                this.setGameChar(new Archer());
                break;
            case "3":
                this.setGameChar(new Knight());
                break;
            default:
                this.setGameChar(new Samurai());
        }
    }

    public Player(String name){
        this.name = name;
        this.inventory =  new Inventory();
    }

    public void printInfo(){
        System.out.println("Your Weapon: " + this.getInventory().getWeapon().getName()
        + "\n Your damage: " + this.getDamage()
        + "\n Your health: " + this.getHealthy()
        + "\n Your Defense Block: " + this.getInventory().getArmor().getDefense()
        + "\n your money: " + this.getMoney());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if(healthy < 0) {
            healthy = 0;
        }
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public String getCharName() {
        return charName;
    }
     */

    /*
    public void setCharName(String charName) {
        this.charName = charName;
    }
     */

    public GameChar getGameChar() {
        return gameChar;
    }

    public void setGameChar(GameChar gameChar) {
        this.gameChar = gameChar;
        this.damage = gameChar.getDamage();
        this.healthy = gameChar.getHealth();
        this.money = gameChar.getMoney();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
