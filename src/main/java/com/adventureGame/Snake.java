package src.main.java.com.adventureGame;

import java.util.Random;

public class Snake extends Obstacle{
    private int damage;
    Random rnd = new Random();
    public Snake() {
       super(5, "Snake", 12, 12);
    }
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
