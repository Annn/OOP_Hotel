package hotel;


public class Reservation implements ReservationInterface {

    private int reservationID;
    private Client client;
    private ReservationInformation information;

    public Reservation(int id, Client client, ReservationInformation information) {
        this.reservationID = id;
        this.client = client;
        this.information = information;
    }

    public int getID() {
        return this.reservationID;
    }

    public Client getClient() {
        return this.client;
    }

    public ReservationInformation getInformation() {
        return this.information;
    }

}
