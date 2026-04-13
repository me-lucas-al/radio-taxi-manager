package control;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerController {
    private List<Customer> customers = new ArrayList<>();

    public Customer registerCustomer(String name) {
        Customer newCustomer = new Customer(name);
        customers.add(newCustomer);
        return newCustomer;
    }

    public Customer findCustomerByCode(UUID code) {
        for (Customer customer : customers) {
            if (customer.getCode().equals(code)) return customer;
        }
        return null;
    }
}