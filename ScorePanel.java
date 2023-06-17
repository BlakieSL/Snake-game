package View;

import Model.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ScorePanel extends JPanel {
    Snake snake;
    ScorePanel(Snake snake){
        this.snake = snake;
        setPreferredSize(new Dimension(0,30));
        setBackground(new Color(110, 90, 158));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FontMetrics fm = g.getFontMetrics();
        Font boldFont = new Font(fm.getFont().getName(), Font.BOLD, fm.getFont().getSize());
        g.setFont(boldFont);
        Rectangle2D r = fm.getStringBounds("Score:" + snake.getSnake().size(),g);
        g.setColor(Color.white);
        int w = getWidth();
        int h = getHeight();

        int x = (w-(int)r.getWidth())/2;
        int y = h/2-(int)r.getHeight()/2+fm.getAscent();
        g.drawString("Score: "+ snake.getSnake().size(), x, y);
    }
}