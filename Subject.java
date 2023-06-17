package Controller;

import Model.Observer;

import java.awt.*;

public interface Subject {
    void addListener(Observer observer);
    void removeListener(Observer observer);
    void fireFoodConsumption();
    void fireOwnCollision();
    void fireWallCollision();
    void fireUpdate();
}
