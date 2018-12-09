import hotel.*;

import java.io.FileWriter;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        //FileReader fr;
        FileWriter fw;
        int[] rooms = new int[]{1, 2, 3, 1, 1, 1, 2, 2, 3, 4};

        Hotel hotel;

        // set the system users - an administrator and guests
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
        Client client3 = new Guest(3,
                "Name3",
                "Surname3",
                "F",
                "KRK");

        // define the reservations data
        ReservationInformation ri1 = new ReservationInformation(
                new ReservationPeriod(2018, 10, 1, 2018, 10, 5),
                new RoomInformation(1, "room#1", 1));
        ReservationInformation ri2 = new ReservationInformation(
                new ReservationPeriod(2018, 10, 3, 2018, 10, 7),
                new RoomInformation(1, "room#1", 1));
        ReservationInformation ri3 = new ReservationInformation(
                new ReservationPeriod(2018, 11, 25, 2018, 11, 29),
                new RoomInformation(2, "room#2", 2));
        ReservationInformation ri4 = new ReservationInformation(
                new ReservationPeriod(2018, 3, 25, 2018, 3, 29),
                new RoomInformation(2, "room#2", 2));

        try {
            fw = new FileWriter("hotel.csv");
            //fr = new FileReader("hotel.csv");

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

            // run the reservation method
            hotel.makeReservation(admin, ri1);
            hotel.makeReservation(client1, ri2);
            hotel.makeReservation(client2, ri3);
            hotel.makeReservation(client3, ri4);
            System.out.println();

            // show the completed reservations
            System.out.println("The list of completed reservations:");
            hotel.showAllReservations();
            System.out.println();

            // show guests information
            System.out.println("The hotel guests:");
            hotel.showGuests();
            System.out.println();

            // run the room search method
            ArrayList<Integer> roomsNumber = new ArrayList<>(); // a list of rooms to find
            roomsNumber.add(1); roomsNumber.add(3); // [1, 3]
            System.out.println("Free rooms for the period from 20.11.2018 to 2.12.2018:");
            hotel.findFreeRooms(new ReservationPeriod(
                    2018, 11, 20,
                    2018,12, 2),
                    roomsNumber);

            System.out.println();
            System.out.print("Price for the lux room: ");
            ri1.getRoomCost("lux");
        }
        catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }
}
