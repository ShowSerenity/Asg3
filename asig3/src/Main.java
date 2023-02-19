import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> cart = new ArrayList<>();
    static Console console = Console.getInstance();

    public static void main(String[] args) {
        System.out.println("Welcome to the clothing store");
        login();
    }


    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Log in as a customer(1), or a seller(2)");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Welcome!!!");
            System.out.println("--------------");
            customerConsole();
        } else if (choice == 2) {
            sellerLogin();
        } else {
            System.out.println("try again");
            login();
        }
    }


    public static void customerConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which piece of clothing do you want to purchase?");
        System.out.println("1) Jacket");
        System.out.println("2) Hoodie");
        System.out.println("3) Trousers");
        System.out.println("4) Shorts");
        System.out.println("5) Classic Shirt");
        System.out.println("6) Sweatshirt");
        System.out.println("7) View the cart");
        System.out.println("8) Return to the main menu");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                console.showClothes("jacket");
                itemDetails("jacket");
            case 2:
                console.showClothes("hoodie");
                itemDetails("hoodie");
            case 3:
                console.showClothes("trousers");
                itemDetails("trousers");
            case 4:
                console.showClothes("shorts");
                itemDetails("shorts");
            case 5:
                console.showClothes("classicShirt");
                itemDetails("classicShirt");
            case 6:
                console.showClothes("sweatshirt");
                itemDetails("sweatshirt");
            case 7:
                viewCart();
            case 8:
                login();
        }
    }


    public static void itemDetails(String table) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id of item");
        int id = scanner.nextInt();
        console.showClothByID(table, id);
        addCart(id);
    }

    public static void addCart(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add to the cart(1) or go back(2)");
        int choice = scanner.nextInt();
        if (choice == 1) {
            cart.add(id);
            System.out.println("Item has been added to the cart");
            customerConsole();
        } else if (choice == 2) {
            customerConsole();
        } else {
            System.out.println("try again");
            addCart(id);
        }
    }

    public static void viewCart() {
        Scanner scanner = new Scanner(System.in);
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
            System.out.println("--------------------");
            customerConsole();
        }
        else {
            System.out.println("Items in the cart");
            for (Integer integer : cart) {
                console.showClothByID(integer);
                System.out.println("-------------------");
            }
        }
        System.out.println("Make a purchase? y/n");
        String choice = scanner.nextLine();
        if (choice.equals("y")) {
            makePurchase();
        } else if (choice.equals("n")) {
            customerConsole();
        } else {
            System.out.println("try again");
            viewCart();
        }
    }

    public static void makePurchase() {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        for (Integer integer : cart) {
            total = total + console.showPrice(integer);
        }
        System.out.println("The total price would be: " + total);
        System.out.println("Confirm the transaction? y/n");
        String confirmation = scanner.nextLine();
        if (confirmation.equals("y")) {
            System.out.println("Transaction was successful");
            System.out.println("---------------------------");
            System.out.println("---------------------------");
            login();
        }
        else if (confirmation.equals("n")) {
            viewCart();
        } else {
            System.out.println("try again");
            makePurchase();
        }
    }


    public static void sellerLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Log in(1) or Sign up(2)");
        int choice = scanner.nextInt();
        if (choice == 1) {
            SellerLoginProcess();
        }
        else if (choice == 2) {
            SignUp();
        }
    }

    public static void SellerLoginProcess() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type your name: ");
        String name = scanner.nextLine();

        System.out.println("Type your password: ");
        String password = scanner.nextLine();

        if (Console.checkP(name, password)) {
            System.out.println("Access granted");
            System.out.println("--------------");
            sellerConsole(name);
        }
        else {
            System.out.println("Access denied");
            System.out.println("--------------");
            sellerLogin();
        }
    }

    public static void SignUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        console.newSeller(username, password);
        System.out.println("--------------------");
        sellerLogin();
    }

    public static void sellerConsole(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which action do you want to perform?");
        System.out.println("1) Check my goods");
        System.out.println("2) Update my goods");
        System.out.println("3) Add new goods");
        System.out.println("4) Remove certain product");
        System.out.println("5) Return to the main menu");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showSellerClothes(name);
            case 2:
                updateCloth(name);
            case 3:
                addNewCloth(name);
            case 4:
                removeCloth(name);
            case 5:
                login();
        }
    }

    public static void addNewCloth(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the category");
        System.out.println("1) Jacket");
        System.out.println("2) Hoodie");
        System.out.println("3) Trousers");
        System.out.println("4) Shorts");
        System.out.println("5) Classic Shirt");
        System.out.println("6) Sweatshirt");
        System.out.println("7) Go back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                console.specJacket(name);
                sellerConsole(name);
            case 2:
                console.specHoodie(name);
                sellerConsole(name);
            case 3:
                console.specTrousers(name);
                sellerConsole(name);
            case 4:
                console.specShorts(name);
                sellerConsole(name);
            case 5:
                console.specClassicShirt(name);
                sellerConsole(name);
            case 6:
                console.specSweatshirt(name);
                sellerConsole(name);
            case 7:
                sellerConsole(name);
        }
        System.out.println("New item have been successfully added");
        System.out.println("----------------------------------------");
        sellerConsole(name);
    }


    public static void showSellerClothes(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the category");
        System.out.println("1) Jacket");
        System.out.println("2) Hoodie");
        System.out.println("3) Trousers");
        System.out.println("4) Shorts");
        System.out.println("5) Classic Shirt");
        System.out.println("6) Sweatshirt");
        System.out.println("7) Go back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                console.showSellerClothes("jacket", name);
                sellerConsole(name);
            case 2:
                console.showSellerClothes("hoodie", name);
                sellerConsole(name);
            case 3:
                console.showSellerClothes("trousers", name);
                sellerConsole(name);
            case 4:
                console.showSellerClothes("shorts", name);
                sellerConsole(name);
            case 5:
                console.showSellerClothes("classicShirt", name);
                sellerConsole(name);
            case 6:
                console.showSellerClothes("sweatshirt", name);
                sellerConsole(name);
            case 7:
                sellerConsole(name);
        }
    }

    public static void updateCloth(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the category");
        System.out.println("1) Jacket");
        System.out.println("2) Hoodie");
        System.out.println("3) Trousers");
        System.out.println("4) Shorts");
        System.out.println("5) Classic Shirt");
        System.out.println("6) Sweatshirt");
        System.out.println("7) Go back");
        int choice = scanner.nextInt();
        String table;
        switch (choice) {
            case 1:
                table = "jacket";
                console.showSellerClothes("jacket", name);
                updateProcess(table, name);
            case 2:
                table = "hoodie";
                console.showSellerClothes("hoodie", name);
                updateProcess(table, name);
            case 3:
                table = "trousers";
                console.showSellerClothes("trousers", name);
                updateProcess(table, name);
            case 4:
                table = "shorts";
                console.showSellerClothes("shorts", name);
                updateProcess(table, name);
            case 5:
                table = "classicShirt";
                console.showSellerClothes("classicShirt", name);
                updateProcess(table, name);
            case 6:
                table = "sweatshirt";
                console.showSellerClothes("sweatshirt", name);
                updateProcess(table, name);
            case 7:
                sellerConsole(name);
        }
    }

    public static void updateProcess(String table, String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the id of item you want to update");
        int id = scanner.nextInt();
        System.out.print("Enter new price: ");
        int price = scanner.nextInt();
        console.updateSellerClothes(table, price, id);
        sellerConsole(name);
    }

    public static void removeCloth(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the category");
        System.out.println("1) Jacket");
        System.out.println("2) Hoodie");
        System.out.println("3) Trousers");
        System.out.println("4) Shorts");
        System.out.println("5) Classic Shirt");
        System.out.println("6) Sweatshirt");
        System.out.println("7) Go back");
        int choice = scanner.nextInt();
        String table;
        switch (choice) {
            case 1:
                table = "jacket";
                console.showSellerClothes("jacket", name);
                removeProcess(table, name);
            case 2:
                table = "hoodie";
                console.showSellerClothes("hoodie", name);
                removeProcess(table, name);
            case 3:
                table = "trousers";
                console.showSellerClothes("trousers", name);
                removeProcess(table, name);
            case 4:
                table = "shorts";
                console.showSellerClothes("shorts", name);
                removeProcess(table, name);
            case 5:
                table = "classicShirt";
                console.showSellerClothes("classicShirt", name);
                removeProcess(table, name);
            case 6:
                table = "sweatshirt";
                console.showSellerClothes("sweatshirt", name);
                removeProcess(table, name);
            case 7:
                sellerConsole(name);
        }
    }

    public static void removeProcess(String table, String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the id of item you want to remove");
        int id = scanner.nextInt();
        console.removeSellerClothes(table, name, id);
        System.out.println("Item was successfully removed");
        sellerConsole(name);
    }




}