package Clothes.Shirts;

public class ClassicShirt extends Shirt {

    private boolean chestPocket;
    public ClassicShirt(String brand, String model, String gender, int price, boolean durable, boolean chestPocket) {
        super(brand, model, gender, price, durable);
        setChestPocket(chestPocket);
    }

    public void setChestPocket(boolean chestPocket) {
        this.chestPocket = chestPocket;
    }
    public boolean hasChestPocket() {
        return chestPocket;
    }
}
