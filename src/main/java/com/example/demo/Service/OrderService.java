package com.example.demo.Service;

import com.example.demo.DTO.OrderRequest;
import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Item;
import com.example.demo.Entity.Order;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.GroceryItemRepository;
import com.example.demo.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private  final OrderRepository orderRepository;
    private final GroceryItemRepository groceryItemRepository;
    private  final CustomerRepository customerRepository;


    public Order createOrder(OrderRequest orderRequest){

        Customer customer=customerRepository.findById(orderRequest.getCustomerId()).orElseThrow(()-> new RuntimeException("customer not found with the id"));


        List<Item> groceryItems =
                groceryItemRepository.findAllById(
                        orderRequest.getGroceriesItemsId()
                );

        BigDecimal totalprice=groceryItems.stream().map(Item::getPrice).reduce(BigDecimal.ZERO, (a,b)->a.add(b));

        Order order=new Order();
        order.setCustomer(customer);
        order.setItem(groceryItems);
        order.setTotalprice(totalprice);
        order.setOrderdate(LocalDateTime.now());


        return orderRepository.save(order);
    }

}
