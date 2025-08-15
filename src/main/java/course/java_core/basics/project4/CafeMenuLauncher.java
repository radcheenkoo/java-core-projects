package course.java_core.basics.project4;


import java.util.Map;
import java.util.Scanner;

public class CafeMenuLauncher {

    private static CafeDB cafeDB;
    private static final String ADMIN_CODE = "1234";

//    4. **Меню кафе**
//            - Список страв і цін.
//            - Обрання замовлення з підрахунком загальної суми.

    public static void main(String[] args) {

        System.out.println("Виберіть страви, які вам цікаві. ");

        for (Map.Entry<String, Double> dish: cafeDB.getMenu().entrySet()){
            System.out.println("Назва страви: " + dish.getKey() + ", ціна страви: " + dish.getValue());
        }

    }


    public static void start(){

        System.out.println("Продовжити як користувач, тоді введіть yes/або будь-яку іншу клавішу.");
        final Scanner scanner = new Scanner(System.in);

        while (true){
            String scannerResponse = scanner.next();


            if(scannerResponse.equalsIgnoreCase("yes") || scannerResponse.toLowerCase().contains("yes")){
                userFlow(scanner);
            }
            if(scannerResponse.equalsIgnoreCase("admin")){
                adminFlow(scanner);
            }

            System.out.println("Бажаєте продовжувати? якщо так тоді введіть yes, або натисніть будь-яку іншу клавішу.");
            if (!scanner.next().equalsIgnoreCase("yes")){
                break;
            }
            else {
                continue;
            }

        }

    }

    public static void userFlow(Scanner scanner){

    }

    public static void adminFlow(Scanner scanner){


        while (true){

            System.out.println("Виберіть опцію.");
            System.out.println("1 - Подивитись список страв");
            System.out.println("2 - Додати нову страву");
            System.out.println("3 - Оновити страву");
            System.out.println("4 - Видалити страву");

            int option = scanner.nextInt();

            switch (option){

                case 1 ->{

                    System.out.println("Список страв.");
                    cafeDB.getMenu().entrySet().stream()
                            .forEach(dish -> System.out.println("Назва страви: " + dish.getKey() + ", ціна страви: " + dish.getValue()));

                    break;
                }

                case 2 ->{

                    System.out.println("Ведіть назву страви.");
                    String dishName = scanner.next();
                    System.out.println("Введіть ціну для страви.");
                    Double dishPrice = scanner.nextDouble();

                    if (dishName == null || dishPrice == null){
                        System.err.println("Ви не ввели значення, почніть заново");
                        continue;
                    }

                    cafeDB.addDish(dishName, dishPrice);
                    System.out.println("Страву успішно додано.");
                    break;
                }

                case 3 ->{

                    System.out.println("Введіть стару назву страви.");
                    String oldName = scanner.next();

                    System.out.println("Введіть нову назву страви.");
                    String newName = scanner.next();

                    System.out.println("Введіть нову ціну для страви.");
                    Double newPrice = scanner.nextDouble();

                    if (oldName == null || newName == null || newPrice == null){
                        System.err.println("Ви не ввели значення, почніть заново");
                        continue;
                    }else {
                        cafeDB.updateDish(oldName, newName, newPrice);
                        break;
                    }
                }

                case 4 ->{

                    System.out.println("Введіть ім'я страви, що потрібно видалити.");
                    String deletedDishName = scanner.next();

                    System.out.println("Ви правда хочете видалити страву. yes / no");
                    if (scanner.next().equalsIgnoreCase("yes")){
                        cafeDB.deleteDish(deletedDishName);
                        System.out.println("Страву видалено.");
                        break;
                    }else {
                        continue;
                    }

                }
            }

        }

    }


}
