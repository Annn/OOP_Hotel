package hotel;

public class RegularCustomerDiscount extends RoomCostDecorator {
//    Discount for regular hotel customers

    RoomCost room;
    public RegularCustomerDiscount(RoomCost room){
        this.room = room;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " with discount for loyalty";
    }

    @Override
    public int cost() {
        return (int)(room.cost() * 0.9);
    }
}
