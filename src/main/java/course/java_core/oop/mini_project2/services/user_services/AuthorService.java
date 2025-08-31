package course.java_core.oop.mini_project2.services.user_services;


import course.java_core.oop.mini_project2.db.LibraryDB;
import course.java_core.oop.mini_project2.models.Author;
import course.java_core.oop.mini_project2.models.Book;
import course.java_core.oop.mini_project2.services.security_services.LoginService;
import course.java_core.oop.mini_project2.services.security_services.RegisterService;

import java.util.Optional;

public final class AuthorService extends UserService implements LoginService<Author>, RegisterService<Author> {



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


    @Override
    public Author login(String username, String password) {
        return LibraryDB.authors.stream().filter(author -> author.getUsername().equals(username) && author.getPassword().equals(password))
                .findFirst().get();
    }

    @Override
    public Author register(Author author) {
        if (author == null){
            System.err.println("Запис автора не валідний.");
            return author;
        }
        else {
            LibraryDB.authors.add(author);
            return author;
        }
    }
}
