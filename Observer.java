package Model;

import Controller.FoodConsumptionEvent;
import Controller.OwnCollisionEvent;
import Controller.UpdateEvent;
import Controller.WallCollisionEvent;

public interface Observer {
    void foodConsumption(FoodConsumptionEvent event);
    void ownCollision(OwnCollisionEvent event);
    void wallCollision(WallCollisionEvent event);
    void updateBoard(UpdateEvent event);
}
