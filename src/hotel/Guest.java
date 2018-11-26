package hotel;

public class Guest extends Client {
    public Guest(int id,
                 String firstName,
                 String lastName,
                 String sex,
                 String address) {
        super(id, firstName, lastName, sex, address);
        this.type = "guest";
    }
}
