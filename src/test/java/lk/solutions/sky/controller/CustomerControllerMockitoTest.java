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
    /*
    * @Mock
    * Creates a mock object of a class/interface.
    * The mock is a fake object that you control with when(...).thenReturn(...).
    * It does not run real logic, it only returns what you configure.
    */
    private CustomerService customerService;

    @InjectMocks
    /*
    * @InjectMocks
    * Creates a real object of the class under test.
    * Injects the mocks (created with @Mock) into it automatically.
    * Works by constructor injection, setter injection, or field injection.
    */
    private CustomerController customerController;

    @Test
    void findById() throws BadRequestException {
        Customer customer =  new Customer(1L, "John", "Doe");
        when(customerService.findById(1L)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.findById(1L);
        assertEquals(200, response.getStatusCode().value());
        Assertions.assertNotNull(response.getBody());
        assertEquals("John", response.getBody().getFirstName());
    }
}
