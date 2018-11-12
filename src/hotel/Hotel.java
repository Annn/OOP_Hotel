package hotel;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel implements HotelInterface {

    private List<RoomInformation> rooms;

    public Hotel() {
        rooms = new ArrayList<>();
    }


    public void loadRooms(Reader reader) {

        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String[] roomData = scanner.nextLine().split(",");
            String name = roomData[0].trim();
            int nOfPersons = Integer.parseInt(roomData[1].trim());

            System.out.println(name + ": " + nOfPersons);
        }

    }

    public void saveRooms(Writer writer) {
        try {
            for (RoomInformation ri : rooms) {
                writer.write(ri.getName() + ", " + ri.getNumberOfPersons() + "\n");
            }
        }
        catch (Exception e) {}
    }

    public void addRoom(String name, int nOfPersons) {
        rooms.add(new RoomInformation(name, nOfPersons));
    }

    public void deleteRoom(String name) {

    }

    public List<ReservationInfoInterface> findFreeRooms(PeriodInterface period,
                                                        List<Integer> rooms) {
        List<ReservationInfoInterface> rii = new ArrayList<>();
        return rii;
    }

    public boolean makeReservation(ClientInterface client,
                                   ReservationInfoInterface request) {
        return true;
    }
}
