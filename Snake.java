package Model;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private final ArrayList<Point> snake;

    public Snake() {
        snake = new ArrayList<Point>();
        snake.add(new Point(5, 5));
        snake.add(new Point(5,4));
        snake.add(new Point(5,3));

    }
    public ArrayList<Point> getSnake() {
        return snake;
    }

    public void makeMoveSnake(Direction direction) {
        Point head = snake.get(0);
        int nextX = head.x;
        int nextY = head.y;
        switch (direction) {
            case RIGHT -> nextY++;
            case LEFT -> nextY--;
            case UP -> nextX--;
            case DOWN -> nextX++;
        }
        snake.add(0, new Point(nextX, nextY));// add new head
        snake.remove(snake.size() - 1); // delete last point
    }
    public void increaseSize(){
        Point lastPoint = snake.get(snake.size() - 1);
        snake.add(lastPoint);
    }
}
