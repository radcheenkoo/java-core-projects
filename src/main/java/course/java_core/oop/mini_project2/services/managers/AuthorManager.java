package course.java_core.oop.mini_project2.services.managers;

import course.java_core.oop.mini_project2.models.Author;
import course.java_core.oop.mini_project2.models.Book;
import course.java_core.oop.mini_project2.services.user_services.AuthorService;

import java.util.Scanner;

public final class AuthorManager implements AuthorAuthorizationAndAuthenticationManager{

    private final AuthorService authorService;
    private final BookManager bookManager;

    public AuthorManager() {
        this.authorService = new AuthorService();
        this.bookManager = new BookManager();

    }



    public void startAsAuthor(Scanner scanner){
        Author author = getAuthor(scanner);
        if (author != null){

            switch (systemMenu(scanner)){

                case 1:{

                    System.out.println("Створення книги.");
                    Book book = bookManager.createBook(scanner, author);
                    System.out.println("Створена книга --> " + book.toString());
                    break;
                }
                case 2:{

                    System.out.println("Книга видалена --> " + bookManager.removeBookByAuthor(scanner, author));

                    break;
                }
                case 3:{


                    System.out.println("Книга оновлена --> " + bookManager.updateBook(scanner));

                    break;
                }
                case 4:{

                    bookManager.getAllBooks().forEach(book -> System.out.println(book.toString()));

                    break;
                }


            }

        }else {
            System.out.println("Ви не ввійшли, не правильний username або password.");
        }


    }

    private Author getAuthor(Scanner scanner){

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
