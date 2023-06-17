package Helpers;

import Controller.EventStarter;
import Controller.EventStarterGraphicToLogic;
import Controller.EventStarterToGraphic;
import Model.Board;
import Model.Logic;
import Model.Snake;
import View.MainFrame;
public class Starter {
    public static void main(String[] args) {
        EventStarter eventStarter = new EventStarter();
        EventStarterToGraphic eventStarterToGraphic = new EventStarterToGraphic();
        EventStarterGraphicToLogic eventStarterGraphicToLogic = new EventStarterGraphicToLogic();

        Board board = new Board(eventStarterToGraphic);
        Snake snake = new Snake();
        Logic logic = new Logic(board, snake, eventStarter);
        MainFrame mainFrame = new MainFrame(board, logic, snake, eventStarterGraphicToLogic);

        eventStarter.addListener(board);
        eventStarter.addListener(logic);
        eventStarterToGraphic.addListener(mainFrame);
        eventStarterGraphicToLogic.addListener(logic);
        logic.start();
    }
}