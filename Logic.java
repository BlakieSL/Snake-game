package Model;

import Controller.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Logic extends Thread implements Observer, ObserverGraphicToLogic{
    Board board;
    Snake snake;
    EventStarter eventStarter;
    Direction direction;
    Direction currentDirection;
    Point apple;
    int[][] array;
    boolean isGameOver;
    int frequency=300;
    int lvl =0;

    public Logic(Board board, Snake snake, EventStarter eventStarter){
        this.board = board;
        this.snake = snake;
        this.eventStarter = eventStarter;
        this.direction = Direction.DOWN;
        this.currentDirection = direction;
        this.array = board.getBoard();
        eventStarter.fireUpdate();
        setNewFoodCell();
    }

    public void move(){
        snake.makeMoveSnake(direction);
        currentDirection = direction;

        isFoodConsumption();
        isOwnCollision();
        isWallCollision();
        eventStarter.fireUpdate();
    }

    @Override
    public void run() {
        isGameOver = false;
        while(!isGameOver){
            try{
                move();
                Thread.sleep(frequency);
            }catch(InterruptedException e){ }
        }
    }
    public void setNewFoodCell(){
        boolean flag = true;
        while(flag) {
            int xCoordinate = (int) (Math.random() * 25);
            int yCoordinate = (int) (Math.random() * 16);
            if(array[xCoordinate][yCoordinate] == 0){
                array[xCoordinate][yCoordinate] = 1;
                apple = new Point(xCoordinate,yCoordinate);
                return;
            }
        }
    }
    public void setDirection(Direction direction){
        this.direction = direction;
    }
    public Direction getCurrentDirection() {
        return currentDirection;
    }
    public void isFoodConsumption(){
        Point head = snake.getSnake().get(0);
        if(head.equals(apple)){
            eventStarter.fireFoodConsumption();
        }
    }
    public void isOwnCollision(){
        Point head = snake.getSnake().get(0);
        ArrayList<Point> snakeWithoutHead = new ArrayList<>(snake.getSnake());
        snakeWithoutHead.remove(head);
        if(snakeWithoutHead.contains(head)){
            eventStarter.fireOwnCollision();
        }
    }
    public void isWallCollision(){
        Point head = snake.getSnake().get(0);
        int headX = head.x;
        int headY = head.y;
        if( headX < 0 || headX >= 25 || headY < 0 || headY >= 16){
            eventStarter.fireWallCollision();
        }
    }
    @Override
    public void foodConsumption(FoodConsumptionEvent event) {
        snake.increaseSize();
        if(lvl>3){
            lvl =0;
            frequency-=15;
        }
        lvl++;
        setNewFoodCell();
    }
    @Override
    public void ownCollision(OwnCollisionEvent event) {
        isGameOver = true;
        System.out.println("collision own logic");
    }
    @Override
    public void wallCollision(WallCollisionEvent event) {
        isGameOver = true;
        System.out.println("collision wall logic");
    }
    @Override
    public void updateBoard(UpdateEvent event){
        for(int i = 0; i < this.array.length; i++){
            for(int j = 0; j < this.array[i].length; j++){
                array[i][j] =0;
            }
        }
        ArrayList<Point> snakePoints = snake.getSnake();
        for (Point point : snakePoints) {
            if (point.x >= 0 && point.x < array.length && point.y >= 0 && point.y < array[0].length) {
                array[point.x][point.y] = 2;
            }
        }
        Point head = snakePoints.get(0);
        if (head.x >= 0 && head.x < array.length && head.y >= 0 && head.y < array[0].length) {
            array[head.x][head.y] = 3;
        }
        if(apple!=null) {
            array[apple.x][apple.y] = 1;
        }
    }
    @Override
    public void KeyPressed(KeyPressedEvent event) {
        int value = event.getKey();
        switch (value) {
            case KeyEvent.VK_UP -> {
                if (getCurrentDirection() != Direction.DOWN) {
                    setDirection(Direction.UP);
                }
            }
            case KeyEvent.VK_DOWN -> {
                if (getCurrentDirection() != Direction.UP) {
                    setDirection(Direction.DOWN);
                }
            }
            case KeyEvent.VK_RIGHT -> {
                if (getCurrentDirection() != Direction.LEFT) {
                    setDirection(Direction.RIGHT);
                }
            }
            case KeyEvent.VK_LEFT -> {
                if (getCurrentDirection() != Direction.RIGHT) {
                    setDirection(Direction.LEFT);
                }
            }
        }
    }
}
