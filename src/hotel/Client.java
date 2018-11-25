package hotel;


public abstract class Client {

    private int clientID ;
    protected String type = "client";
    private String firstName;
    private String lastName;
    private String sex;
    private String address;

    public Client(int id,
                  String firstName,
                  String lastName,
                  String sex,
                  String address) {
        this.clientID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.address = address;
    }

    public String getType() { return this.type; }
    public int getID() { return this.clientID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSex() { return sex; }
    public String getAddress() { return address; }

}
