package src.main.java.com.adventureGame;
import java.util.ArrayList;
import java.util.List;

public abstract class  GameChar {
    private int damage;
    private int id;
    private int health;
    private int money;
    private String name;
    public GameChar(int id, int damage, int health, int money, String name){
        this.id = id;
        this.damage = damage;
        this.money = money;
        this.health = health;
        this.name = name;
    }

    public int getDamege() {
        return damage;
    }

    public void setDamege(int damege) {
        this.damage = damege;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
