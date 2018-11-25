package hotel;

public class EarlyReservationDiscount extends RoomCostDecorator {
    // Discount for early reservation

    RoomCost room;

    public EarlyReservationDiscount(RoomCost room){
        this.room = room;

    }
    @Override
    public String getDescription() {
        return room.getDescription() + " with discount for early reservation";
    }

    @Override
    public int cost() {
        return (int)(room.cost() * 0.8);
    }
}
