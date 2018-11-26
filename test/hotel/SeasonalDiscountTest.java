package hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonalDiscountTest {
    RoomCost room1, room2, room3; // 1, 2 and 3-person LUX room
    RoomCost room4;         // 3-person room, NO discount
    PeriodInterface discountPeriod, noDiscountPeriod;

    @Before public void initialize() {
        discountPeriod = new ReservationPeriod(2018, 12, 10, 2018, 12, 22);
        noDiscountPeriod = new ReservationPeriod(2018, 5, 10, 2018, 5, 22);

        room1 = new LuxRoom(new RoomInformation(1, "66", 1));
        room1 = new SeasonalDiscount(room1, (ReservationPeriod) discountPeriod);

        room2 = new LuxRoom(new RoomInformation(2, "66", 2));
        room2 = new SeasonalDiscount(room2, (ReservationPeriod) discountPeriod);

        room3 = new LuxRoom(new RoomInformation(3, "66", 3));
        room3 = new SeasonalDiscount(room3, (ReservationPeriod) discountPeriod);

        room4 = new LuxRoom(new RoomInformation(3, "66", 3));
        room4 = new SeasonalDiscount(room4, (ReservationPeriod) noDiscountPeriod);
    }
    @Test
    public void getDescription() {
        String expected = "lux room for 1 persons with seasonal discount";
        String actual = room1.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void costWithDiscountTest() {
//        Seasonal discount for rooms for 1, 2 and 3 persons

//        int expected = 112;
//        int actual = room1.cost();
//        assertEquals(expected, actual);

//        int expected = 127;
//        int actual = room2.cost();
//        assertEquals(expected, actual);

        int expected = 135;
        int actual = room3.cost();
        assertEquals(expected, actual);
    }
    @Test
    public void costWithoutDiscountTest() {
//        No discount test for 3 persons in a room
        int expected = 180;
        int actual = room4.cost();
        assertEquals(expected, actual);
    }
}