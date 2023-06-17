package View;

import Helpers.Player;
import Helpers.SavingLoading;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class PlayersListPanel extends JPanel {

    public PlayersListPanel() {
        ArrayList<Player> topPlayers = SavingLoading.getTopPlayers();
        this.setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(new Color(226, 209, 249));
        labelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelPanel.setPreferredSize(new Dimension(500,50));
        JLabel label = new JLabel("BEST PLAYERS");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        labelPanel.add(label, BorderLayout.CENTER);


        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(10,2));
        playerPanel.setBackground(new Color(47, 60, 126));



        for (Player player : topPlayers) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1,1));
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.setBackground(new Color(251, 234, 235));
            JLabel name = new JLabel("PLAYER: " + player.getName());
            name.setHorizontalAlignment(JLabel.CENTER);


            JLabel score = new JLabel("SCORE: " +  player.getPoints());
            score.setHorizontalAlignment(JLabel.CENTER);


            panel.add(name);
            panel.add(score);
            playerPanel.add(panel);
        }
        this.add(labelPanel, BorderLayout.NORTH);
        this.add(playerPanel);
    }
}
