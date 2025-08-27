package lk.solutions.sky.controller;

import lk.solutions.sky.entity.Customer;
import lk.solutions.sky.service.CustomerService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerJunitTest {

    private CustomerController customerController;

    @BeforeEach
    void setup() {
        customerController = new CustomerController();
        customerController.customerService = new FakeCustomerService();
    }

    @Test
    void findById() throws BadRequestException {
        ResponseEntity<Customer> response = customerController.findById(1L);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        Assertions.assertNotNull(response.getBody());
        assertEquals("Test", response.getBody().getFirstName());
    }

    static class FakeCustomerService extends CustomerService {
        @Override
        public Customer findById(Long id) {
            return new Customer(id, "Test", "User");
        }
    }
}
