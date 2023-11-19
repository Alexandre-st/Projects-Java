import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Quel est ton prénom :");
            String name = scanner.nextLine();

            // Add castes
            Caste elfe = new Caste("Elfe", 10, 5);
            Caste orc = new Caste("Orc", 05, 10);
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
            }

            Player p = new Player(name, 100, 50, castChoose);

            System.out.println("Je m'apelle " + p.getName() + ", " +
                    "je suis un " + p.getCaste() + "." + " Je possède "
                    + (p.getLife() + p.getLifeBonus()) + " points de vie et " + p.getMoney() + " pièces d'or.");
            WeaponStore store = new WeaponStore();

            while (true) {
                System.out.println("Que voulez-vous faire ?");
                System.out.println("1. Acheter une arme");
                System.out.println("2. Entrer sur la map vers le château de la mort");
                System.out.println("3. Fuir le combat");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        store.printWeaponsList();
                        System.out.println("Alors quelle arme voulez-vous acheter ?");
                        int weaponChoice = scanner.nextInt();
                        p.buyWeapon(store.buyWeapon(weaponChoice));
                        System.out.println("Il vous reste donc " + p.getMoney() + " pièces d'or.");
                        break;
                    case 2:
                        System.out.println(
                                "Bienvenue sur les terres de la mort. Faites attention ce monde est parcouru d'obstacles et de monstres.");
                        System.out.println(
                                "Vous êtes actuellement dans la forêt des ténèbres. Vous devez vous rendre au château de la mort.");
                        System.out.println("Utilisez les touches Z, Q, S, D pour vous déplacer.");

                        Carte carte = new Carte(10, 10);

                        while (true) {
                            carte.showCarte();

                            System.out.println("Entrez une direction : (Haut : Z, Gauche : Q, Droite : S, Bas : W)");
                            char direction = scanner.next().charAt(0);

                            int moveX = 0;
                            int moveY = 0;

                            switch (Character.toUpperCase(direction)) {
                                case 'Z':
                                    moveX = -1;
                                    break;
                                case 'W':
                                    moveX = 1;
                                    break;
                                case 'Q':
                                    moveY = -1;
                                    break;
                                case 'D':
                                    moveY = 1;
                                    break;
                                default:
                                    System.out.println("Direction invalide. Veuillez recommencer.");
                            }
                            carte.movePlayer(moveX, moveY);

                            if (carte.isGoal()) {
                                System.out.println(
                                        "Felicitations Champion ! Tu es en vie, c'est ici que nos chemins se séparent.");
                                System.exit(0);
                                break;
                            }
                        }
                    case 3:
                        System.out.println("Vous fuyez le combat.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez recommencer.");
                }
            }
        }

    }
}