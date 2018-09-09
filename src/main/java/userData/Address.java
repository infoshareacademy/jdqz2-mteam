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

  public Address(String country, String stateProvince) {
    this.country = country;
    this.stateProvince = stateProvince;
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

  @Override
  public String toString() {
    return "Address{" +
            "street='" + street + '\'' +
            ", city='" + city + '\'' +
            ", country='" + country + '\'' +
            ", stateProvince='" + stateProvince + '\'' +
            ", postalCode='" + postalCode + '\'' +
            '}';
  }
}
