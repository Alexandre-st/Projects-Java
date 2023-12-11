package ui;

import game.GameInputs;
import game.PlayerCast;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuStartPanel extends JPanel {

    private GameInputs gameInputs;

    private JLabel title;

    private JLabel pseudoLabel;
    private JTextField pseudoField;

    private JRadioButton radioMage;
    private JRadioButton radioGuerrier;
    private JRadioButton radioElf;
    private JRadioButton radioOrc;

    public MenuStartPanel(GameInputs gameInputs) {
        this.gameInputs = gameInputs;
        initComponents();
    }

    private void setPlayerName(String name) {
        this.gameInputs.setPlayerName(name);
    }

    private void setPlayerCast() {
        PlayerCast playerClass = null;
        if (this.radioMage.isSelected()) {
            playerClass = PlayerCast.MAGE;
        } else if (this.radioElf.isSelected()) {
            playerClass = PlayerCast.ELF;
        } else if (this.radioOrc.isSelected()) {
            playerClass = PlayerCast.ORC;
        } else if (this.radioGuerrier.isSelected()) {
            playerClass = PlayerCast.GUERRIER;
        }
        this.gameInputs.setPlayerCast(playerClass);

    }

    private void initComponents() {
        // define components
        this.title = new JLabel("Bienvenue sur le RPG Graphique !");
        this.pseudoLabel = new JLabel("Choisissez votre prénom : ");
        this.pseudoField = new JTextField();

        this.radioElf = new JRadioButton("Elf");
        this.radioOrc = new JRadioButton("Orc");
        this.radioMage = new JRadioButton("Mage");
        this.radioGuerrier = new JRadioButton("Guerrier");

        // define panel layout
        this.setBorder(new EmptyBorder(50, 50, 50, 50));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        /*
         * GridBagConstraints parameters :
         * int gridx,
         * int gridy,
         * int gridwidth,
         * int gridheight,
         * double weightx,
         * double weighty,
         * int anchor,
         * int fill,
         * java.awt.Insets insets,
         * int ipadx,
         * int ipady
         */
        this.setLayout(gridbag);
        gbc.fill = GridBagConstraints.BOTH;

        // add components to panel
        // title
        this.title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        gbc.gridwidth = 3; // 3 columns wide
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(this.title, gbc);
        this.add(this.title);

        // player classes radio buttons
        // mage
        this.radioMage.setSelected(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioMage, gbc);
        this.add(this.radioMage);
        // elf
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioElf, gbc);
        this.add(this.radioElf);
        // warrior
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioGuerrier, gbc);
        this.add(this.radioGuerrier);
        // Orc
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioOrc, gbc);
        this.add(this.radioOrc);

        // pseudo of the player
        this.add(this.pseudoLabel,
                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(50, 0, 30, 0), 0, 0));
        this.pseudoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTextField textField = (JTextField) e.getSource();
                    setPlayerName(textField.getText());
                    setPlayerCast();
                }
            }
        });
        this.add(this.pseudoField,
                new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(50, 0, 30, 0), 0, 0));
    }
}
