import hotel.Hotel;

import java.io.FileReader;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args){

        FileReader fr;
        FileWriter fw;
        int[] rooms = new int[]{1, 2, 3, 1, 1, 1, 2, 2, 3, 4};


        try {
            fw = new FileWriter("hotel.csv");
            fr = new FileReader("hotel.csv");

            Hotel hotel = Hotel.getInstance();

            for (int i = 0; i < rooms.length; i++) {
                System.out.println("room#" + (i + 1) + ": " + rooms[i]);
                hotel.addRoom("room#" + (i + 1), rooms[i]);
            }

            hotel.deleteRoom("room#1");
            hotel.deleteRoom(5);

            hotel.saveRooms(fw);
            fw.close();

            hotel.loadRooms(fr);
            fr.close();
        }
        catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }
}
