package src.main.java.com.adventureGame;

import java.util.Timer;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Store");
    }
    @Override
    public boolean onLocation() {
        System.out.println("###########################################");
        System.out.println("This is store! you can buy weapons and armors for your hero.");
        System.out.println("1 - Weapons");
        System.out.println("2 -  Armors");
        System.out.println("3 - Leave Store");
        System.out.print("Your choice?: ");
        int selectedCase = scanner.nextInt();

        while(selectedCase < 1 || selectedCase > 3){
            System.out.println("Geçersiz değer. Tekrar deneyiniz.");
            selectedCase = scanner.nextInt();
        }

        switch (selectedCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("we are waiting for you again! Enjoy the game");
                break;
            default:
                System.out.println("Wrong choice. You're led to weapon store");
                printWeapon();
        }
        return true;
    }

    public void printWeapon(){

        System.out.println("################ Weapons #################");
        System.out.println("Select an option: ");
        for(Weapon w: Weapon.weapons() ){
            System.out.println(w.getId() + "-" + w.getName() + ": Damage > " + w.getDamage() + ", Price > " + w.getPrice());
        }
    }

    public void buyWeapon(){
        int selectedItem = scanner.nextInt();
        while(selectedItem < 1 || selectedItem > Weapon.weapons().length){
            System.out.println("Wrong choice. Try again");
            selectedItem = scanner.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponById(selectedItem);
        if (selectedWeapon != null){

            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You're poor. Earn some money or select another weapon!");
            } else {

                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("You've bought the " + selectedWeapon.getName() + " weapon!");
                System.out.println("Your current money: " + getPlayer().getMoney());
                System.out.println("###########################################");
                System.out.println("Eski silahın: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Your new weapon: " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }

    public void printArmor(){
        System.out.println("################ Armors #################");
        System.out.println("Select an option: ");
        for(Armor a: Armor.armors() ){
            System.out.println(a.getId() + "-" + a.getName() + ": Damage > " + a.getDefense() + ", Price > " + a.getPrice());
        }
    }

    public void buyArmor(){
        int selectedItem = scanner.nextInt();
        while(selectedItem < 1 || selectedItem > Armor.armors().length){
            System.out.println("Wrong choice. Try again");
            selectedItem = scanner.nextInt();
        }

        Armor selectedArmor = Armor.getArmorById(selectedItem);
        if (selectedArmor != null){

            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You're poor. Earn some money or select another armor!");
            } else {
                System.out.println("You've bought the " + selectedArmor.getName() + " armor!");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your current money: " + getPlayer().getMoney());
            }
        }
    }

}
