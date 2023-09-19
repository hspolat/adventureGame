package src.main.java.com.adventureGame;

public class Cave extends BattleLoc{
    public Cave(Player player){
        super(player, "Cave", new Zombie(), "food", 3);
    }
}
