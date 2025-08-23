package lk.solutions.sky.controller;

import lk.solutions.sky.entity.Customer;
import lk.solutions.sky.service.CustomerService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerMockitoTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void findById() throws BadRequestException {
        Customer customer =  new Customer(1L, "John", "Doe");
        when(customerService.findById(1)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.findById(1);
        assertEquals(200, response.getStatusCode().value());
        Assertions.assertNotNull(response.getBody());
        assertEquals("John", response.getBody().getFirstName());
    }
}
