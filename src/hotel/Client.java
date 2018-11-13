package hotel;

import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client implements ClientInterface {
    private String firstName;
    private String lastName;
    private String sex;
    private String address;

    private List<Client> clients;

    public Client(){
        clients = new ArrayList<>();
    }
    public Client(String firstName, String lastName, String sex, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.address = address;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSex() { return sex; }
    public String getAddress() { return address; }
    public void loadClients(Reader reader) {

        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String[] clientData = scanner.nextLine().split(",");
            String name = clientData[0].trim();
            String surName = clientData[1].trim();
            String sex = clientData[2].trim();
            String address = clientData[3].trim();

            System.out.println(name + " " + surName + ": " + sex + ": " + address);
        }

    }

    public void saveClients(Writer writer) {
        try {
            for (Client client : clients) {
                writer.write(client.getFirstName() + ", " + client.getLastName() + ", " + client.getSex()+ ", " + client.getAddress() + "\n");
            }
        }
        catch (Exception e) {}
    }

    public void addClient(String firstName, String lastName, String sex, String address) {
        clients.add(new Client(firstName, lastName, sex, address));

    }

    public void deleteClient(String name, String surname) {
        if (clients.size() == 0) {
            System.out.println("No clients to delete");
        }
        else {
            for (int i = 0; i < clients.size(); i++){
                if (clients.get(i).firstName == name && clients.get(i).lastName == surname){
                    clients.remove(i);
                }
            }
        }
    }
}
