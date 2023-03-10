package Clothes.Outwears;

public class Jacket extends Outwear {
    private boolean zipper;
    private int buttons;

    public Jacket(String brand, String model, String gender, int price, boolean print, boolean zipper, int buttons) {
        super(brand, model, gender, price, print);
        setButtons(buttons);
        setZipper(zipper);
    }
    private static Jacket instance;

    public static Jacket getInstance(String brand, String model, String gender, int price, boolean print, boolean zipper, int buttons) {
        if (instance == null) {
            instance = new Jacket(brand, model, gender, price, print, zipper, buttons);
        }
        return instance;
    }


    public void setZipper(boolean zipper) {
        this.zipper = zipper;
    }
    public boolean hasZipper() {
        return zipper;
    }
    public void setButtons(int buttons) {
        this.buttons = buttons;
    }
    public int getButtons() {
        return buttons;
    }
}
