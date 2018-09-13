package UserData;

public class User {
    private Name name;
    private Address address;
    private String email;
    private String password;
    private String company;
    private String phone;

    public User(Name name, Address address, String email, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public User(Name name, Address address, String company, String email, String phone) {
        this.name = name;
        this.address = address;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public String getCompany() {
        return company;
    }


    public String getPhone() {
        return phone;
    }



}


