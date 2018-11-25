package hotel;


public class ReservationInformation implements ReservationInfoInterface {

    private ReservationPeriod period;
    private RoomInfoInterface roomInformation;

    public ReservationInformation(ReservationPeriod period,
                                  RoomInfoInterface ri) {
        this.period = period;
        this.roomInformation = ri;
    }

    public PeriodInterface getPeriod() {
        return this.period;
    }

    public RoomInfoInterface getRoomInfo() {
        return this.roomInformation;
    }

}
