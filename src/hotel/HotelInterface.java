package hotel;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

interface HotelInterface {
    void loadRooms(Reader reader);
    void saveRooms(Writer writer);

    void addRoom(String name, int nOfPersons);
    void deleteRoom(String name);

    List<ReservationInfoInterface> findFreeRooms(PeriodInterface period, List<Integer> rooms);
    boolean makeReservation(ClientInterface client, ReservationInfoInterface request);
}
