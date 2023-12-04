package game;

public class Store {
    private static final int[][] STORE_INVENTORY = {
            { 3, 5, 10 }, // Item 1: coût 3 pièces d'or, bénéfice 5
            { 2, 8, 15 }, // Item 2: coût 2 pièces d'or, bénéfice 8
            { 5, 12, 20 }, // Item 3: coût 5 pièces d'or, bénéfice 12
    };

    private int gold;

    public Store() {
        this.gold = 0;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void displayStore() {
        System.out.println("Bienvenue au magasin ! Voici nos articles :");
        System.out.println("ID\tCoût\tBénéfice");
        for (int i = 0; i < STORE_INVENTORY.length; i++) {
            System.out.println((i + 1) + "\t" + STORE_INVENTORY[i][0] + "\t\t" + STORE_INVENTORY[i][1]);
        }
    }

    public boolean buyItem(int itemId) {
        if (itemId < 1 || itemId > STORE_INVENTORY.length) {
            System.out.println("ID d'article non valide.");
            return false;
        }

        int[] item = STORE_INVENTORY[itemId - 1];

        if (gold < item[0]) {
            System.out.println("Vous n'avez pas assez d'or pour acheter cet article.");
            return false;
        }

        gold -= item[0];
        System.out.println("Article acheté avec succès! Vous avez maintenant " + gold + " pièces d'or restantes.");
        // Ajoutez ici la logique pour appliquer les effets de l'achat, par exemple,
        // augmenter certaines valeurs du joueur.

        return true;
    }
}