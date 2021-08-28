package pl.sujecki.indiana.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sujecki.indiana.model.Item;
import pl.sujecki.indiana.model.User;
import pl.sujecki.indiana.service.ItemService;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{username}/item")
    public List<Item> getAllItemByUsername(@PathVariable String username){
        return itemService.findAllByUsername(username);
    }

    @PostMapping(value = "/add/item",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewUser(@RequestBody Item item){
        itemService.addNewItem(item);
    }

}
