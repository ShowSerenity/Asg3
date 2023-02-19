package Clothes.Pants;

public class Trousers extends Pants {
    private boolean sport;
    public Trousers(String brand, String model, String gender, int price, int pockets, boolean belt, boolean sport) {
        super(brand, model, gender, price, pockets, belt);
        setSport(sport);
    }

    private static Trousers instance;

    public static Trousers getInstance(String brand, String model, String gender, int price, int pockets, boolean belt, boolean sport) {
        if (instance == null) {
            instance = new Trousers(brand, model, gender, price, pockets, belt, sport);
        }
        return instance;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }
    public boolean isSport() {
        return sport;
    }
}
