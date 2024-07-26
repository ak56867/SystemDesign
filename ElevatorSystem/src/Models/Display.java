package Models;

public class Display {
    int floor;
    Direction direction;

    //to inject values of floor and direction
    public void setDisplay(int floor, Direction direction)
    {
        this.floor = floor;
        this.direction = direction;
    }

    //to display the floor and direction
    public void showDisplay() {
        System.out.println(floor);
        System.out.println(direction);
    }
}
