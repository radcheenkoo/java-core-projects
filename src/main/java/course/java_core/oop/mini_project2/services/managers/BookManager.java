package course.java_core.oop.mini_project2.services.managers;

import course.java_core.oop.mini_project2.models.Author;
import course.java_core.oop.mini_project2.models.Book;
import course.java_core.oop.mini_project2.models.enums.Genre;
import course.java_core.oop.mini_project2.services.BookService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public final class BookManager {

    private final BookService bookService;

    public BookManager() {
        this.bookService = new BookService();
    }


    public Book createBook(Scanner scanner, Author author){

        Book book = new Book();

        System.out.println("Введіть назву книги.");
        String title = scanner.next();

        System.out.println("Введіть опис для книги.");
        String description = scanner.next();

        System.out.println("Введіть вартість книги.");
        double price = scanner.nextDouble();

        System.out.println("Введіть жанр книги. Перелік доступних жанрів.");
        showAvailableGenres();
        String strGenre = scanner.next();
        Genre genre = Genre.valueOf(strGenre);

        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);
        book.setPrice(price);
        book.setGenre(genre);
        book.setWrittenAt(LocalDate.now());

        bookService.addBook(book);
        return book;
    }

    public boolean removeBookByAuthor(Scanner scanner, Author author){

        List<Book> books = bookService.getBooksByAuthor(author);

        books.forEach(book -> {
            System.out.println(book.toString());
        });
        System.out.println("Виберіть з доступних книг ту яка вам потрібна. Введіть її індекс, починаючи з нуля на початку.");

        int index = scanner.nextInt();
        Book b = new Book();
        if (books.contains(books.get(index))) {
            b = books.get(index);
        }else {
            System.err.println("Не вірний індекс.");
        }
        return bookService.deleteBook(b);

    }

    public boolean updateBook(Scanner scanner){

            List<Book> books = bookService.getAllBooks();

            System.out.println("Введіть назву книги, яку хочете оновити:");
            String bookTitle = scanner.nextLine();

            // Пошук книги за назвою (ігноруючи регістр)
            Optional<Book> optionalBook = books.stream()
                    .filter(book -> book.getTitle().equalsIgnoreCase(bookTitle)
                            || book.getTitle().toLowerCase().contains(bookTitle.toLowerCase()))
                    .findFirst();

            if (optionalBook.isEmpty()) {
                System.out.println("Книга з такою назвою не знайдена.");
                return false;
            }

            Book oldBook = optionalBook.get();
            int position = books.indexOf(oldBook);

            System.out.println("Введіть нову назву книги:");
            String newTitle = scanner.nextLine();

            System.out.println("Введіть опис для книги:");
            String description = scanner.nextLine();

            System.out.println("Введіть вартість книги:");
            double price;
            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Невірний формат ціни.");
                return false;
            }

            System.out.println("Введіть жанр книги. Перелік доступних жанрів:");
            showAvailableGenres();
            String strGenre = scanner.nextLine().toUpperCase();

            Genre genre;
            try {
                genre = Genre.valueOf(strGenre);
            } catch (IllegalArgumentException e) {
                System.out.println("Невірно введений жанр.");
                return false;
            }

            // Оновлення книги
            oldBook.setTitle(newTitle);
            oldBook.setDescription(description);
            oldBook.setPrice(price);
            oldBook.setGenre(genre);
            oldBook.setWrittenAt(LocalDate.now());

            return bookService.updateBookById(position, oldBook);

    }

    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
































    // ------------------------ helpers ------------------------



    private void showAvailableGenres(){
        System.out.println("Доступні жанри.");
        for (int i = 0; i < Genre.values().length; i++) {
            System.out.println(Genre.values()[i]);
        }
    }
}
