package src.main.java.com.adventureGame;
public class Player {
    //public Inventory inventory;
    private int damage;
    private int healthy;
    private int money;
    private String name;
    private String charName;
    public void selectChar(String input){
        switch (input){
            case "1":
                initPlayer(new Samurai());
                break;
            case "2":
                initPlayer(new Archer());
                break;
            case "3":
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
    }
    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamege());
        this.setMoney(gameChar.getMoney());
        this.setHealthy(gameChar.getHealth());
    }
    public Player(String name){
        this.name = name ;
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

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

}
