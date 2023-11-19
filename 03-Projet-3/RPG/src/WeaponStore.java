import java.util.ArrayList;

public class WeaponStore {

    private ArrayList<Weapon> weaponsList;

    public WeaponStore() {
        this.weaponsList = new ArrayList<Weapon>();
        this.weaponsList.add(new Bow());
        this.weaponsList.add(new Axe());
        this.weaponsList.add(new Hammer());
    }

    public void printWeaponsList() {
        System.out.println("Armes disponibles dans le magasin :");
        int index = 0;
        for (Weapon w : this.weaponsList) {
            System.out.println("[" + index + "] " + w.toString() + "\n" + w.ascii_art());
            index++;
        }
    }

    // public Weapon getWeapon(int index) {
    // return this.weaponsList.get(index);
    // }

    public Weapon buyWeapon(int choice) {
        if (choice >= 1 && choice <= weaponsList.size()) {
            System.out.println("Vous avez acheté " + weaponsList.get(choice - 1).toString() + " pour "
                    + weaponsList.get(choice - 1).getPrice() + " pièces d'or.");
            return weaponsList.get(choice - 1);
        } else {
            System.out.println("Vous n'avez pas assez d'argent pour acheter cette arme. Choisissez-en une autre.");
            return null;
        }
    }
}
