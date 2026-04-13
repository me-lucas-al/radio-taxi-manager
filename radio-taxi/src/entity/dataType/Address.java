package entity.dataType;

public class Address {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    public Address(String street, String number, String complement, String neighborhood, String city, String state) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public String getStreet() { return street; }
    public String getNumber() { return number; }
    public String getComplement() { return complement; }
    public String getNeighborhood() { return neighborhood; }
    public String getCity() { return city; }
    public String getState() { return state; }

    public String getFullAddress() {
        String base = street + ", " + number;
        if (complement != null && !complement.trim().isEmpty()) {
            base += " - " + complement;
        }
        return base + " - " + neighborhood + ", " + city + " - " + state;
    }
}