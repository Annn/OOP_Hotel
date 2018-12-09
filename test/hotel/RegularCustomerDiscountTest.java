package hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularCustomerDiscountTest {
    // Tests for description and cost for Lux and Regular rooms
    // for 1, 2 or 3 persons

    RoomCost luxRoom1, luxRoom2, luxRoom3; // 1, 2 and 3-person lux room
    RoomCost standardRoom1, standardRoom2, standardRoom3; // 1, 2 and 3-person standard room

    @Before
    public void initialize() {
        luxRoom1 = new LuxRoom(new RoomInformation(1, "66", 1));
        luxRoom1 = new RegularCustomerDiscount(luxRoom1);

        luxRoom2 = new LuxRoom(new RoomInformation(2, "66", 2));
        luxRoom2 = new RegularCustomerDiscount(luxRoom2);

        luxRoom3 = new LuxRoom(new RoomInformation(3, "66", 3));
        luxRoom3 = new RegularCustomerDiscount(luxRoom3);

        standardRoom1 = new StandardRoom(new RoomInformation(4, "5", 1));
        standardRoom1 = new RegularCustomerDiscount(standardRoom1);

        standardRoom2 = new StandardRoom(new RoomInformation(5, "5", 2));
        standardRoom2 = new RegularCustomerDiscount(standardRoom2);

        standardRoom3 = new StandardRoom(new RoomInformation(6, "5", 3));
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
    public void cost1() {
        // Lux room test
        assertEquals(135, luxRoom1.cost());
        assertEquals(153, luxRoom2.cost());
        assertEquals(162, luxRoom3.cost());
    }

    @Test
    public void cost2() {
        // Standard room test
        assertEquals(90, standardRoom1.cost());
        assertEquals(117, standardRoom2.cost());
        assertEquals(135, standardRoom3.cost());
    }

}