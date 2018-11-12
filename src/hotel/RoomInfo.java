package hotel;

public class RoomInfo implements RoomInfoInterface {

    String name;
    int numberOfPersons;

    public RoomInfo(String name, int nOfPersons) {
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
