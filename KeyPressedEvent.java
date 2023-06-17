package Controller;

import java.util.EventObject;

public class KeyPressedEvent extends EventObject {
    int key;
    public KeyPressedEvent(Object source, int key) {
        super(source);
        this.key = key;
    }
    public int getKey() {
        return key;
    }
}
