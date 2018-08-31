public class Address {
    private String country;
    private String stateProvince;

    public Address(String country, String stateProvince) {
        this.country = country;
        this.stateProvince = stateProvince;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }
}
