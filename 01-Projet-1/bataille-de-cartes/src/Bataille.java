import java.util.ArrayList;
import java.util.Collections;

public class Bataille {
  public static void main(String[] args) {

    // Créer le jeu de carte
    ArrayList<Card> deck = new ArrayList<>();
    // Définition de la suite et des numéros de cartes
    String[] names = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi",
        "As" };
    String[] colors = { "Coeur", "Carreau", "Trèfle", "Pique" };

    // Boucles for
    for (String color : colors) {
      for (String name : names) {
        deck.add(new Card(color, name));
      }
    }

    // Mélange aléatoire des packets
    Collections.shuffle(deck);

    // Création des 2 joueurs
    Player player1 = new Player("Pierrot");
    Player player2 = new Player("Felix");

    // Distribution des cartes mélangés.
    for (int i = 0; i < deck.size(); i++) {
      // Le joueur 1 récupére le numéro de carte qui est pair car peut-être divisé par
      // 2.
      if (i % 2 == 0) {
        player1.getCard(deck.get(i));
      } else {
        player2.getCard(deck.get(i));
      }
    }

    // La partie commence => Boucle de jeu
    while (player1.emptyHand() && player2.emptyHand()) {
      Card cardPlayer1 = player1.playCard();
      Card cardPlayer2 = player2.playCard();

      System.out.println(player1.getName() + " : " + cardPlayer1);
      System.out.println(player2.getName() + " : " + cardPlayer2);

      // Comparaison des cartes
      int compareCard = cardPlayer1.getName().compareTo(cardPlayer2.getName());

      if (compareCard > 0) {
        player1.incrementScore(1);
      } else if (compareCard < 0) {
        player2.incrementScore(1);
      }

      // Affichage du score
      System.out.println("-------------");
      System.out.println("Résultat");
      System.out.println("Joueur 1 obtiens : " + player1.getScore() + " points");
      System.out.println("Joueur 2 obtiens : " + player2.getScore() + " points");
      // Chaque manche en dessous du score le nom du joueur est affiché
      if (player1.getScore() > player2.getScore()) {
        System.out.println("-------------");
        System.out.println(player1.getName() + " gagne la manche.");
      } else {
        System.out.println("-------------");
        System.out.println(player2.getName() + " gagne la manche.");
      }
      System.out.println("-------------");

      // Vainqueur de la partie
      // Je permet l'affichage du résultat de la main gagnante que si un des deux
      // joueurs ne possède plus de cartes.
      if (!player1.emptyHand() || !player2.emptyHand()) {
        if (player1.getScore() > player2.getScore()) {
          System.out.println("Final score");
          System.out.println("Joueur 1 gagne la partie.");
          System.out.println("-------------");
        } else if (player1.getScore() < player2.getScore()) {
          System.out.println("Final score");
          System.out.println("Joueur 2 gagne la partie.");
          System.out.println("-------------");
        } else {
          System.out.println("-------------");
          System.out.println("Final score");
          System.out.println("Egalité entre les deux joueurs relancer une partie.");
          System.out.println("-------------");
        }
      }
    }
  }
}