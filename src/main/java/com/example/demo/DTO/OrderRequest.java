package com.example.demo.DTO;

import com.example.demo.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private  long customerId;

    private  List<Long> groceriesItemsId;




}
