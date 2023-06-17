package Controller;

import Model.ObserverGraphicToLogic;
import Model.ObserverToGraphic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class EventStarterGraphicToLogic implements SubjectGraphicToLogic {
    ArrayList<ObserverGraphicToLogic> observers;
    public EventStarterGraphicToLogic(){
        observers = new ArrayList<ObserverGraphicToLogic>();
    }
    @Override
    public void addListener(ObserverGraphicToLogic observer) {
        observers.add(observer);
    }

    @Override
    public void removeListener(ObserverGraphicToLogic observer) {
        observers.remove(observer);
    }

    @Override
    public void fireKeyPressed(int key) {
        KeyPressedEvent event = new KeyPressedEvent(this,key);
        for(ObserverGraphicToLogic observer : observers){
            observer.KeyPressed(event);
        }
    }
}
