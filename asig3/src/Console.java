import Clothes.Outwears.*;
import Clothes.Pants.*;
import Clothes.Shirts.*;

import java.sql.*;
import java.util.Scanner;

public class Console {

    private static Console instance;

    private Console() {}

    public static Console getInstance() {
        if (instance == null) {
            instance = new Console();
        }
        return instance;
    }



    public void specJacket(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter print (true/false): ");
        boolean print = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter zipper (true/false): ");
        boolean zipper = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter buttons: ");
        int buttons = Integer.parseInt(scanner.nextLine());
        Jacket jacket = Jacket.getInstance(gender, brand, model, price, print, zipper, buttons);
        addJacket(name, jacket);
    }

    public void specHoodie(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter print (true/false): ");
        boolean print = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        Hoodie hoodie = Hoodie.getInstance(gender, brand, model, price, print, color);
        addHoodie(name, hoodie);
    }

    public void specTrousers(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pockets: ");
        int pockets = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter belt (true/false): ");
        boolean belt = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter sport (true/false): ");
        boolean sport = Boolean.parseBoolean(scanner.nextLine());
        Trousers trousers = Trousers.getInstance(gender, brand, model, price, pockets, belt, sport);
        addTrousers(name, trousers);
    }

    public void specShorts(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pockets: ");
        int pockets = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter belt (true/false): ");
        boolean belt = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter extra short (true/false): ");
        boolean extraShort = Boolean.parseBoolean(scanner.nextLine());
        Shorts shorts = Shorts.getInstance(gender, brand, model, price, pockets, belt, extraShort);
        addShorts(name, shorts);
    }

    public void specClassicShirt(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter durable (true/false): ");
        boolean durable = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter chest pocket (true/false): ");
        boolean chestPocket = Boolean.parseBoolean(scanner.nextLine());
        ClassicShirt classicShirt = ClassicShirt.getInstance(gender, brand, model, price, durable, chestPocket);
        addClassicShirt(name, classicShirt);
    }

    public void specSweatshirt(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter durable (true/false): ");
        boolean durable = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter comfy (true/false): ");
        boolean comfy = Boolean.parseBoolean(scanner.nextLine());
        Sweatshirt sweatshirt = Sweatshirt.getInstance(gender, brand, model, price, durable, comfy);
        addSweatshirt(name, sweatshirt);
    }

    public int showPrice(int ID) {
        int price = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT price FROM public.cloth Where id = " + ID);
            while (rs.next()) {
                price = rs.getInt("price");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
        return price;
    }


    public void newSeller(String name, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO public.seller(seller_name, password) VALUES ('" + name + "','" + password + "')");
            System.out.println("New salesman account created");
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }


    public static boolean checkP(String name, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM seller WHERE seller_name = ? AND password = ?");
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();


        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            return false;
        }
    }



    public void showClothes(String tableName) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"" + tableName + "\"");
            while (rs.next()) {
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Gender: "+rs.getString("gender"));
                System.out.println("Brand: "+rs.getString("brand"));
                System.out.println("Model: "+rs.getString("model"));
                System.out.println("----------------");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void showClothByID(String table, int ID) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"" + table + "\" WHERE id = "+ ID);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if(metaData.getColumnType(i) == Types.BOOLEAN) {
                        boolean columnValue = rs.getBoolean(i);
                        System.out.println(columnValue ? "true" : "false");
                    } else {
                        System.out.println(metaData.getColumnName(i) + ": " + rs.getObject(i));
                    }
                }
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }


    public void showClothByID(int ID) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.cloth WHERE id = "+ ID);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if(metaData.getColumnType(i) == Types.BOOLEAN) {
                        boolean columnValue = rs.getBoolean(i);
                        System.out.println(columnValue ? "true" : "false");
                    } else {
                        System.out.println(metaData.getColumnName(i) + ": " + rs.getObject(i));
                    }
                }
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void showSellerClothes(String table, String name) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            PreparedStatement st = con.prepareStatement("SELECT * FROM public.\"" + table + "\" WHERE seller_name = '"+name+"'");
            ResultSet rs = st.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if(metaData.getColumnType(i) == Types.BOOLEAN) {
                        boolean columnValue = rs.getBoolean(i);
                        System.out.println(columnValue ? "true" : "false");
                    } else {
                        System.out.println(metaData.getColumnName(i) + ": " + rs.getObject(i));
                    }
                }
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }


    public void updateSellerClothes(String table, int price, int ID) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("UPDATE public.\"" + table + "\" SET price = '" + price + "' WHERE id = '"+ ID + "'");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if(metaData.getColumnType(i) == Types.BOOLEAN) {
                        boolean columnValue = rs.getBoolean(i);
                        System.out.println(columnValue ? "true" : "false");
                    } else {
                        System.out.println(metaData.getColumnName(i) + ": " + rs.getObject(i));
                    }
                }
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            showClothByID(ID);
        }

    }


    public void removeSellerClothes(String table, String name, int ID) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String query = "DELETE FROM public.\""+table+"\" WHERE seller_name = ? AND id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, ID);
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }

    }

    public void addJacket(String name, Jacket jacket) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"jacket\" (gender, brand, model, price, print, zipper, buttons, seller_name) Values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, jacket.getBrand());
            st.setString(2, jacket.getModel());
            st.setString(3, jacket.getGender());
            st.setInt(4, jacket.getPrice());
            st.setBoolean(5, jacket.hasPrint());
            st.setBoolean(6, jacket.hasZipper());
            st.setInt(7, jacket.getButtons());
            st.setString(8, name);
            st.executeUpdate();
            con.close();
            showSellerClothes("jacket", name);
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void addHoodie(String name, Hoodie hoodie) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"hoodie\" (gender, brand, model, price, print, color, seller_name) Values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, hoodie.getBrand());
            st.setString(2, hoodie.getModel());
            st.setString(3, hoodie.getGender());
            st.setInt(4, hoodie.getPrice());
            st.setBoolean(5, hoodie.hasPrint());
            st.setString(6, hoodie.getColor());
            st.setString(7, name);
            st.executeUpdate();
            con.close();
            showSellerClothes("hoodie", name);
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void addTrousers(String name, Trousers trousers) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"trousers\" (gender, brand, model, price, pockets, belt, sport, seller_name) Values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, trousers.getBrand());
            st.setString(2, trousers.getModel());
            st.setString(3, trousers.getGender());
            st.setInt(4, trousers.getPrice());
            st.setInt(5, trousers.getPockets());
            st.setBoolean(6, trousers.hasBelt());
            st.setBoolean(7, trousers.isSport());
            st.setString(8, name);
            st.executeUpdate();
            con.close();
            showSellerClothes("trousers", name);
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void addShorts(String name, Shorts shorts) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"shorts\" (gender, brand, model, price, pockets, belt, extrashort, seller_name) Values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, shorts.getBrand());
            st.setString(2, shorts.getModel());
            st.setString(3, shorts.getGender());
            st.setInt(4, shorts.getPrice());
            st.setInt(5, shorts.getPockets());
            st.setBoolean(6, shorts.hasBelt());
            st.setBoolean(7, shorts.isExtraShort());
            st.setString(8, name);
            st.executeUpdate();
            con.close();
            showSellerClothes("shorts", name);
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void addClassicShirt(String name, ClassicShirt classicShirt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"classicShirt\" (gender, brand, model, price, durable, chestpocket, seller_name) Values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, classicShirt.getBrand());
            st.setString(2, classicShirt.getModel());
            st.setString(3, classicShirt.getGender());
            st.setInt(4, classicShirt.getPrice());
            st.setBoolean(5, classicShirt.isDurable());
            st.setBoolean(6, classicShirt.hasChestPocket());
            st.setString(7, name);
            st.executeUpdate();
            con.close();
            showSellerClothes("classicShirt", name);
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void addSweatshirt(String name, Sweatshirt sweatshirt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"sweatshirt\" (gender, brand, model, price, durable, comfy, seller_name) Values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sweatshirt.getBrand());
            st.setString(2, sweatshirt.getModel());
            st.setString(3, sweatshirt.getGender());
            st.setInt(4, sweatshirt.getPrice());
            st.setBoolean(5, sweatshirt.isDurable());
            st.setBoolean(6, sweatshirt.isComfy());
            st.setString(7, name);
            st.executeUpdate();
            con.close();
            showSellerClothes("sweatshirt", name);
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }
}
