package src.main.java.com.adventureGame;

public class Armor {
    private int id;
    private String name;
    private int defense;
    private int price;

    public Armor(int id, String name, int defense, int price){
        this.id = id;
        this.name = name;
        this.defense = defense;
        this.price = price;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public static Armor[] armors(){
        Armor[] armors = new Armor[3];
        armors[0] = new Armor(1, "Light", 1, 20 );
        armors[1] = new Armor(2, "Medium", 3, 30);
        armors[2] = new Armor(3, "Heavy", 5, 40);
        return armors;
    }

    public static Armor getArmorById(int id){
        for (Armor a: armors()) {
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }
}
