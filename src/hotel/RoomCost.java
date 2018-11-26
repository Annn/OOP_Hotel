package hotel;

public abstract class RoomCost {
    public String description = "";
    RoomInformation room;

    public String getDescription() { return description; }

    public abstract int cost();
}
