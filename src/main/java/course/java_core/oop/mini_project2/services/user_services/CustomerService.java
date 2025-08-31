package course.java_core.oop.mini_project2.services.user_services;

import course.java_core.oop.mini_project2.db.LibraryDB;
import course.java_core.oop.mini_project2.models.Author;
import course.java_core.oop.mini_project2.models.Book;
import course.java_core.oop.mini_project2.models.Customer;
import course.java_core.oop.mini_project2.services.security_services.LoginService;
import course.java_core.oop.mini_project2.services.security_services.RegisterService;


public final class CustomerService extends UserService implements LoginService<Customer>, RegisterService<Customer> {

    public boolean setIntendToReadBook(Book book, Customer customer){
        return customer.setIntendToRead(book);

    }

    public boolean setActiveReadBook(Book book, Customer customer){
        return customer.setActiveRead(book);

    }

    public boolean setDoneRead(Book book, Customer customer){
        return customer.setDoneRead(book);

    }

    @Override
    public Customer login(String username, String password) {
        return LibraryDB.customers.stream().filter(customer -> customer.getUsername().equals(username) && customer.getPassword().equals(password))
                .findFirst().get();
    }

    @Override
    public Customer register(Customer customer) {

        if (customer == null){
            System.err.println("Запис користувача не валідний.");
            return customer;
        }
        else {
            LibraryDB.customers.add(customer);
            return customer;
        }

    }
}
