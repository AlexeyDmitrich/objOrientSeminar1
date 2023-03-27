public class Milk extends Product{

    public Milk(String name, double price, int value) {
        super(name, price, value);
    }

    @Override
    public String toString() {
        return String.format("Молоко : %s" ,super.toString());
    }
}
