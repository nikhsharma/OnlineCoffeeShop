package models.stock;

public class Coffee extends Stock{

    private CoffeeType coffeeType;
    private int weight;

    public Coffee() {
    }

    public Coffee(double price, int quantity, CoffeeType coffeeType, int weight) {
        super(price, quantity);
        this.coffeeType = coffeeType;
        this.weight = weight;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
