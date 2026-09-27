package com.example.demo.Service;

import com.example.demo.Entity.Customer;
import com.example.demo.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private  final CustomerRepository customerRepository;
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByid(long id){
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Long id , Customer customer){
        Customer existingCustomer=customerRepository.findById(id).orElseThrow(()-> new RuntimeException("customer not found with id"+id));
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());

        return existingCustomer;

    }

    public  void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }
}
