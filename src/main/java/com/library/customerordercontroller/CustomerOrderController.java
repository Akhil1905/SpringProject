package com.library.customerordercontroller;



import com.library.controller.CustomerController;
import com.library.customerorder.CustomerOrderEntity;
import com.library.customerorderrepository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= CustomerOrderController.ENDPOINT)
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

