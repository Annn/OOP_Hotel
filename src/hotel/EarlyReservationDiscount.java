package hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EarlyReservationDiscount extends RoomCostDecorator {
    // Discount for early reservation (>30 days)

    RoomCost room;
    PeriodInterface period;

    public EarlyReservationDiscount(RoomCost room, ReservationPeriod period){
        this.room = room;
        this.period = period;
    }

    @Override
    public String getDescription() {
        return room.getDescription() + " with discount for early reservation";
    }

    @Override
    public int cost() {
        LocalDate today = LocalDate.now();
//        int monthNow = today.getMonthValue();
        LocalDate reservationDate = this.period.getPeriod().get(0);

        int cost = room.cost();
//        int month = this.period.getPeriod().get(0).getMonth().getValue();
        if (ChronoUnit.DAYS.between(today, reservationDate) > 30)
            return (int)(cost * 0.8);
        else return cost;
    }
}
