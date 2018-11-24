package hotel;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReservationPeriodTest {
    ReservationPeriod period;
//        System.out.println(period.getPeriod() + " " + period.getDays() + " days");
    @Before
    public void initialize() {
        period = new ReservationPeriod(2018, 10, 10, 2018, 10, 22);
    }

    @Test
    public void getPeriod() {
        String actual = period.getPeriod().toString();
        String expected = "[2018-10-10, 2018-10-22]";
        assertEquals(expected, actual);
    }

    @Test
    public void getDays() {
        Long actual = period.getDays();
        Long expected = Long.valueOf(12);
        assertEquals(expected, actual);
    }
}