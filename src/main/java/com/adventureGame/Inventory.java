package src.main.java.com.adventureGame;
public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean isHasWater;
    private boolean isHasFireWood;
    private boolean isHasFood;
    public Inventory(){
        this.weapon = new Weapon("Fist", -1,0,0);
        this.armor = new Armor(-1, "Elbow", 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isHasWater() {
        return isHasWater;
    }

    public void setHasWater(boolean hasWater) {
        isHasWater = hasWater;
    }

    public boolean isHasFireWood() {
        return isHasFireWood;
    }

    public void setHasFireWood(boolean hasFireWood) {
        isHasFireWood = hasFireWood;
    }

    public boolean isHasFood() {
        return isHasFood;
    }

    public void setHasFood(boolean hasFood) {
        isHasFood = hasFood;
    }
}
