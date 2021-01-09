package com.library.customerorderrepository;

import com.library.customerorder.CustomerOrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrderEntity, Integer> {

    CustomerOrderEntity findCustomerOrderById(Integer orderId);

}

