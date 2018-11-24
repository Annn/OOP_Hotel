package hotel;

public class SeasonalDiscount extends RoomCostDecorator {
//    Discount on reservations for period from october to april

    RoomCost room;

    public SeasonalDiscount(RoomCost room){
        this.room = room;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " with seasonal discount";
    }

    @Override
    public int cost() {
        int cost = room.cost();
        return (int)(cost * 0.75);
    }
}
