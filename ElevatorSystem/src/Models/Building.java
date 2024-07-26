package Models;

import java.awt.datatransfer.FlavorListener;
import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floorList;

    //Inject floor list
    Building(List<Floor> floors) {
        this.floorList = floors;
    }

    //Add a floor to the building
    public void addFloor(Floor addFloor) {
        floorList.add(addFloor);
    }

    //Remove a floor from the building
    public void removeFloor(Floor removeFloor) {
        floorList.remove(removeFloor);
    }

    //return the list of floors
    public List<Floor> getAllFloors() {
        return floorList;
    }
}
