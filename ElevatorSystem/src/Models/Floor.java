package Models;

public class Floor {
    int floorID;
    ExternalButton externalButton;

    public Floor(int floorID, ExternalButton externalButton) {
        this.floorID = floorID;
        this.externalButton = externalButton;
    }

    public void pressButton(Direction direction) {
        externalButton.pressButton(floorID,direction);
    }
}
