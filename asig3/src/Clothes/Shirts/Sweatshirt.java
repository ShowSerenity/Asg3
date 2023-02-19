package Clothes.Shirts;

public class Sweatshirt extends Shirt {
    private boolean comfy;
    public Sweatshirt(String brand, String model, String gender, int price, boolean durable, boolean comfy) {
        super(brand, model, gender, price, durable);
        setComfy(comfy);
    }

    private static Sweatshirt instance;

    public static Sweatshirt getInstance(String brand, String model, String gender, int price, boolean durable, boolean comfy) {
        if (instance == null) {
            instance = new Sweatshirt(brand, model, gender, price, durable, comfy);
        }
        return instance;
    }

    public void setComfy(boolean comfy) {
        this.comfy = comfy;
    }
    public boolean isComfy() {
        return comfy;
    }
}
