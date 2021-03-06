package com.indiana.controllers;

import com.indiana.models.Item;
import com.indiana.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/userItem")
    public ResponseEntity<Map<String, Object>> getAllItems(
            @RequestParam(required = false) Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        try {
            List<Item> items = new ArrayList<Item>();
            Pageable paging = PageRequest.of(page, size, Sort.by("dateFound").descending());

            Page<Item> pageTuts;
            if (id == null) {
                pageTuts = itemService.getAll(paging);
            } else{
                 pageTuts = itemService.getAllItemsByUserId(id, paging);
            }
            items = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("items", items);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(path = "/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> saveItem(@RequestParam String name, @RequestParam String description,
                                               @RequestParam Long user, @RequestParam Date dateFound,
                                               @RequestPart MultipartFile image) {
        itemService.addItem(name, description, user, dateFound, image);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path="/byCoordinates")
    public ResponseEntity<Object> getLastItemByCoordinates(@RequestParam Date dateStart, @RequestParam Date dateEnd){
        try{
            List<Item> response = itemService.getAllByMonth(dateStart, dateEnd);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
