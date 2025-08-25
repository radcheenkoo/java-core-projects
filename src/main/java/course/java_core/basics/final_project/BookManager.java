package course.java_core.basics.final_project;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class BookManager {

    public static int amountOfBook = 0;
    private BookList list = new BookList();

    public void crateBookList(){

        list.addBook(new Book("Clean Code","Robert Martin", 368));
        list.addBook(new Book("Clean Coder","Robert Martin", 368));
        list.addBook(new Book("Clean Agile","Robert Martin", 368));
        list.addBook(new Book("Clean Architecture","Robert Martin", 368));
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("ВІТАЮ");


        while (true){

            System.out.println("Оберіть функцію.");
            System.out.println();
            System.out.println("1 - Вивести всі книги на екран");
            System.out.println("2 - Сортувати книги за сторінками");
            System.out.println("3 - Клонувати книгу та показати, що це окремий об’єкт");
            System.out.println("4 - Порахувати загальну кількість книг");

            int option = scanner.nextInt();

            switch (option){

                case 1:{

                    for (int i = 0; i < list.getSize(); i++) {
                        System.out.println(list.getBook(i));
                    }


                    break;
                }
                case 2: {
//
                    for (int i = 0; i < list.getSize() - 1; i++) {
                        for (int j = 0; j < list.getSize() - i - 1; j++) {
                            if (list.getBook(j).compareTo(list.getBook(j + 1)) > 0) {
                                // міняємо місцями
                                Book temp = list.getBook(j);
                                list.setBook(j, list.getBook(j + 1));
                                list.setBook(j + 1, temp);
                            }
                        }
                    }

                    for (int i = 0; i < list.getSize(); i++) {
                        System.out.println(list.getBook(i));
                    }
                    break;
                }

                case 3:{

                    System.out.println("Введіть індекс книги");

                    int index = scanner.nextInt();

                    for (int i = 0; i < list.getSize(); i++) {
                        if (index == i){
                            System.out.println(list.getBook(i));
                            System.out.println("Це копія книги вище - " + list.getBook(i).clone());
                        }
                    }

                    break;
                }

                case 4:{

                    System.out.println("Загальна кількість книг - " + list.getSize());

                    break;
                }
            }


            System.out.println("бажаєте продовжити? yes/no");

            if(scanner.next().equalsIgnoreCase("yes")){
                continue;
            }else {
                return;
            }
        }


    }

}
