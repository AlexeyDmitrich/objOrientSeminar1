public class Milk extends Product{
    double temperature;

    public Milk(String name, double price, int value) {
        super(name, price, value);
        temperature = 3;
    }

    @Override
    public String toString() {
        return String.format("Молоко : %s" ,super.toString());
    }
}
