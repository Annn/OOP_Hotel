package hotel;


public class RoomInformation implements RoomInfoInterface {

    private int roomID;
    private String name;
    private int numberOfPersons;

    public RoomInformation(int id, String name, int nOfPersons) {
        this.roomID = id;
        this.name = name;
        this.numberOfPersons = nOfPersons;
    }

    public int getID() { return this.roomID; }
    public String getName() {
        return this.name;
    }
    public int getNumberOfPersons() {
        return this.numberOfPersons;
    }

    public String toString() {
        return "Room: #" + roomID + ", name: " +
                name + ", persons: " + numberOfPersons;
    }

}
