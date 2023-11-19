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
        System.out.println("Available weapons in the store :");
        int index = 0;
        for (Weapon w : this.weaponsList) {
            System.out.println("[" + index + "] " + w.toString() + "\n" + w.ascii_art());
            index++;
        }
    }

    public Weapon getWeapon(int index) {
        return this.weaponsList.get(index);
    }
}
