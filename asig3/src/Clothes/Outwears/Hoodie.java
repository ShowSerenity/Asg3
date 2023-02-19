package Clothes.Outwears;

public class Hoodie extends Outwear {
    private String color;

    public Hoodie(String brand, String model, String gender, int price, boolean print, String color) {
        super(brand, model, gender, price, print);
        setColor(color);
    }

    private static Hoodie instance;

    public static Hoodie getInstance(String brand, String model, String gender, int price, boolean print, String color) {
        if (instance == null) {
            instance = new Hoodie(brand, model, gender, price, print, color);
        }
        return instance;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}
