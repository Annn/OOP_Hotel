package hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularCustomerDiscountTest {
//    Tests for description and cost for Lux and Regular rooms
//    for 1, 2 or 3 persons

    RoomCost luxRoom1; // 1-person lux room
    RoomCost luxRoom2; // 2-person lux room
    RoomCost luxRoom3; // 3-person lux room

    RoomCost standardRoom1; // 1-person standard room
    RoomCost standardRoom2; // 2-person standard room
    RoomCost standardRoom3; // 3-person standard room


    @Before
    public void initialize() {
        luxRoom1 = new LuxRoom(new RoomInformation("66", 1));
        luxRoom1 = new RegularCustomerDiscount(luxRoom1);

        luxRoom2 = new LuxRoom(new RoomInformation("66", 2));
        luxRoom2 = new RegularCustomerDiscount(luxRoom2);

        luxRoom3 = new LuxRoom(new RoomInformation("66", 3));
        luxRoom3 = new RegularCustomerDiscount(luxRoom3);

        standardRoom1 = new StandardRoom(new RoomInformation("5", 1));
        standardRoom1 = new RegularCustomerDiscount(standardRoom1);

        standardRoom2 = new StandardRoom(new RoomInformation("5", 2));
        standardRoom2 = new RegularCustomerDiscount(standardRoom2);

        standardRoom3 = new StandardRoom(new RoomInformation("5", 3));
        standardRoom3 = new RegularCustomerDiscount(standardRoom3);
    }

    @Test
    public void getDescription() {
        String expected = "lux room for 1 persons with discount for loyalty";
        String actual = luxRoom1.getDescription();
        assertEquals(expected, actual);

        String expected1 = "standard room for 1 persons with discount for loyalty";
        String actual1 = standardRoom1.getDescription();
        assertEquals(expected1, actual1);
    }

    @Test
    public void cost() {
//        Lux room test

//        int expected = 135;
//        int actual = room1.cost();
//        assertEquals(expected, actual);

//        int expected = 153;
//        int actual = room2.cost();
//        assertEquals(expected, actual);

//        int expected = 162;
//        int actual = luxRoom3.cost();
//        assertEquals(expected, actual);

//        Standard room check

        int expected = 90;
        int actual = standardRoom1.cost();
        assertEquals(expected, actual);

        int expected1 = 117;
        int actual1 = standardRoom2.cost();
        assertEquals(expected1, actual1);

        int expected2 = 135;
        int actual2 = standardRoom3.cost();
        assertEquals(expected2, actual2);
    }
}