package hotel;

import java.time.LocalDate;
import java.util.ArrayList;

interface PeriodInterface {
    // okres rezerwacji od-do
    ArrayList<LocalDate> getPeriod();

}
