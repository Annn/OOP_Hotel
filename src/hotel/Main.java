package hotel;

import java.io.FileReader;
import java.io.FileWriter;


public class Main {

    public static void main(String[] args){

//        FileReader fr;
//        FileWriter fw;

//        try {
//            fw = new FileWriter("hotel.csv");
//            fr = new FileReader("hotel.csv");
//
//            Hotel hotel = new Hotel();
//
//            hotel.addRoom("room#1", 2);
//            hotel.addRoom("room#2", 3);
//            hotel.addRoom("room#3", 3);
//            hotel.deleteRoom("room#1");
//
//            hotel.saveRooms(fw);
//            fw.close();
//
//            hotel.loadRooms(fr);
//            fr.close();
//        }
//        catch (Exception e) {
//            System.out.println("ERROR");
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());
//        }


//        CLIENT class test
//        try {
//            fw = new FileWriter("clients.csv");
//            fr = new FileReader("clients.csv");
//
//            Client client = new Client();
//
//            client.addClient("ann", "vas", "female", "bla");
//            client.addClient("vit", "nau", "male", "blas");
//            client.addClient("test", "test", "male", "test");
//
////            client.deleteClient("test", "test");
//
//            client.saveClients(fw);
//            fw.close();
//
//            client.loadClients(fr);
//            fr.close();
//        }
//        catch (Exception e) {
//            System.out.println("ERROR");
//            System.out.println(e.getMessage());
//            System.out.println(e.getCause());
//        }


//        ReservationPeriod test
        ReservationPeriod period = new ReservationPeriod(2018, 10, 10, 2018, 10, 22);
        System.out.println(period.getPeriod() + " " + period.getDays() + " days");


//        RoomCostDecorator test
//        RoomCost room = new LuxRoom(new RoomInformation("66", 2));
//        System.out.println(room.getDescription() + " costs " + room.cost());
//
//        room = new SeasonalDiscount(room);
//        System.out.println(room.getDescription() + " costs " + room.cost());
//
//        RoomCost room2 = new StandardRoom(new RoomInformation("66", 3));
//        System.out.println(room2.getDescription() + " costs " + room2.cost());
//
//        room2 = new SeasonalDiscount(room2);
//        System.out.println(room2.getDescription() + " costs " + room2.cost());
//        room2 = new RegularCustomerDiscount(room2);
//        System.out.println(room2.getDescription() + " costs " + room2.cost());
    }
}
