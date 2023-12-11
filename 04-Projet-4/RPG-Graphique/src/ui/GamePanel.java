package ui;

import game.Game;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {

    private MapPanel mapPanel;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        // Add MapPanel to GamePanel
        this.mapPanel = new MapPanel(game.getMap());
        this.add(mapPanel, BorderLayout.NORTH);

        // Add KeyListener to handle arrow key events
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int currentRow = game.getPlayer().getRow();
        int currentCol = game.getPlayer().getCol();
        int newPlayerRow = currentRow;
        int newPlayerCol = currentCol;

        // Handle arrow key events
        switch (keyCode) {
            case KeyEvent.VK_UP:
                newPlayerRow = Math.max(0, currentRow - 1);
                break;
            case KeyEvent.VK_DOWN:
                newPlayerRow = Math.min(mapPanel.getMap().length - 1, currentRow + 1);
                break;
            case KeyEvent.VK_LEFT:
                newPlayerCol = Math.max(0, currentCol - 1);
                break;
            case KeyEvent.VK_RIGHT:
                newPlayerCol = Math.min(mapPanel.getMap()[0].length - 1, currentCol + 1);
                break;
        }

        // Check if the new position is not a wall (1 in the map)
        if (mapPanel.getMap()[newPlayerRow][newPlayerCol] != 1) {
            // Update player's position in the Game class
            game.getPlayer().setRow(newPlayerRow);
            game.getPlayer().setCol(newPlayerCol);

            // Update the map to reflect the player's new position
            mapPanel.getMap()[currentRow][currentCol] = 0; // Set the old position to 0
            mapPanel.getMap()[newPlayerRow][newPlayerCol] = 2; // Set the new position to

            // Repaint the panel after player's position is adjusted
            mapPanel.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    public void displayCommands() {
        String commands = "Commandes disponibles :\n" +
                "UP : Déplacer le joueur vers le haut\n" +
                "DOWN : Déplacer le joueur vers le bas\n" +
                "LEFT : Déplacer le joueur vers la gauche\n" +
                "RIGHT : Déplacer le joueur vers la droite\n" +
                "H : Afficher les commandes disponibles";
        JOptionPane.showMessageDialog(null, commands, "Commandes",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
