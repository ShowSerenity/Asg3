import Clothes.Outwears.*;
import Clothes.Pants.*;
import Clothes.Shirts.*;

import java.sql.*;
import java.util.Scanner;

public class Console {
    public void specJacket(String name) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();
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
        Jacket jacket = new Jacket(gender, brand, model, price, print, zipper, buttons);
        console.addJacket(name, jacket);
    }

    public void specHoodie(String name) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();
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
        Hoodie hoodie = new Hoodie(gender, brand, model, price, print, color);
        console.addHoodie(name, hoodie);
    }

    public void specTrousers(String name) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();
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
        Trousers trousers = new Trousers(gender, brand, model, price, pockets, belt, sport);
        console.addTrousers(name, trousers);
    }

    public void specShorts(String name) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();
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
        Shorts shorts = new Shorts(gender, brand, model, price, pockets, belt, extraShort);
        console.addShorts(name, shorts);
    }

    public void specClassicShirt(String name) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();
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
        ClassicShirt classicShirt = new ClassicShirt(gender, brand, model, price, durable, chestPocket);
        console.addClassicShirt(name, classicShirt);
    }

    public void specSweatshirt(String name) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();
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
        Sweatshirt sweatshirt = new Sweatshirt(gender, brand, model, price, durable, comfy);
        console.addSweatshirt(name, sweatshirt);
    }

    public int showPrice(String table, int ID) {
        int price = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT price FROM public.\"" + table + "\" Where id = " + ID);
            while (rs.next()) {
                price = rs.getInt("price");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
        return price;
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

    public void showSellers() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.seller");
            while (rs.next()) {
                System.out.println("Seller name: " + rs.getString("seller_name"));
                System.out.println("---------------------");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }

    public void newSeller(String name, String password) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO public.seller(seller_name, password) VALUES ('" + name + "','" + password + "')" );
            System.out.println("New salesman account created");
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }


    public char checkPassword(String name, String password) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            PreparedStatement st = con.prepareStatement("SELECT * FROM public.seller WHERE seller_name=?");
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    System.out.println("You are now logged in");
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
        System.out.println("Try again");
        return 0;
    }


    public void showClothes(String tableName) {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.\"" + table + "\" WHERE seller_name = "+ name + "'");
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

    public void showSellerClothes(String name) {
        Scanner scanner = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.cloth WHERE seller_name = "+ name + "'");
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
            ResultSet rs = st.executeQuery("UPDATE public.\"" + table + "\" SET price = " + price + " WHERE id = "+ ID + "'");
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


    public void removeSellerClothes(String table, String name, int ID) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("REMOVE * FROM public.\"" + table + "\" WHERE seller_name = "+ name + "'");
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

    public void removeSellerClothes(String table, int ID) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("REMOVE * FROM public.\"" + table + "\" WHERE seller_name = "+ ID + "'");
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


    public void addJacket(String name, Jacket jacket) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"jacket\" (gender, brand, model, price, print, zipper, buttons, seller_name) Values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, jacket.getGender());
            st.setString(1, jacket.getBrand());
            st.setString(1, jacket.getModel());
            st.setInt(1, jacket.getPrice());
            st.setBoolean(1, jacket.hasPrint());
            st.setBoolean(1, jacket.hasZipper());
            st.setInt(1, jacket.getButtons());
            st.setString(1, name);
            st.executeUpdate();
            con.close();
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
            st.setString(1, hoodie.getGender());
            st.setString(1, hoodie.getBrand());
            st.setString(1, hoodie.getModel());
            st.setString(1, hoodie.getColor());
            st.setInt(1, hoodie.getPrice());
            st.setBoolean(1, hoodie.hasPrint());
            st.setString(1, name);
            st.executeUpdate();
            con.close();
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
            st.setString(1, trousers.getGender());
            st.setString(1, trousers.getBrand());
            st.setString(1, trousers.getModel());
            st.setInt(1, trousers.getPrice());
            st.setInt(1, trousers.getPockets());
            st.setBoolean(1, trousers.hasBelt());
            st.setBoolean(1, trousers.isSport());
            st.setString(1, name);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void addShorts(String name, Shorts shorts) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"shorts\" (gender, brand, model, price, pockets, belt, extraShort, seller_name) Values (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, shorts.getGender());
            st.setString(1, shorts.getBrand());
            st.setString(1, shorts.getModel());
            st.setInt(1, shorts.getPrice());
            st.setInt(1, shorts.getPockets());
            st.setBoolean(1, shorts.hasBelt());
            st.setBoolean(1, shorts.isExtraShort());
            st.setString(1, name);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }

    public void addClassicShirt(String name, ClassicShirt classicShirt) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/clothes_store", "postgres", "12345");
            String sql = "INSERT INTO public.\"classicShirt\" (gender, brand, model, price, durable, chestPocket, seller_name) Values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, classicShirt.getGender());
            st.setString(1, classicShirt.getBrand());
            st.setString(1, classicShirt.getModel());
            st.setInt(1, classicShirt.getPrice());
            st.setBoolean(1, classicShirt.isDurable());
            st.setBoolean(1, classicShirt.hasChestPocket());
            st.setString(1, name);
            st.executeUpdate();
            con.close();
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
            st.setString(1, sweatshirt.getGender());
            st.setString(1, sweatshirt.getBrand());
            st.setString(1, sweatshirt.getModel());
            st.setInt(1, sweatshirt.getPrice());
            st.setBoolean(1, sweatshirt.isDurable());
            st.setBoolean(1, sweatshirt.isComfy());
            st.setString(1, name);
            st.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("exception: "+ e.getMessage());
        }
    }
}
