package Controller;

import Model.ObserverToGraphic;

public interface SubjectToGraphic {
    void addListener(ObserverToGraphic observerToGraphic);
    void removeListener(ObserverToGraphic observerToGraphic);
    void fireAddPanel();
    void fireUpdateScorePanel();
}
