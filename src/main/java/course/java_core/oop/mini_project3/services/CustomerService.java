package course.java_core.oop.mini_project3.services;

import course.java_core.oop.mini_project3.models.Account;
import course.java_core.oop.mini_project3.models.Bank;
import course.java_core.oop.mini_project3.models.Customer;


public final class CustomerService {

    public boolean createCustomer(int id, String username, Account account){
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.addAccount(account);
        customer.setId(id);
        return Bank.customers.add(customer);
    }

    public boolean deleteCustomer(String username){
        return Bank.customers.remove(getCustomerByUsername(username));
    }

    public Customer getCustomerByUsername(String username){

        return  Bank.customers.stream().filter(customer -> customer.getUsername().equals(username))
                .findFirst().get();

    }

}
