package Clothes.Shirts;

public class Sweatshirt extends Shirt {
    private boolean comfy;
    public Sweatshirt(String brand, String model, String gender, int price, boolean durable, boolean comfy) {
        super(brand, model, gender, price, durable);
        setComfy(comfy);
    }

    public void setComfy(boolean comfy) {
        this.comfy = comfy;
    }
    public boolean isComfy() {
        return comfy;
    }
}
