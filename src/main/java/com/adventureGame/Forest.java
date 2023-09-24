package src.main.java.com.adventureGame;

public class Forest  extends BattleLoc{
    public Forest(Player player){
        super(player, "Forest", new Vampire(), "Fire Wood", 3, true);
    }
}
