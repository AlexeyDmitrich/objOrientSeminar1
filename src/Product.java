public class Product {
    private String name;
    private double price;
    private int counter;

    public Product(String name, double price, int value) {
        this.name = name;
        this.price = price;
        this.counter=value;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean sellCounter() {
        this.counter--;
        return counter>0;
    }

    public void addCounter(int value) {
        this.counter = value;
    }

    public int getCounter() {
        return this.counter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f р.", name, price);
    }
}
