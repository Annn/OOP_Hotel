package hotel;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Hotel implements HotelInterface {

    private static Hotel hotel = new Hotel();
    private List<RoomInformation> rooms;
    private List<Reservation> reservations;
    private List<Client> clients;
    private int roomsID = 0;
    private int clientsID = 0;
    private int reservationsID = 0;

    private Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public static Hotel getInstance() {
        return hotel;
    }

    public void loadRooms(Reader reader) {
        Scanner scanner = new Scanner(reader);
        // check if rooms were loaded before
        if (!this.rooms.isEmpty()) {
            this.rooms = new ArrayList<>();
        }
        // load the rooms
        while (scanner.hasNextLine()) {
            String[] roomData = scanner.nextLine().split(",");
            String name = roomData[0].trim();
            int nOfPersons = Integer.parseInt(roomData[1].trim());
            this.addRoom(name, nOfPersons);
            System.out.println(name + ": " + nOfPersons);
        }
    }

    public void saveRooms(Writer writer) {
        try {
            for (RoomInformation ri : rooms) {
                writer.write(ri.getName() + ", " +
                        ri.getNumberOfPersons() + "\n");
            }
        } catch (Exception e) {
        }
    }

    public void addRoom(String name, int nOfPersons) {
        rooms.add(new RoomInformation(++this.roomsID, name, nOfPersons));
    }

    public void deleteRoom(String name) {
        // deletes the rooms with the given name
        ArrayList<RoomInformation> roomsToRemove = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getName().equals(name)) {
                roomsToRemove.add(rooms.get(i));
            }
        }
        rooms.removeAll(roomsToRemove);
    }

    public void deleteRoom(int id) {
        // deletes the room with the given ID
        RoomInformation roomToRemove = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getID() == id) {
                roomToRemove = rooms.get(i);
            }
        }
        if (!roomToRemove.equals(null)) rooms.remove(roomToRemove);
    }

    public List<ReservationInfoInterface> findFreeRooms(PeriodInterface period,
                                                        List<Integer> rooms) {
        List<ReservationInfoInterface> rii = new ArrayList<>();
        // choose rooms that fit to the given description
        List<RoomInformation> fittingRooms = new ArrayList<>();
        for (RoomInformation room : this.rooms) {
            for (Integer r : rooms) {
                if (room.getNumberOfPersons() == r) {
                    fittingRooms.add(room);
                }
            }
        }
        // check if periods are available

        return rii;
    }

    public boolean makeReservation(Client client,
                                   ReservationInfoInterface request) {
        //

        this.reservations.add(
                new Reservation(
                        ++this.reservationsID,
                        client,
                        (ReservationInformation) request
                )
        );

        return true;
    }

    public List<Client> getGuests() {
        List<Client> guests = new ArrayList<>();
        for (Client client : this.clients) {
            if (client.getType() == "guest")
                guests.add(client);
        }
        return guests;
    }

}
