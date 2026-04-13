package entity;

public class Vehicle {
    private String licensePlate;
    private String model;
    private String manufacturer;
    private String color;

    public Vehicle(String licensePlate, String model, String manufacturer, String color) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return String.format("%s %s (%s) - Placa: %s", manufacturer, model, color, licensePlate);
    }
}