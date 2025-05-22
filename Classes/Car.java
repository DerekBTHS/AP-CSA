public class Car {
    private String make;
    private String model;

    public Car(String manufacturer, String type) {
        make = manufacturer;
        model = type;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
