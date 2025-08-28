package course.java_core.oop.mini_project2.services.user_services;

import course.java_core.oop.mini_project2.db.LibraryDB;
import course.java_core.oop.mini_project2.models.Author;
import course.java_core.oop.mini_project2.models.Book;

import java.util.List;

public abstract class UserService {

    public List<Book> getAllBooks(){
        return LibraryDB.books;
    }

    public List<Book> getAllBooksByAuthor(Author author){
        return LibraryDB.books.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

}
