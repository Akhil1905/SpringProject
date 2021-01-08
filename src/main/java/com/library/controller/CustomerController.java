package com.library.controller;



import com.library.customerinfo.Customer;
import com.library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value=CustomerController.ENDPOINT)
public class CustomerController {

    public static final String ENDPOINT= "/CustomerInfo";

    @Autowired
    private CustomerRepository customerRepository;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);

       return "Added new customer to repo!";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }
//
//    @GetMapping("/find/{id}")
//    public Customer findCustomerById(@PathVariable Integer id) {
//        return customerRepository.findCustomerById(id);
//    }
}