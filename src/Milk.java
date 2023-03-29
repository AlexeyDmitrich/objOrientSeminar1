public class Milk extends Product{
    private double temperature;

    public Milk(String name, double price, int value) {
        super(name, price, value);
        temperature = 3;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return String.format("Молоко : %s" ,super.toString());
    }
}
