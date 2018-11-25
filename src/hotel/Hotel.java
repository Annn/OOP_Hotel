package hotel;

import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Hotel implements HotelInterface {

    private static Hotel hotel = new Hotel();
    private List<RoomInformation> rooms;
    private List<Reservation> reservations;
    private List<Client> clients;
    private HashMap<Integer, ArrayList<ReservationPeriod>> roomPeriods;
    private int roomsID = 0;
    private int reservationsID = 0;

    private Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        clients = new ArrayList<>();
        roomPeriods = new HashMap<>();
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
            //System.out.println(name + ": " + nOfPersons);
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
        roomPeriods.put(this.roomsID, new ArrayList<>());
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
        RoomInformation roomToRemove = getRoom(id);
        if (!roomToRemove.equals(null)) rooms.remove(roomToRemove);
    }

    private RoomInformation getRoom(int id) {
        RoomInformation room = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getID() == id) {
                room = rooms.get(i);
                break;
            }
        }
        return room;
    }

    private boolean roomIsFree(int id, PeriodInterface period) {

        boolean isFree = true;

        LocalDate inDate = period.getPeriod().get(0);
        LocalDate outDate = period.getPeriod().get(1);

        ArrayList<ReservationPeriod> rPeriods = roomPeriods.get(id);
        for (ReservationPeriod rp : rPeriods) {
            LocalDate rInDate = rp.getPeriod().get(0);
            LocalDate rOutDate = rp.getPeriod().get(1);
            if (!(inDate.isAfter(rOutDate) || outDate.isBefore(rInDate))) {
                isFree = false;
            }
        }

        return isFree;
    }

    public List<ReservationInfoInterface> findFreeRooms(PeriodInterface period,
                                                        List<Integer> rooms) {
        // list of available rooms for the given period
        List<ReservationInfoInterface> rii = new ArrayList<>();

        // choose rooms that fit to the given number of persons
        List<Integer> fittingRoomsID = new ArrayList<>();
        for (RoomInformation room : this.rooms) {
            for (Integer r : rooms) {
                if (room.getNumberOfPersons() == r) {
                    fittingRoomsID.add(room.getID());
                }
            }
        }
        // check if periods are available
        for (Integer id : fittingRoomsID) {
            if (roomIsFree(id, period))
                rii.add(new ReservationInformation(
                                (ReservationPeriod) period,
                                getRoom(id)
                            )
                );
        }

        for (ReservationInfoInterface info : rii) {
            info.showInformation();
        }

        return rii;
    }

    public boolean makeReservation(Client client,
                                   ReservationInfoInterface request) {
        boolean isReserved = false;
        // get information from the request
        ReservationPeriod rPeriod = (ReservationPeriod)request.getPeriod();
        //
        int roomID = request.getRoomInfo().getID();
        if (roomIsFree(roomID, rPeriod)) {
            this.reservations.add(
                    new Reservation(
                            ++this.reservationsID,
                            client,
                            (ReservationInformation)request
                    )
            );
            if (!clients.contains(client))
                this.clients.add(client);
            isReserved = true;
            System.out.println("Room " + roomID + " is reserved.");
        }
        else {
            System.out.println("Room " + roomID + " is not free.");
        }
        return isReserved;
    }

    public Reservation getReservation(int id) {
        Reservation r = null;
        for (Reservation reservation : this.reservations) {
            if (reservation.getID() == id) {
                r = reservation;
            }
        }
        return r;
    }

    public void showReservation(int id) {
        Reservation r = getReservation(id);
        if (!r.equals(null)) {
            System.out.println("Reservation #" + id);
            System.out.println("Client: " +
                    r.getClient().getFirstName() + " " +
                    r.getClient().getLastName() + " (" +
                    r.getClient().getID() + ").");
            System.out.println("Room: " +
                    r.getInformation().getRoomInfo().getName() + " [" +
                    r.getInformation().getRoomInfo().getNumberOfPersons() +
                    " person(s)]: from " +
                    r.getInformation().getPeriod().getPeriod().get(0) + " to " +
                    r.getInformation().getPeriod().getPeriod().get(1) + ".");
            System.out.println();
        }

    }

    public void showAllReservations() {
        for (Reservation r : this.reservations) {
            showReservation(r.getID());
        }
    }

    public void cancelReservation(Client client, int id) {
        // only administrators could remove a reservation
        if (client.getType().equals("administrator")) {
            Reservation reservation = getReservation(id);
            if (!reservation.equals(null))
                this.reservations.remove(reservation);
        }
    }

    public ArrayList<Client> getGuests() {
        ArrayList<Client> guests = new ArrayList<>();
        for (Client client : this.clients) {
            if (client.getType() == "guest")
                guests.add(client);
        }
        return guests;
    }

    public void showGuests() {
        ArrayList<Client> guests = getGuests();
        for (Client guest : guests) {
            System.out.println("Guest [" + guest.getID() + "]: " +
                    guest.getFirstName() + " " + guest.getLastName() + ", " +
                    guest.getSex() + ".");
            System.out.println("Address: " + guest.getAddress());
            System.out.println();
        }
    }


}
