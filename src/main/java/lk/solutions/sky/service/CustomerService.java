package lk.solutions.sky.service;

import lk.solutions.sky.entity.Customer;
import lk.solutions.sky.exception.CustomerNotFoundException;
import lk.solutions.sky.mappper.CustomerMapper;
import lk.solutions.sky.mappper.CustomerRequest;
import lk.solutions.sky.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id)));
    }

    public void update(CustomerRequest request) {
        var customer = customerRepository.findById(request.id())
                .orElseThrow(()-> new CustomerNotFoundException(String.format("Cannot update Customer:: No Customer found with the provided ID: %s", request.id())));
        this.customerRepository.save(customerMapper.toCustomer(request));
    }
}
