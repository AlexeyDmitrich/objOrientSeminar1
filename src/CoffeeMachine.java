public class CoffeeMachine extends VendingMachine{
    private Water water;
    private Milk milk;
    private Shugar shugar;
    private Coffee coffee;

    public CoffeeMachine(Water water, Milk milk, Shugar shugar, Coffee coffee) {
        this.water = water;
        this.milk = milk;
        this.shugar = shugar;
        this.coffee = coffee;
    }

//    public CoffeeMachine() {
//        this.water = null;
//        this.milk = null;
//        this.shugar = null;
//        this.coffee = null;
//    }

    public void setWater(double volumeLitres) {
        this.water = new Water(volumeLitres);
        this.water.setVolume(water.getVolume()*1000);
    }

    public void setMilk(String name, double price, int value) {
        this.milk = new Milk(name, price/1000, value*1000); // переводим цену в цену за мл, а объем - в мл.
    }

    public void setShugar(Shugar shugar) {
        this.shugar = shugar;
        this.shugar.addCounter(shugar.getCounter()*1000); // переводим килограммы в граммы
        this.shugar.setPrice(shugar.getPrice()/1000); // цена за грамм
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
        this.coffee.addCounter(coffee.getCounter()*1000);
        this.coffee.setPrice(coffee.getPrice()/1000);
    }

    public void warmer (){
        this.water.setTemperature(98);
    }

    public Drink getByReciept (String name, int cofee, int sugar, int water, int milk){
        if (this.water.getTemperature()<75){
            System.out.printf("Вода остыла до %.1f градусов. Греем...\n", this.water.getTemperature());
            warmer();
            System.out.println(this.water.getTemperature());
        }
        System.out.println("Нагрели, начинаем приготовление");
        int dose = 0;
        while (dose <= cofee) {
            this.coffee.sellCounterByGramm();
        dose++;
        }
        System.out.println("Помололи кофе");
        dose = 0;
        while (dose <= sugar) {
            this.shugar.sellCounterByGramm();
            dose++;
        }
        System.out.println("Насыпали сахар");
        dose = 0;
        while (dose <= water) {
            this.water.setVolume(this.water.getVolume()-water);
            dose++;
        }
        System.out.printf("Налили кипяток, %.1f градусов.\n", this.water.getTemperature());
        dose = 0;
        while (dose <= milk) {
            this.milk.sellCounterByGramm();
            dose++;
        }
        System.out.println("Добавили молоко");
        double temperature = ((water*this.water.getTemperature()+milk*this.milk.getTemperature())/(water+milk));
        System.out.println(this.water.getTemperature());
        Drink res = new Drink(name, water+milk, temperature, (this.coffee.getPrice()/10+this.shugar.getPrice()/100+this.milk.getPrice()/100));
        System.out.println(res.toString());
//        super.addProduct(res);

        System.out.println(this.water.getTemperature());
        return res;
    }

    public Drink getCappuccino (){
        Drink cappuccino = getByReciept("капучино", 3, 5, 150, 50);
        return cappuccino;
    }
    public Drink getLatte (){
        Drink latte = getByReciept("Латте", 2, 7, 100, 100);
        return latte;
    }
    public Drink getEspresso (){
        Drink espresso = getByReciept("Эспрессо", 4, 4, 50, 0);
        return espresso;
    }
    public Drink getAmericano (){
        Drink americano = getByReciept("Американо", 4, 5, 150, 0);
        return americano;
    }


}
