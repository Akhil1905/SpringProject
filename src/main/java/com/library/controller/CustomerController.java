package com.library.controller;



import com.library.customerinfo.Customer;
import com.library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Customer> getCustomers() {
//        return customerRepository.findAll();
//    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@PathVariable Integer id) {

        return customerRepository.findCustomerById(id);
    }

    @RequestMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable Integer id){

        Customer updateCustomer=   customerRepository.findCustomerById(id);

        updateCustomer.setId(customer.getId());
        updateCustomer.setFirstName(customer.getFirstName());

        updateCustomer.setLastName(customer.getLastName());
        customerRepository.save(updateCustomer);

        return new ResponseEntity<Customer>(updateCustomer, HttpStatus.OK);

          }

    @RequestMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id){

        Customer deleteCustomer=   customerRepository.findCustomerById(id);

        customerRepository.delete(deleteCustomer);

        return new ResponseEntity<Customer>(deleteCustomer, HttpStatus.NO_CONTENT);

    }
}