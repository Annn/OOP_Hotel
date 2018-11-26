package hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EarlyReservationDiscountTest {

    RoomCost room1, room2, room3; // 1, 2 and 3-person LUX room
    RoomCost room4;         // 3-person room, NO discount
    PeriodInterface discountPeriod, noDiscountPeriod;

    @Before
    public void initialize() {
        discountPeriod = new ReservationPeriod(2018, 12, 27, 2018, 12, 30);
        noDiscountPeriod = new ReservationPeriod(2018, 11, 30, 2018, 12, 2);

        room1 = new LuxRoom(new RoomInformation(1, "66", 1));
        room1 = new EarlyReservationDiscount(room1, (ReservationPeriod) discountPeriod);

        room2 = new LuxRoom(new RoomInformation(2, "66", 2));
        room2 = new EarlyReservationDiscount(room2, (ReservationPeriod) discountPeriod);

        room3 = new LuxRoom(new RoomInformation(3, "66", 3));
        room3 = new EarlyReservationDiscount(room3, (ReservationPeriod) discountPeriod);

        room4 = new LuxRoom(new RoomInformation(3, "66", 3));
        room4 = new EarlyReservationDiscount(room4, (ReservationPeriod) noDiscountPeriod);
    }

    @Test
    public void discountCostTest() {
//        discount 20% for 1, 2 and 3-person LUX rooms
//        for early reservation

//        int expected = 120;
//        int actual = room1.cost();
//        assertEquals(expected, actual);

//        int expected = 136;
//        int actual = room2.cost();
//        assertEquals(expected, actual);

        int expected = 144;
        int actual = room3.cost();
        assertEquals(expected, actual);
    }

    @Test
    public void noDiscountCostTest() {
//        NO discount for 3-person LUX room
        int expected = 180;
        int actual = room4.cost();
        assertEquals(expected, actual);
    }
}