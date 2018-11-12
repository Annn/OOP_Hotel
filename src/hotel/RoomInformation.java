package hotel;

public class RoomInformation implements RoomInfoInterface {

    String name;
    int numberOfPersons;

    public RoomInformation(String name, int nOfPersons) {
        this.name = name;
        this.numberOfPersons = nOfPersons;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfPersons() {
        return this.numberOfPersons;
    }

}
