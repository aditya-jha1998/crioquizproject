package com.example.demo.Service;

import com.example.demo.Entity.Item;
import com.example.demo.Repository.GroceryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private  final GroceryItemRepository groceryItemRepository;


    public Item createGroceryItems(Item groceryitems){
        return  groceryItemRepository.save(groceryitems);
    }

    public List<Item> getAllitems(){
       return  groceryItemRepository.findAll();
    }

    public Optional<Item>  getGroceryItemByid(Long id){
        return groceryItemRepository.findById(id);
    }

    public  Item updateGroceryItem(Long id, Item groceryitems){
        Item existingitem=groceryItemRepository.findById(id).orElseThrow(()-> new RuntimeException("Grocery itms not foind with id"+id));
        existingitem.setName(groceryitems.getName());
        existingitem.setCategory(groceryitems.getCategory());
        existingitem.setPrice(groceryitems.getPrice());
        existingitem.setQuantity(groceryitems.getQuantity());

        return existingitem;
    }

    public  void deleteByGroceryitems(Long id){
        groceryItemRepository.deleteById(id);
    }
}
