package Clothes.Pants;

public class Shorts extends Pants {
    private boolean extraShort;
    public Shorts(String brand, String model, String gender, int price, int pockets, boolean belt, boolean extraShort) {
        super(brand, model, gender, price, pockets, belt);
        setExtraShort(extraShort);
    }

    public void setExtraShort(boolean extraShort) {
        this.extraShort = extraShort;
    }
    public boolean isExtraShort() {
        return extraShort;
    }
}
