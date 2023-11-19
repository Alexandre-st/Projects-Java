public class Carte {
  char[][] carte;
  int playerPosX;
  int playerPosY;
  int goalX;
  int goalY;

  public Carte(int x, int y) {
    this.carte = new char[x][y];
    this.playerPosX = x - 1;
    this.playerPosY = y - 1;
    this.goalX = 0;
    this.goalY = 0;

    // Initialisation de la carte
    initiateCarte();
  }

  private void initiateCarte() {
    for (int i = 0; i < carte.length; i++) {
      for (int j = 0; j < carte[i].length; j++) {
        // ajout d'obstacles et de monstres
        if (Math.random() < 0.2) {
          carte[i][j] = 'O'; // obstacle
        } else if (Math.random() < 0.1) {
          carte[i][j] = 'M'; // monstre
        } else {
          carte[i][j] = ' '; // espace vide
        }
      }
    }
    // ajout du joueur
    carte[playerPosX][playerPosY] = 'P';
    carte[goalX][goalY] = 'G';
  }

  public void showCarte() {
    for (int i = 0; i < carte.length; i++) {
      for (int j = 0; j < carte[i].length; j++) {
        System.out.print("[" + carte[i][j] + "]");
      }
      System.out.println();
    }
  }

  public void movePlayer(int moveX, int moveY) {
    int newPosX = playerPosX + moveX;
    int newPosY = playerPosY + moveY;

    if (posIsGood(newPosX, newPosY)) {
      // Retire l'ancienne position du joueur
      carte[playerPosX][playerPosY] = ' ';
      // Met à jour la position du joueur
      playerPosX = newPosX;
      playerPosY = newPosY;
      // Ajoute la nouvelle position du joueur
      carte[newPosX][newPosY] = 'P';
    } else {
      System.out.println("Vous ne pouvez pas aller ici, Non mais OH");
    }
  }

  private boolean posIsGood(int x, int y) {
    return x >= 0 && x < carte.length && y >= 0 && y < carte[0].length && carte[x][y] != 'O';
  }

  public boolean isGoal() {
    return playerPosX == goalX && playerPosY == goalY;
  }
}
