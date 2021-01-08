package com.library.controller;


import com.library.com.library.customerorderrepository.CustomerOrderRepository;

import com.library.customerorder.CustomerOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value=CustomerController.ENDPOINT)
public class CustomerOrderController {

    public static final String ENDPOINT="/CustomerOrder";

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addCustomerOrder(@RequestBody CustomerOrderEntity customerOrder) {
        customerOrderRepository.save(customerOrder);

        return "Added new customer Order to repo!";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<CustomerOrderEntity> getCustomerOrder(){

        return customerOrderRepository.findAll();
    }


}
