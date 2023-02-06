package Clothes;

public abstract class Cloth implements ClothSpec {
    private static int idCounter = 0;
    private String brand;
    private String model;
    private int price;
    private String gender;
    private int id;

    public Cloth (String brand, String model, String gender, int price) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setGender(gender);
        setId(++idCounter);
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getPrice() {
        return price;
    }
    public String getGender() {
        return gender;
    }
    protected void setId(int id) {
        this.id = id;
    }
}
