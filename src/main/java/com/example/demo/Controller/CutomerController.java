package com.example.demo.Controller;

import com.example.demo.Entity.Customer;
import com.example.demo.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CutomerController {

    private  final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){

        return ResponseEntity.ok(customerService.createCustomer(customer));

    }

    @GetMapping
    public  ResponseEntity<List<Customer>> getAllCustomer(){
        return  ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerByid(@PathVariable  Long id){
        return customerService.getCustomerByid(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return  ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }



    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomer(id);

        return  ResponseEntity.noContent().build();
    }


}
