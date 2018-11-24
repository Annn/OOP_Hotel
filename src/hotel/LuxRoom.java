package hotel;

public class LuxRoom extends RoomCost {
//    Lux room can be for 1, 2 or 3 persons

    public LuxRoom(RoomInformation room){
        this.room = room;
        description = "lux room for " + room.getNumberOfPersons() + " persons";
    }
    @Override
    public int cost() {
        if (room.getNumberOfPersons() == 1) {
            return 150;
        }
        else if (room.getNumberOfPersons() == 2) {
            return 170;
        }
        else { return 180;
        }
    }
}
