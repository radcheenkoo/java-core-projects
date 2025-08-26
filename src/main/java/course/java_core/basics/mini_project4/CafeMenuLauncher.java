package course.java_core.basics.mini_project4;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CafeMenuLauncher {

    private static final CafeDB cafeDB = new CafeDB();
    private static final String ADMIN_CODE = "1234";


    public static void main(String[] args) {

        start();

    }


    public static void start(){

        System.out.println("Continue as a user, then enter yes/or any other key.");
        final Scanner scanner = new Scanner(System.in);

        while (true){
            String scannerResponse = scanner.next();


            if(scannerResponse.equalsIgnoreCase("yes") || scannerResponse.toLowerCase().contains("yes")){
                userFlow(scanner);
            }
            if(scannerResponse.equalsIgnoreCase("admin")){
                if (scanner.next().equals(ADMIN_CODE)){
                    adminFlow(scanner);
                }
            }

            System.out.println("Would you like to continue? If so, enter yes, or press any other key.");
            if (!scanner.next().equalsIgnoreCase("yes")){
                break;
            }
            else {
                continue;
            }

        }

    }

    public static void userFlow(Scanner scanner){

        System.out.println("Select the dishes that interest you.");

        for (Map.Entry<String, Double> dish: cafeDB.getMenu().entrySet()){
            System.out.println("Name of dish: " + dish.getKey() + ", price of the dish: " + dish.getValue());
        }

        Map<String, Double> preferredDishes = new HashMap<>();

        while (true){

            System.out.println("Would you like to order a dish? If so, please enter yes / no.");

            if (scanner.next().equalsIgnoreCase("yes")){

                System.out.println("Enter the name of the dish you want to order.");
                String dishName = scanner.next();

                if (dishName == null || !cafeDB.existsDishByName(dishName)){
                    System.err.println("You have not entered a name or the name is incorrect.");
                    continue;
                }
                else {

                    preferredDishes.put(dishName, cafeDB.getDishPriceByName(dishName));
                    System.out.println("The dish has been added to your wish list.");
                }

            }else{
                break;
            }
        }


        System.out.println("List of dishes you have ordered.");
        System.out.println();
        double finalPrice = 0;

        for(Map.Entry<String, Double> preferredDish: preferredDishes.entrySet()){

            System.out.println("Name of dish: " + preferredDish.getKey());

            finalPrice += preferredDish.getValue();
        }
        System.out.println("Your receipt for the dishes you ordered.");
        System.out.println("Price: " + finalPrice);


    }

    public static void adminFlow(Scanner scanner){

        while (true){

            System.out.println("Select an option.");
            System.out.println("1 - View the list of dishes");
            System.out.println("2 - Add a new dish");
            System.out.println("3 - Refresh dish");
            System.out.println("4 - Delete dish");
            System.out.println("5 - Back");

            int option = scanner.nextInt();

            switch (option){

                case 1 ->{

                    System.out.println("List of dishes.");
                    cafeDB.getMenu().entrySet().stream()
                            .forEach(dish -> System.out.println("Name of dish: " + dish.getKey() + ", price of the dish: " + dish.getValue()));

                    break;
                }

                case 2 ->{

                    System.out.println("Enter the name of the dish.");
                    String dishName = scanner.next();
                    System.out.println("Enter the price for the dish.");
                    Double dishPrice = scanner.nextDouble();

                    if (dishName == null ){
                        System.err.println("You have not entered a value, please start again");
                        continue;
                    }

                    cafeDB.addDish(dishName, dishPrice);
                    System.out.println("The dish has been successfully added.");
                    break;
                }

                case 3 ->{

                    System.out.println("Enter the old name of the dish.");
                    String oldName = scanner.next();

                    System.out.println("Enter a new name for the dish.");
                    String newName = scanner.next();

                    System.out.println("Enter a new price for the dish.");
                    Double newPrice = scanner.nextDouble();

                    if (oldName == null || newName == null || newPrice == null){
                        System.err.println("You have not entered a value, please start again");
                        continue;
                    }else {
                        cafeDB.updateDish(oldName, newName, newPrice);
                        break;
                    }
                }

                case 4 ->{

                    System.out.println("Enter the name of the dish you want to delete.");
                    String deletedDishName = scanner.next();

                    System.out.println("Are you sure you want to delete the dish? Yes / No");
                    if (scanner.next().equalsIgnoreCase("yes")){
                        cafeDB.deleteDish(deletedDishName);
                        System.out.println("The dish has been removed.");
                        break;
                    }else {
                        continue;
                    }

                }
            }

            if (option == 5){
                break;
            }

        }

    }


}
