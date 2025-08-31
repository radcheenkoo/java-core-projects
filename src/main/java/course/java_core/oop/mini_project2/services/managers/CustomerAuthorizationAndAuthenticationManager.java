package course.java_core.oop.mini_project2.services.managers;

import course.java_core.oop.mini_project2.models.Customer;

import java.util.Scanner;

public interface CustomerAuthorizationAndAuthenticationManager {

    default Customer register(Scanner scanner){

        Customer customer = new Customer();

        System.out.println("Введіть ім'я користувача.");
        String firstName = scanner.next();

        System.out.println("Введіть прізвище користувача.");
        String lastName = scanner.next();

        System.out.println("Введіть username для користувача.");
        String username = scanner.next();

        String password;

        while (true){
            System.out.println("Придумайте пароль для користувача.");
            String pass1 = scanner.next();
            System.out.println("Повторіть пароль.");
            String pass2 = scanner.next();

            if (pass1.equals(pass2)){
                password = pass1;
                break;
            }
            else {
                System.out.println("Повторіть ще раз.");
            }
        }


        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setUsername(username);
        customer.setPassword(password);


        return customer;
    }

    default String login(Scanner scanner){
        System.out.println("Введіть username користувача.");
        String username = scanner.next();

        System.out.println("Введіть password.");
        String password = scanner.next();

        return username + " " + password;

    }

}
