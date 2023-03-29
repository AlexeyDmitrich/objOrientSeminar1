import java.util.ArrayList;
import java.util.List;


public class VendingMachine {
    private List<Product> products = new ArrayList<>();
    private double money = 0;

    private static CoffeeMachine lavatsa  = new CoffeeMachine(new Water(20),
            new Milk("Молоко для кофе", 85, 5),
            new Shugar("Русский сахар", 65, 5),
            new Coffee("Lavatsa", 800, 3));


    public VendingMachine addProduct(Product product) {
        products.add(product);
        return this;
    }

    public Product searchProduct(String name) {
        if (name.equalsIgnoreCase("капучино")) {
            products.add(lavatsa.getCappuccino());
        }
        if (name.equalsIgnoreCase("латте")) {
            products.add(lavatsa.getLatte());
        }
        if (name.equalsIgnoreCase("эспрессо")) {
            products.add(lavatsa.getEspresso());
        }
        if (name.equalsIgnoreCase("американо")) {
            products.add(lavatsa.getAmericano());
        }

        for (Product item : products) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public Product sell(String name) throws Exception {
        Product target = searchProduct(name);
        try {
            if (!target.sellCounter()) {
                products.remove(target);

            }
            this.money += target.getPrice();
        } catch (NullPointerException e) {
//            System.out.println("Товар не найден");
            throw new Exception("Товар не найден", e);
        }

        return target;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Product item : products) {
            res.append(item);
            res.append("\n");
        }
        res.append(String.format("В автомате сейчас %.2f рублей", money));
        return res.toString();
    }
}
