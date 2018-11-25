package hotel;

import java.util.ArrayList;
import java.util.List;

public class ReservationInformation implements ReservationInfoInterface {

    private ReservationPeriod period;
    private List<RoomInfoInterface> roomsInformation;

    public ReservationInformation(ReservationPeriod period,
                                  List<RoomInfoInterface> ri) {
        this.roomsInformation = new ArrayList<>();
        this.period = period;
        this.roomsInformation = ri;
    }

    public PeriodInterface getPeriod() {
        return this.period;
    }

    public List<RoomInfoInterface> getRoomsInfo() {
        return this.roomsInformation;
    }

}
