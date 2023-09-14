package src.main.java.com.adventureGame;

public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("your health: " + this.getPlayer().getHealthy());
        System.out.println("You are in safe house. your health was fulled");
        //player.setHealthy();
        System.out.println("your new hea");
        return true;
    }
}
