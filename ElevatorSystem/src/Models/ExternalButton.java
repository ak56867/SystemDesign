package Models;

import Controllers.ExternalDispatcher;

public class ExternalButton {
    ExternalDispatcher externalDispatcher;

    public void pressButton(int floorID, Direction direction)
    {
        externalDispatcher.submitNewRequest(floorID,direction);
    }
}
