package course.java_core.oop.mini_project2.services.managers;

import course.java_core.oop.mini_project2.models.Author;
import course.java_core.oop.mini_project2.services.user_services.AuthorService;

import java.util.Optional;
import java.util.Scanner;

public final class AuthorManager implements AuthorAuthorizationAndAuthenticationManager{

    private final AuthorService authorService;


    public AuthorManager() {
        this.authorService = new AuthorService();
    }



    public void startAsAuthor(Scanner scanner){

        if (checkIsNewAuthor(scanner)){

            switch (systemMenu(scanner)){

                case 1:{



                    break;
                }
                case 2:{

                    break;
                }
                case 3:{

                    break;
                }
                case 4:{

                    break;
                }


            }

        }else {
            System.out.println("Ви не ввійшли, не правильний username або password.");
        }


    }

    private boolean checkIsNewAuthor(Scanner scanner){

        System.out.println("У вас вже є акаунт автора. yes/no");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("yes")){
            return authorService.register(register(scanner));
        }
        else {
            String[] arr = login(scanner).split(" ");
            return authorService.login(arr[0], arr[1]);
        }

    }

    private int systemMenu(Scanner scanner){
        System.out.println("Функціонал.");

        System.out.println("1 - Додати книгу.");
        System.out.println("2 - Видалити книгу.");
        System.out.println("3 - Оновити книгу.");
        System.out.println("4 - Отримати поточні книги.");

        return scanner.nextInt();
    }


}
