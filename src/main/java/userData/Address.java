package userData;

public class Address {
  private String street;
  private String city;
  private String country;
  private String stateProvince;
  private String postalCode;


  public Address(String street, String city, String country, String stateProvince, String postalCode) {
    this.street = street;
    this.city = city;
    this.country = country;
    this.stateProvince = stateProvince;
    this.postalCode = postalCode;
  }


  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public String getPostalCode() {
    return postalCode;
  }

}
