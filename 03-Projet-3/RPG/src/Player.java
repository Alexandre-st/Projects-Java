import java.util.ArrayList;

public class Player implements ActionsPlayer {

    private String name;
    private ArrayList<Weapon> weapons;
    private double money;

    public Player(String name) {
        this.name = name;
        this.money = 50;
        this.weapons = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    @Override
    public void buyWeapon(Weapon w) {
        if (w.getPrice() <= this.money) {
            this.weapons.add(w);
            this.money -= w.getPrice();
        } else {
            System.out.println("You do not have enough money to buy this! " +
                    "(your money : " + this.money + " - weapon price : " + w.getPrice());
        }

    }

}
