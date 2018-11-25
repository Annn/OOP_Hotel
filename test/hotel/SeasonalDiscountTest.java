package hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeasonalDiscountTest {
    RoomCost room1; // 1-person room
    RoomCost room2; // 2-person room
    RoomCost room3; // 3-person room

    @Before public void initialize() {
        room1 = new LuxRoom(new RoomInformation(1, "66", 1));
        room1 = new SeasonalDiscount(room1);

        room2 = new LuxRoom(new RoomInformation(2, "66", 2));
        room2 = new SeasonalDiscount(room2);

        room3 = new LuxRoom(new RoomInformation(3, "66", 3));
        room3 = new SeasonalDiscount(room3);
    }
    @Test
    public void getDescription() {
        String expected = "lux room for 1 persons with seasonal discount";
        String actual = room1.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void cost() {
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
}