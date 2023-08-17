package src.main.java.com.adventureGame;
public abstract class Location {
    Player player;
    String name;
    Location(Player player, String name){

    };
    boolean onLocation(){
        return true;
    };
}
