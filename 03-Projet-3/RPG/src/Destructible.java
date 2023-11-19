public class Destructible {

    protected double life = 100.;

    public Destructible(double hp) {
        this.life = hp;
    }

    public double getLife() {
        return this.life;
    }

    public void hit(double damage) {
        this.life -= damage;

        if (this.life <= 0) {
            System.out.println("Le monstre est mort ! Bien joué champion !");
            // System.exit(0);
        } else {
            System.out.println("Aie ça pique. Le monstre a subi" + damage + ". Il lui reste encore " + this.life
                    + " points de vie.");
        }
    }

}
