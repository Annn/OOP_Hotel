package hotel;

import java.io.FileReader;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args){

        FileReader fr;
        FileWriter fw;

        try {
            fw = new FileWriter("hotel.txt");
            fr = new FileReader("hotel.txt");

            Hotel hotel = new Hotel();

            hotel.addRoom("room#1", 1);
            hotel.addRoom("room#2", 3);

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
