package course.java_core.oop.mini_project2.services;

import course.java_core.oop.mini_project2.db.LibraryDB;
import course.java_core.oop.mini_project2.models.Author;
import course.java_core.oop.mini_project2.models.Book;

import java.util.List;

public final class BookService {

    public void addBook(Book book){
        if(!book.equals(null)){
            LibraryDB.books.add(book);
        }
        else {
            System.out.println("Книга пуста. її неможливо додати.");
        }
    }

    public boolean updateBookById(int index, Book book){

        if(!book.equals(null)){
            LibraryDB.books.set(index, book);
            return true;
        }else {
            return false;
        }

    }

    public boolean deleteBook(Book book){
        if (!book.equals(null)){
            LibraryDB.books.remove(book);
            return true;
        }else{
            System.out.println("Книга пуста. її неможливо видалити.");
            return false;
        }
    }

    public Book getBookByIndex(int index){
        return LibraryDB.books.get(index);
    }

    public List<Book> getBooksByAuthor(Author author){
        return LibraryDB.books.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    public List<Book> getAllBooks(){
        return LibraryDB.books;
    }

}
