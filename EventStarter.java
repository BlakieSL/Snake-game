package Controller;

import Model.Observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.EventObject;

public class EventStarter implements Subject{
    ArrayList<Observer> observers;
    public  EventStarter(){
        observers = new ArrayList<Observer>();
    }
    @Override
    public void addListener(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeListener(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void fireFoodConsumption() {
        FoodConsumptionEvent event = new FoodConsumptionEvent(this);
        for(Observer observer : observers){
            observer.foodConsumption(event);
        }
    }

    @Override
    public void fireOwnCollision() {
        OwnCollisionEvent event = new OwnCollisionEvent(this);
        for(Observer observer : observers ){
            observer.ownCollision(event);
        }
    }

    @Override
    public void fireWallCollision() {
        WallCollisionEvent event = new WallCollisionEvent(this);
        for(Observer observer : observers){
            observer.wallCollision(event);
        }
    }
    @Override
    public void fireUpdate(){
        UpdateEvent event = new UpdateEvent(this);
        for(Observer observer : observers){
            observer.updateBoard(event);
        }
    }
}
