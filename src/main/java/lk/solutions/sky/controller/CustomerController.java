package lk.solutions.sky.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lk.solutions.sky.entity.Customer;
import lk.solutions.sky.mappper.CustomerRequest;
import lk.solutions.sky.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @Operation(summary = "Get User By ID", description = "Return Single User on their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user"),
            @ApiResponse(responseCode = "404", description = "User Not Found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @Operation(summary = "Update User", description = "Update Existing User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully update user"),
            @ApiResponse(responseCode = "404", description = "User Not Found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid CustomerRequest request) {
        customerService.update(request);
        return ResponseEntity.accepted().build();
    }
}
