import hotel.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        FileReader fr;
        FileWriter fw;
        int[] rooms = new int[]{1, 2, 3, 1, 1, 1, 2, 2, 3, 4};

        Hotel hotel;

        Client admin = new Administrator(-1,
                "admin",
                "admin",
                "M",
                "hotel");
        Client client1 = new Guest(1,
                "Name1",
                "Surname1",
                "M",
                "KRK");
        Client client2 = new Guest(2,
                "Name2",
                "Surname2",
                "F",
                "KRK");

        ReservationInformation ri1 = new ReservationInformation(
                new ReservationPeriod(2018, 10, 1, 2018, 10, 5),
                new RoomInformation(1, "room#1", 1));
        ReservationInformation ri2 = new ReservationInformation(
                new ReservationPeriod(2018, 10, 26, 2018, 10, 29),
                new RoomInformation(1, "room#1", 1));
        ReservationInformation ri3 = new ReservationInformation(
                new ReservationPeriod(2018, 11, 25, 2018, 11, 29),
                new RoomInformation(2, "room#2", 2));

        try {
            fw = new FileWriter("hotel.csv");
            fr = new FileReader("hotel.csv");

            hotel = Hotel.getInstance();

            for (int i = 0; i < rooms.length; i++) {
                //System.out.println("room#" + (i + 1) + ": " + rooms[i]);
                hotel.addRoom("room#" + (i + 1), rooms[i]);
            }

            hotel.deleteRoom("room#1");
            hotel.deleteRoom(5);

            hotel.saveRooms(fw);
            fw.close();

            //hotel.loadRooms(fr);
            //fr.close();

            //
            hotel.makeReservation(admin, ri1);
            hotel.makeReservation(client1, ri2);
            hotel.makeReservation(client2, ri3);

            hotel.showAllReservations();
            hotel.showGuests();

            ArrayList<Integer> roomsNumber = new ArrayList<>();
            roomsNumber.add(1); roomsNumber.add(3);

            //
            hotel.findFreeRooms(new ReservationPeriod(
                    2018, 11, 20,
                    2018,12, 2),
                    roomsNumber);

            ri1.getRoomCost("lux");
        }
        catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }
}
