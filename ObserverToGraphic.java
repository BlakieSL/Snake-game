package Model;

import Controller.AdditionPanelEvent;
import Controller.UpdateScoreEvent;

public interface ObserverToGraphic {
    void addPanel(AdditionPanelEvent additionPanelEvent);
    void updateScore(UpdateScoreEvent updateScoreEvent);
}
