package hotel;

import java.util.List;

interface ReservationInfoInterface {
    PeriodInterface getPeriod();
    List<RoomInfoInterface> getRoomsInfo();
}
