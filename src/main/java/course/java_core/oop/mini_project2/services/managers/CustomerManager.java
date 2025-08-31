package course.java_core.oop.mini_project2.services.managers;

import course.java_core.oop.mini_project2.models.Book;
import course.java_core.oop.mini_project2.models.Customer;
import course.java_core.oop.mini_project2.services.BookService;
import course.java_core.oop.mini_project2.services.user_services.CustomerService;

import java.net.FileNameMap;
import java.util.List;
import java.util.Scanner;

public final class CustomerManager implements CustomerAuthorizationAndAuthenticationManager {

    private final CustomerService customerService;
    private final BookManager bookManager;

    public CustomerManager() {
        this.customerService = new CustomerService();
        this.bookManager = new BookManager();
    }

    public void startAsCustomer(Scanner scanner){

        Customer customer = getCustomer(scanner);

        if (customer != null){

            switch (systemMenu(scanner)){

                case 1:{

                    bookManager.getAllBooks().forEach(book -> System.out.println(book.toString()));

                    break;
                }
                case 2:{

                    List<Book> books = bookManager.getAllBooks();

                    books.forEach(book -> System.out.println(book.toString()));
                    System.out.println("Виберіть з доступних книг ту яка вам потрібна. Введіть її індекс, починаючи з нуля на початку.");
                    int index = scanner.nextInt();

                    if (books.get(index) != null){

                        System.out.println("Книгу до списку запланованих книг додано --> " + customerService.setIntendToReadBook(books.get(index), customer));
                    }

                    break;
                }
                case 3:{

                    List<Book> books = bookManager.getAllBooks();

                    books.forEach(book -> System.out.println(book.toString()));
                    System.out.println("Виберіть з доступних книг ту яка вам потрібна. Введіть її індекс, починаючи з нуля на початку.");
                    int index = scanner.nextInt();

                    if (books.get(index) != null){

                        System.out.println("Книгу до списку запланованих книг додано --> " + customerService.setActiveReadBook(books.get(index), customer));
                    }

                    break;
                }
                case 4:{

                    List<Book> books = bookManager.getAllBooks();

                    books.forEach(book -> System.out.println(book.toString()));
                    System.out.println("Виберіть з доступних книг ту яка вам потрібна. Введіть її індекс, починаючи з нуля на початку.");
                    int index = scanner.nextInt();

                    if (books.get(index) != null){

                        System.out.println("Книгу до списку запланованих книг додано --> " + customerService.setDoneRead(books.get(index), customer));
                    }

                    break;
                }

            }

        }else {
            System.out.println("Ви не ввійшли, не правильний username або password.");
        }


    }

    private Customer getCustomer(Scanner scanner){

        System.out.println("У вас вже є акаунт користувача. yes/no");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("yes")){
            return customerService.register(register(scanner));
        }
        else {
            String[] arr = login(scanner).split(" ");
            return customerService.login(arr[0], arr[1]);
        }

    }

    private int systemMenu(Scanner scanner){
        System.out.println("Функціонал.");

        System.out.println("1 - Переглянути всі книги.");
        System.out.println("2 - Додати книгу до списку запланованих.");
        System.out.println("3 - Додати книгу до списку активних в читанні.");
        System.out.println("4 - Додати книгу до списку прочитаних.");

        return scanner.nextInt();
    }

}
