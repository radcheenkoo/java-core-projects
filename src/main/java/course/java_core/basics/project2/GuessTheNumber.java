package course.java_core.basics.project2;

import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        start();
    }

    public static void start(){

        final Scanner scanner = new Scanner(System.in);
        System.out.println("Гра вгадай число за 10 спроб");
        System.out.println("Виберіть діапазон до якого буде обрано число.");
        int range = scanner.nextInt();
        int number, limit = 0;
        int randomNumber = (int) (Math.random() * range);


        while (true){


            System.out.println("Вводьте число.");
            number = scanner.nextInt();

            if (randomNumber == number){
                System.out.println("Вітаю, ви виграли. бажаєте спробувати ще? yes/no");
                if (scanner.next().equalsIgnoreCase("yes")){
                    randomNumber = (int) (Math.random() * range);
                    limit = 0;
                    continue;
                }else {
                    break;
                }
            }else if (randomNumber > number){
                System.out.println("Вище");
                continue;
            }else if (randomNumber < number){
                System.out.println("Нижче");
                continue;
            }

            limit++;

            if (limit == 10){
                System.out.println("Ви програли. бажаєте спробувати ще? yes/no");
                if (scanner.next().equalsIgnoreCase("yes")){
                    randomNumber = (int) (Math.random() * range);
                    limit = 0;
                    continue;
                }else {
                    break;
                }
            }

        }

    }

}
