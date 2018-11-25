package hotel;

public class Administrator extends Client {

    public Administrator(int id,
                         String firstName,
                         String lastName,
                         String sex,
                         String address) {
        super(id, firstName, lastName, sex, address);
        this.type = "administrator";
    }


}
