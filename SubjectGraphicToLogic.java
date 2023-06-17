package Controller;

import Model.ObserverGraphicToLogic;

public interface SubjectGraphicToLogic {
    void addListener(ObserverGraphicToLogic observer);
    void removeListener(ObserverGraphicToLogic observer);
    void fireKeyPressed(int key);
}
