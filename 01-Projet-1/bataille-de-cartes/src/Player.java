import java.util.ArrayList;

public class Player {
  // Attributs nom, score et cartes
  private String name;
  private int score;
  private ArrayList<Card> hand;

  // Constructeur
  public Player(String name) {
    this.name = name;
    hand = new ArrayList<Card>();
    score = 0;
  }

  // Ajout d'une carte dans la main d'un joueur
  public void getCard(Card card) {
    hand.add(card);
  }

  // Pour tirer une carte et la retirer de la liste lorsqu'elle a été joué.
  public Card playCard() {
    if (!hand.isEmpty()) {
      return hand.remove(0);
    }
    return null;
  }

  public int getScore() {
    return score;
  }

  public void incrementScore(int score) {
    this.score = score++;
  }

  // To string
  public void showHand() {
    System.out.println(name + "'s hand: " + hand);
  }
}