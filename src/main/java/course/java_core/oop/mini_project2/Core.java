package course.java_core.oop.mini_project2;

import course.java_core.oop.mini_project2.services.managers.AuthorManager;
import course.java_core.oop.mini_project2.services.managers.CustomerManager;

import java.util.Scanner;

public final class Core {

    public void start(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Вітаю.");
        System.out.println("1 - Ввійти як автор.");
        System.out.println("2 - Ввійти як користувач.");
        System.out.println("Оберіть один пункт.");
        int option = scanner.nextInt();

        switch (option){

            case 1: {

                AuthorManager authorManager = new AuthorManager();
                authorManager.startAsAuthor(scanner);

                break;
            }
            case 2:{

                CustomerManager customerManager = new CustomerManager();
                customerManager.startAsCustomer(scanner);

                break;
            }
        }

    }
}
