public class Coffee extends Product{
    public Coffee(String name, double price, int value) {
        super(name, price, value);
    }
    @Override
    public String toString() {
        return String.format("Кофе : %s" ,super.toString());
    }
}
