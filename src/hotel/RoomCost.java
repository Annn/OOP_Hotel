package hotel;

public abstract class RoomCost {
    public String description = "";
    RoomInformation room;

    public String getDescription() { return description; }

//    1, 2 or 3 persons in a room
    public int getSize(){ return room.getNumberOfPersons(); }

    public abstract int cost();
}
