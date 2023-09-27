package src.main.java.com.adventureGame;

import java.util.Random;

public class Mine extends BattleLoc{
    public Mine(Player player){
        super(player, "Mine", new Snake(), "No Award", 5);
    }

}
