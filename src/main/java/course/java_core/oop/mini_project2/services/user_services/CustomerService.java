package course.java_core.oop.mini_project2.services.user_services;

import course.java_core.oop.mini_project2.db.LibraryDB;
import course.java_core.oop.mini_project2.models.Book;
import course.java_core.oop.mini_project2.models.Customer;

import java.util.List;

public final class CustomerService extends UserService{

    public Customer setIntendToReadBook(Book book, Customer customer){
        customer.setIntendToRead(book);
        return customer;
    }

    public Customer setActiveReadBook(Book book, Customer customer){
        customer.setActiveRead(book);
        return customer;
    }

    public Customer setDoneRead(Book book, Customer customer){
        customer.setDoneRead(book);
        return customer;
    }

}
