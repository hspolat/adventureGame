package src.main.java.com.adventureGame;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    Scanner input = new Scanner(System.in);

    BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award  = award;
        this.maxObstacle = maxObstacle;
    }
    public boolean onLocation(){
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You're in " + this.getName() + "! " + obsNumber + " " + this.obstacle.getName() + "'s live here! \nBe careful!");
        System.out.println("What do you want to do here?");
        System.out.println("\nFİGHT >> Type F" +
                "\nRetreat >> Type R");

        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")){
            System.out.println("The war processes are activated. Hold your position.");
        }
        return true;
    }

    public boolean combat(int maxObstacle){
        for (int i = 1; i <= maxObstacle; i++){
            playerStats();
            obstacleStats();
            while (this.getObstacle().getHealth() > 0 && this.getPlayer().getHealthy() > 0){
                System.out.println("<F>ight or <R>un : ?");
                String selectCombatOption = input.nextLine().toUpperCase();
                if(selectCombatOption == "F"){

                }

            }
        }
        return false;
    }

    public void playerStats(){
        System.out.println("Gamer status");
        System.out.println("--------------------------------------");
        System.out.println("Health: " + this.getPlayer().getHealthy());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Damage: " + this.getPlayer().getDamage());
        System.out.println("Block/Defense: " + this.getPlayer().getInventory().getArmor().getDefense());
        System.out.println("Money: " + this.getPlayer().getMoney());
    }

    public void obstacleStats(){
        System.out.println("Obstacle Status");
        System.out.println("--------------------------------------");
        System.out.println("Obstacle: " + this.getObstacle().getName());
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getHealth());
        System.out.println("Award: " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber(){
        Random rnd = new Random();
        return rnd.nextInt(this.maxObstacle) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
