package hotel;

import java.time.Month;

public class SeasonalDiscount extends RoomCostDecorator {
//    Discount on reservations for period from october to april

    RoomCost room;
    PeriodInterface period;

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
        Month month = this.period.getPeriod().get(0).getMonth();
        if (month.equals(11) || month.equals(12) || month.equals(1) || month.equals(2) || month.equals(3)){
            return (int)(cost * 0.75);
        }
        else { return cost; }
    }
}
