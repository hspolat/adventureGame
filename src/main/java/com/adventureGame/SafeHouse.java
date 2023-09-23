package src.main.java.com.adventureGame;

public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house. your health was fulled");
        this.getPlayer().setHealthy(this.getPlayer().getGameChar().getDefaultHealth());
        System.out.println("your health: " + this.getPlayer().getHealthy());
        return true;
    }
}
