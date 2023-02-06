package Clothes.Shirts;
import Clothes.Cloth;

public class Shirt extends Cloth {

    private boolean durable;

    public Shirt(String brand, String model, String gender, int price, boolean durable) {
        super(brand, model, gender, price);
        setDurable(durable);
    }

    public void setDurable(boolean durable) {
        this.durable = durable;
    }
    public boolean isDurable() {
        return durable;
    }
}
