public class Drink extends Product {
    double volume;
    double temperature;


    public Drink(String name, double volume, double temperature, double price) {
        super(name, price, 1);
        this.volume = volume;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
      StringBuilder res = new StringBuilder();
      res.append(super.getName())
              .append("\n")
              .append(String.format("%f мл, %f *C"))
              .append(super.getPrice())
              .append("р. \n");
      return res.toString();
    }
}
