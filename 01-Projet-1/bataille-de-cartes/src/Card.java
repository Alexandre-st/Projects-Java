public class Card {
  // Attributs couleur et noms (valeurs)
  private String color;
  private String name;

  // Constructeur (de ma carte)
  public Card(String color, String name) {
    this.color = color;
    this.name = name;
  }

  // Getters pour couleur et nom
  public String getColor() {
    return color;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name + " de " + color;
  }
}
