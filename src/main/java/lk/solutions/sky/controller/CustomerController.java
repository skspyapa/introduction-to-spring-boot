package lk.solutions.sky.controller;

import lk.solutions.sky.entity.Customer;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    public Customer getCustomer() {return new Customer();}
}
