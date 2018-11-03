package hotel;

import java.io.Reader;
import java.io.Writer;

interface Hotel {
    void loadRooms(Reader reader);
    void saveRooms(Writer writer);

    void addRooms(String name, int nOfBeds);
    void deleteRoom(String name);

    void List<ReservationInfo> findFreeRooms(Period period, List<Integer> rooms);
    boolean makeReservation(Client client, ReservationInfo request);
}
