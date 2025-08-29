package course.java_core.oop.mini_project2.services.user_services;

import course.java_core.oop.mini_project2.db.LibraryDB;
import course.java_core.oop.mini_project2.models.Book;
import course.java_core.oop.mini_project2.models.Customer;
import course.java_core.oop.mini_project2.services.security_services.LoginService;
import course.java_core.oop.mini_project2.services.security_services.RegisterService;

import java.util.List;

public final class CustomerService extends UserService implements LoginService<Customer>, RegisterService<Customer> {

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

    @Override
    public boolean login(String username, String password) {
        return LibraryDB.customers.stream().filter(customer -> customer.getUsername().equals(username) && customer.getPassword().equals(password))
                .findFirst().get() != null? true: false;
    }

    @Override
    public boolean register(Customer customer) {

        if (customer == null){
            System.err.println("Запис користувача не валідний.");
            return false;
        }
        else {
            LibraryDB.customers.add(customer);
            return true;
        }

    }
}
