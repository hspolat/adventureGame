package src.main.java.com.adventureGame;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private boolean isOpen;
    Scanner input = new Scanner(System.in);

    BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle, boolean isOpen) {
        super(player, name);
        this.obstacle = obstacle;
        this.award  = award;
        this.maxObstacle = maxObstacle;
        this.isOpen = true;
    }
    public boolean onLocation(){
        int obsNumber = this.randomObstacleNumber();
        System.out.println("You're in " + this.getName() + "! " + obsNumber + " " + this.obstacle.getName() + "'s live here! \nBe careful!");
        System.out.println("What do you want to do here?");
        System.out.println("\nFİGHT >> Type F" +
                "\nRetreat >> Type R");

        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F") && combat(obsNumber)){
            System.out.println("You kill all " + this.getObstacle().getName() + "'s in " +  this.getName() + "!");
            this.setAwardStatus(this.getAward());
            System.out.println("You earn " + this.getAward() + "!");
            this.setOpen(false);
            return true;
        }
        return this.getPlayer().getHealthy() > 0;
    }

    public boolean combat(int maxObstacle){
        for (int i = 1; i <= maxObstacle; i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);

            Random rnd = new Random();
            int firstFire = rnd.nextInt(2);

            while (this.getObstacle().getHealth() > 0 && this.getPlayer().getHealthy() > 0){
                System.out.println("<F>ight or <R>un : ?");
                String selectCombatOption = input.nextLine().toUpperCase();

                if(selectCombatOption.equals("F")){
                    if(firstFire == 0){
                        System.out.println("You hitted the monster!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                        afterHit();
                        if(this.getObstacle().getHealth() <= 0){
                            System.out.println("You killed the " + i + ". " + this.getObstacle().getName() + "!");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                            continue;
                        }
                    } else if(firstFire == 1) {
                        System.out.println();
                        System.out.println("The obstacle hitted you!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefense();
                        if(obstacleDamage < 0 ){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                        afterHit();

                    } else{
                        System.out.println("You hitted the monster!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
                        afterHit();
                        if(this.getObstacle().getHealth() <= 0){
                            System.out.println("You killed the " + i + ". " + this.getObstacle().getName() + "!");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                            continue;
                        }

                        System.out.println();
                        System.out.println("The obstacle hitted you!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefense();
                        if(obstacleDamage < 0 ){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                        afterHit();
                    }
                    firstFire = -1;

                } else {
                    return false;
                }
            }
        }
        if(this.getPlayer().getHealthy() <= 0){
            System.out.println("You're dead..");
        }
        return this.getPlayer().getHealthy() > 0;
    }

    public void afterHit() {
        System.out.println("Your Health: " + this.getPlayer().getHealthy());
        System.out.println("Obstacles Health: " + this.getObstacle().getHealth());
        System.out.println("---------");
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
        System.out.println();
    }

    public void obstacleStats(int i){
        System.out.println(i + ". Obstacle's Status");
        System.out.println("--------------------------------------");
        System.out.println("Obstacle: " + this.getObstacle().getName());
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println();
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

    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setAwardStatus(String award){
        switch (award){
            case "Food" -> this.getPlayer().getInventory().setHasFood(true);
            case "Water" -> this.getPlayer().getInventory().setHasWater(true);
            case "Fire Wood" -> this.getPlayer().getInventory().setHasFireWood(true);
        }
    }

}
