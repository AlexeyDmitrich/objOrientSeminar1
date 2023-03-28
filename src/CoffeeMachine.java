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

    public CoffeeMachine() {
        this.water = null;
        this.milk = null;
        this.shugar = null;
        this.coffee = null;
    }

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
        this.shugar.setPrice(shugar.getPrice()/1000);
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
            System.out.printf("Вода остыла до %f градусов. Греем...");
            warmer();
        }
        int dose = 0;
        while (dose <= cofee) {
            this.coffee.sellCounter();
        dose++;
        }
        dose = 0;
        while (dose <= sugar) {
            this.shugar.sellCounter();
            dose++;
        }
        dose = 0;
        while (dose <= water) {
            this.water.setVolume(this.water.getVolume()-water);
            dose++;
        }
        dose = 0;
        while (dose <= milk) {
            this.milk.sellCounter();
            dose++;

        }


        Drink res = new Drink(name, water+milk, )
    }

}
