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

        rPeriod = new ReservationPeriod(2018, 10, 10,
                                        2018, 10, 13);
        ri = new ReservationInformation(rPeriod, roomInfo1);
        ri2 = new ReservationInformation(rPeriod, roomInfo2);
    }

    @Test
    public void getLuxRoomCostTest() {
        // cost for LUX or STANDARD room per day
        // 1-person rooms
        assertEquals(150, ri.getRoomCost("lux"));
        assertEquals(100, ri.getRoomCost("standard"));
        // 2-person rooms
        assertEquals(170, ri2.getRoomCost("lux"));
        assertEquals(130, ri2.getRoomCost("standard"));
    }
}