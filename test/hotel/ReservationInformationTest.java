package hotel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationInformationTest {

    ReservationInformation ri, ri2;
    ReservationPeriod rPeriod;
    RoomInformation roomInfo1;  // 1-person room
    RoomInformation roomInfo2;  // 2-person room

    @Before
    public void initialize() {
        roomInfo1 = new RoomInformation(1, "66", 1);
        roomInfo2 = new RoomInformation(2, "66", 2);

        rPeriod = new ReservationPeriod(2018, 10, 10, 2018, 10, 13);
        ri = new ReservationInformation(rPeriod, roomInfo1);
        ri2 = new ReservationInformation(rPeriod, roomInfo2);
    }
    @Test
    public void getRoomCostTest() {
//        int actual1 = ri.getRoomCost("lux");
//        int expected1 = 150;
//        assertEquals(expected1, actual1);

//        int actual2 = ri.getRoomCost("standard");
//        int expected2 = 100;
//        assertEquals(expected2, actual2);

        int actual1 = ri2.getRoomCost("lux");
        int expected1 = 170;
//        assertEquals(expected1, actual1);

        int actual2 = ri2.getRoomCost("standard");
        int expected2 = 130;
        assertEquals(expected2, actual2);

    }
}