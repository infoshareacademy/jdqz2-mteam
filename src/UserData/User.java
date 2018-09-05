package UserData;

public class User {
  private Name name;
  private Address address;
  private String company;
  private String email;
  private String phone;
  //private String password;


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

  public String getCompany() {
    return company;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }


  @Override
  public String toString() {
    return "User{" +
            "name=" + name +
            ", address=" + address +
            ", company='" + company + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }
}


