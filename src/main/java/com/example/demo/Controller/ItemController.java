package com.example.demo.Controller;

import com.example.demo.Entity.Item;
import com.example.demo.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
@RequiredArgsConstructor
public class ItemController {

    private  final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> createGroceriesItems(@RequestBody Item items){
        return ResponseEntity.ok(itemService.createGroceryItems(items));
    }

    @GetMapping
    public  ResponseEntity<List<Item>> fetchAllItems(){
        return  ResponseEntity.ok(itemService.getAllitems());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Item> fetchItemsByid(@PathVariable Long id){
        return itemService.getGroceryItemByid(id).map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Item> updatesItemsByid(@PathVariable Long id , @RequestBody Item items){
        return ResponseEntity.ok(itemService.updateGroceryItem(id, items));
    }

    @DeleteMapping("/{id}")

    public  ResponseEntity<Void> deleteItemsByid(@PathVariable Long id){
        itemService.deleteByGroceryitems(id);

       return  ResponseEntity.noContent().build();
    }
}
