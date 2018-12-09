package hotel;


public class ReservationInformation implements ReservationInfoInterface {

    private ReservationPeriod period;
    private RoomInfoInterface roomInformation;
    RoomCost room;

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

    public void showInformation() {
        System.out.println(roomInformation.toString());
        System.out.println("Reserved: " + period.toString());
    }

    public int getRoomCost(String type){
        if (type == "lux") {
            room = new LuxRoom((RoomInformation) roomInformation);
        }
        else if (type == "standard") {
            room = new StandardRoom((RoomInformation) roomInformation);
        }
        int cost = room.cost();

        System.out.println(room.description + " costs " + cost);
        return cost;
    }
}
