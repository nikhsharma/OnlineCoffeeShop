package models.stock;

public class Coffee {

    private CoffeeType coffeeType;
    private int weight;

    public Coffee() {
    }

    public Coffee(CoffeeType coffeeType, int weight) {
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
