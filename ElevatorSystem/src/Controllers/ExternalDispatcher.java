package Controllers;

import Models.Direction;
import Models.ElevatorCreater;

import java.util.List;

public class ExternalDispatcher {

    List<ElevatorController> elevatorControllers = ElevatorCreater.elevatorControllerList;

    public void submitNewRequest(int floorID, Direction direction) {

        for(ElevatorController elevatorController: elevatorControllers) {
            int elevatorID = elevatorController.
        }
    }
}
