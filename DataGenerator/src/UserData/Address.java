package UserData;

public class Address {
    private String country;
    private String stateProvince;

    public Address(String country, String stateProvince) {
        this.country = country;
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    @Override
    public String toString() {
        return "UserData.Address{" +
                "country='" + country + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }
}
