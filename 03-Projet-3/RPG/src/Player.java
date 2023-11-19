import java.util.ArrayList;

public class Player implements ActionsPlayer {

    private String name;
    private int life;
    private ArrayList<Weapon> weapons;
    private double money;
    Caste caste;

    public Player(String name, int life, double money, Caste caste) {
        this.name = name;
        this.life = life;
        this.money = 50;
        this.weapons = new ArrayList<Weapon>();
        this.caste = caste;
    }

    public String getName() {
        return this.name;
    }

    public String getCaste() {
        return this.caste.getCaste();
    }

    public int getLifeBonus() {
        return this.caste.getLifeBonus();
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public int getLife() {
        return this.life;
    }

    public double getMoney() {
        return this.money;
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
