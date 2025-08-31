package course.java_core.oop.mini_project2.services.managers;

import course.java_core.oop.mini_project2.models.Author;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface AuthorAuthorizationAndAuthenticationManager {


    default Author register(Scanner scanner){

        Author author = new Author();
        System.out.println("Введіть ім'я автора.");
        String firstName = scanner.next();

        System.out.println("Введіть прізвище автора.");
        String lastName = scanner.next();

        System.out.println("Введіть username для автора.");
        String username = scanner.next();

        String password;

        while (true){
            System.out.println("Придумайте пароль для автора.");
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

        System.out.println("Ведіть дату народження автора (dd-MM-yyyy): ");
        String date = scanner.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = LocalDate.parse(date, formatter);

        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setUsername(username);
        author.setPassword(password);
        author.setDateOfBirth(dateOfBirth);

        return author;
    }

    default String login(Scanner scanner){
        System.out.println("Введіть username автора.");
        String username = scanner.next();

        System.out.println("Введіть password.");
        String password = scanner.next();

        return username + " " + password;

    }


}
