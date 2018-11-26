package hotel;

import java.time.Month;
import java.time.Period;

public class SeasonalDiscount extends RoomCostDecorator {
//    Discount on reservations for period from october to april

    RoomCost room;
    PeriodInterface period;

    public SeasonalDiscount(RoomCost room, ReservationPeriod period){
        this.room = room;
        this.period =  period;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " with seasonal discount";
    }

    @Override
    public int cost() {
        int cost = room.cost();
        int month = this.period.getPeriod().get(0).getMonth().getValue();
        if (month == 11 || month == 12 || month == 1 || month == 2 || month == 3){
            return (int)(cost * 0.75);
        }
        else { return cost; }
    }
}
