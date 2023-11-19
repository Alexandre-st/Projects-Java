public class Hammer extends Weapon {

    private static final double DAMAGE = 20;
    private static final double PRICE = 10;

    public Hammer() {
        super("Marteau", DAMAGE, PRICE);
    }

    @Override
    public String ascii_art() {
        return "             +-+\n" +
                "=============| |\n" +
                "            `:_;'";
    }
}
