package lk.solutions.sky.service;

import lk.solutions.sky.entity.Customer;
import lk.solutions.sky.repository.CustomerRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer findById(int id) throws BadRequestException {
        return customerRepository.findById(id).orElseThrow(BadRequestException::new);
    }
}
