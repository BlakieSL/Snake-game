package Controller;

import Model.ObserverToGraphic;

import java.util.ArrayList;

public class EventStarterToGraphic implements SubjectToGraphic{
    ArrayList<ObserverToGraphic> observers;
    public EventStarterToGraphic(){
        observers = new ArrayList<ObserverToGraphic>();
    }
    @Override
    public void addListener(ObserverToGraphic observerToGraphic) {
        observers.add(observerToGraphic);
    }

    @Override
    public void removeListener(ObserverToGraphic observerToGraphic) {
        observers.remove(observerToGraphic);
    }

    @Override
    public void fireAddPanel() {
        AdditionPanelEvent event = new AdditionPanelEvent(this);
        for(ObserverToGraphic observerToGraphic : observers){
            observerToGraphic.addPanel(event);
        }
    }

    @Override
    public void fireUpdateScorePanel() {
        UpdateScoreEvent event = new UpdateScoreEvent(this);
        for(ObserverToGraphic observerToGraphic : observers){
            observerToGraphic.updateScore(event);
        }

    }
}
