package hotel;

public class StandardRoom extends RoomCost {
//    Standard room can be for 1, 2 or 3 persons

    public StandardRoom(RoomInformation room){
        this.room = room;
        description = "standard room for " + room.getNumberOfPersons() + " persons";
    }

    @Override
    public int cost() {
        if (room.getNumberOfPersons() == 1) {
            return 100;
        }
        else if (room.getNumberOfPersons() == 2){
            return 130;
        }
        else return 150;
    }
}
