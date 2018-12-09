package hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonalDiscountTest {

    RoomCost room1, room2, room3; // 1-, 2- and 3-person LUX room
    RoomCost room4; // 3-person room, NO discount
    PeriodInterface discountPeriod, noDiscountPeriod;

    @Before
    public void initialize() {
        discountPeriod = new ReservationPeriod(2018, 12, 10,
                                               2018, 12, 22);
        noDiscountPeriod = new ReservationPeriod(2018, 5, 10,
                                                 2018, 5, 22);

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

    // Seasonal discount for lux rooms for 1, 2 and 3 persons
    @Test
    public void costWithDiscountTest() {
        assertEquals(112, room1.cost());
    }
    @Test
    public void costWithDiscountTest1() {
        assertEquals(127, room2.cost());
    }
    @Test
    public void costWithDiscountTest2() {
        assertEquals(135, room3.cost());
    }

    @Test
    public void costWithoutDiscountTest() {
        // No discount test for 3 persons in a room
        assertEquals(180, room4.cost());
    }
}