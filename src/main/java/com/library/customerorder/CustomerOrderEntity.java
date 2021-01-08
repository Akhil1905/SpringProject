package com.library.customerorder;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;


    private String orderName;
//    Customer customerOrder;
    public Integer getOrderId() {

        return orderId;
    }

    public void setOrderName(String orderName){
        this.orderName=orderName;

    }


    public String getOrderName(){

        return orderName;
    }
//    public Customer getCustomerInfo(){
//
//        customerOrder=  new Customer();
//        return customerOrder;
//    }



}
