package Clothes.Outwears;
import Clothes.Cloth;

public class Outwear extends Cloth {
    private boolean print;
    public Outwear(String brand, String model, String gender, int price, boolean print) {
        super(brand, model, gender, price);
        setPrint(print);
    }

    public void setPrint(boolean print) {
        this.print = print;
    }
    public boolean hasPrint() {
        return print;
    }
}
