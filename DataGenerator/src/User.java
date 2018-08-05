import javax.jws.soap.SOAPBinding;

public class User {
    private Name name;
    private Address address;
    private String email;
    private String password;

    public User(Name name, Address address, String email, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }


}


