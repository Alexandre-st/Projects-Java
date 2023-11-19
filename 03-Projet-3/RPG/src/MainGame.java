import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a name :");
        String name = scanner.nextLine();
        // String name = "a";
        Player p = new Player(name);
        System.out.println("Player name : " + p.getName());

        WeaponStore store = new WeaponStore();
        store.printWeaponsList();

        p.buyWeapon(store.getWeapon(0));

    }
}
