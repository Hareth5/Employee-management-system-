package proj2;

public class Address {

    private String street, city, country;

    public Address() {
    }

    public Address(String street, String city, String country) {
        setStreet(street);
        setCity(city);
        setCountry(country);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country.trim();
        if (country != null && country.matches("[a-zA-Z ]+"))
            this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city.trim();
        if (city != null && city.matches("[a-zA-Z ]+"))
            this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        street = street.trim();
        if (street != null && street.matches("[a-zA-Z ]+")) {
            this.street = street;
        }
    }


    @Override
    public String toString() {
        return getStreet()+", " + getCity()+", " + getCountry();
    }
}
