import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public Player player;
    public Location location;
    public void start(){
        System.out.println("Macera Oyununa Hoş Geldiniz!!!");
        System.out.println("İsim giriniz: ");
        String playerName = input.nextLine();
        player =  new Player(playerName);
        System.out.println(player.getName() + " Merhaba! Oyun başlıyor!");
    };




}
