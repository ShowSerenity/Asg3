package Clothes.Pants;
import Clothes.Cloth;

public class Pants extends Cloth {
    private int pockets;
    private boolean belt;

    public Pants(String brand, String model, String gender, int price, int pockets, boolean belt) {
        super(brand, model, gender, price);
        setPockets(pockets);
        setBelt(belt);
    }

    public void setPockets(int pockets) {
        this.pockets = pockets;
    }
    public int getPockets() {
        return pockets;
    }
    public void setBelt(boolean belt) {
        this.belt = belt;
    }
    public boolean hasBelt() {
        return belt;
    }
}
