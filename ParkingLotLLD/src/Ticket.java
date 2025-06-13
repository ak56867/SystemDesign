import Models.Vehicle;

public class Ticket {
    String ticketID;
    Vehicle vehicle;

    public Ticket(Vehicle vehicle, String ticketID) {
        this.vehicle = vehicle;
        this.ticketID = ticketID;
    }
}
