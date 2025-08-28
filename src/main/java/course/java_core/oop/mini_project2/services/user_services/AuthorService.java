package course.java_core.oop.mini_project2.services.user_services;


import course.java_core.oop.mini_project2.db.LibraryDB;
import course.java_core.oop.mini_project2.models.Book;

import java.util.Optional;

public final class AuthorService extends UserService {



    public Optional<Book> addWrittenBook(Book book){

        if (book == null){
            System.err.println("Книга пуста. Книгу не додано.");
            return Optional.ofNullable(book);
        }else {

            LibraryDB.books.add(book);
            System.out.println("Книгу додано.");
            return Optional.of(book);
        }
    }



}
