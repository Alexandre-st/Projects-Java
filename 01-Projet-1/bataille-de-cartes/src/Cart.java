public class Cart {
  // Attributs couleur et noms (valeurs)
  private String name;
  private String color;
  // Définition de la suite et des numéros de cartes
  private static String[] names = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
      "14" };
  private static String[] colors = new String[] { "Coeurs", "Carreaux", "Trèfles", "Piques" };

  // Constructeur (de ma carte)
  public Cart(String color, String name) {
    this.color = color;
    this.color = name;
  }

  // Getters pour couleur et nom
  public String getColor() {
    return this.color;
  }

  public String getName() {
    return this.name;
  }

  // public void setColor(String color) {
  // this.color = color;
  // }

  // public void setName(String name) {
  // this.name = name;
  // }

  public String toString() {
    return color + " de " + name;
  }
}
