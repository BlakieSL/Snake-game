package View;

import Controller.AdditionPanelEvent;
import Controller.EventStarter;
import Controller.EventStarterGraphicToLogic;
import Controller.UpdateScoreEvent;
import Helpers.Player;
import Helpers.SavingLoading;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MainFrame extends JFrame implements KeyListener, ObserverToGraphic {
    EventStarterGraphicToLogic eventStarterGraphicToLogic;
    Board board;
    Logic logic;
    Snake snake;
    JTable table;
    String currentPlayerName = "";
    public MainFrame(Board board, Logic logic, Snake snake, EventStarterGraphicToLogic eventStarterGraphicToLogic){

        currentPlayerName = JOptionPane.showInputDialog(this, "Chose a player name");
        if ( currentPlayerName.isEmpty()) {
            System.exit(0);
        }
        this.eventStarterGraphicToLogic = eventStarterGraphicToLogic;
        this.board = board;
        this.logic = logic;
        this.snake = snake;

        table = new JTable();
        table.setModel(board);
        table.setRowHeight(30);
        MyPanel panel = new MyPanel();
        table.setDefaultRenderer(Object.class, panel);
        table.setDefaultEditor(Object.class, panel);
        table.addKeyListener(this);

        ScorePanel scorePanel = new ScorePanel(snake);
        add(scorePanel, BorderLayout.SOUTH);

        add(table);
        setSize(500, 819);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        eventStarterGraphicToLogic.fireKeyPressed(key);
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void addPanel(AdditionPanelEvent additionPanelEvent) {
        ArrayList<Point> snakePoints = snake.getSnake();
        SavingLoading.save(currentPlayerName,snakePoints.size());
        System.out.println("adding panel");

        PlayersListPanel playersListPanel = new PlayersListPanel();

        getContentPane().removeAll();
        getContentPane().add(playersListPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    @Override
    public void updateScore(UpdateScoreEvent updateScoreEvent) {
        System.out.println("updating score");
        repaint();
    }
}
