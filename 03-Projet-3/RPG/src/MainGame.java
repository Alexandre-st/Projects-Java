import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Quel est ton prénom :");
            String name = scanner.nextLine();

            // Add castes
            Caste elfe = new Caste("Elfe", 10, 5);
            Caste orc = new Caste("Orc", 5, 10);
            Caste mage = new Caste("Mage", 15, 15);
            Caste warrior = new Caste("Guerrier", 20, 10);

            System.out.println("Choisissez une caste :");
            System.out.println("1. Elfe");
            System.out.println("2. Orc");
            System.out.println("3. Mage");
            System.out.println("4. Guerrier");

            int casteChoice = scanner.nextInt();
            Caste castChoose;

            switch (casteChoice) {
                case 1:
                    castChoose = elfe;
                    break;
                case 2:
                    castChoose = orc;
                    break;
                case 3:
                    castChoose = mage;
                    break;
                case 4:
                    castChoose = warrior;
                    break;
                default:
                    castChoose = orc; // default caste
                    break;
            }

            Player p = new Player(name, 100, 50, castChoose);

            System.out.println("Je m'apelle " + p.getName() + ", " +
                    "je suis un " + p.getCaste() + "." + " Je possède "
                    + p.getLife() + " points de vie et " + p.getMoney() + " pièces d'or.");

            WeaponStore store = new WeaponStore();

            while (true) {
                System.out.println("Que voulez-vous faire ?");
                System.out.println("1. Acheter une arme");
                System.out.println("2. Quitter le magasin");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        store.printWeaponsList();
                        System.out.println("Alors Quelle arme voulez-vous acheter ?");
                        int weaponChoice = scanner.nextInt();
                        p.buyWeapon(store.buyWeapon(weaponChoice));
                        System.out.println("Il vous reste donc " + p.getMoney() + " pièces d'or.");
                        break;
                    case 2:
                        System.out.println("Vous quittez le magasin.");
                        break;
                    default:
                        System.out.println("Choix invalide.");
                        break;
                }
                break;
            }
        }

    }
}