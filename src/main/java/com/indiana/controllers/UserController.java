package com.indiana.controllers;


import com.indiana.models.User;
import com.indiana.services.UserDetailsService;
import com.indiana.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @PostMapping(path = "/updateDetails", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> updateUserDetails(@RequestParam Long id, @RequestParam String name,
                                           @RequestParam String surname, @RequestParam String phone,
                                           @RequestParam String description, @RequestParam String placeOfLiving,
                                           @RequestPart MultipartFile imageProfile) {
        userDetailsService.updateUserDetails(id, name, surname, phone, description, placeOfLiving, imageProfile);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getUser(
            @RequestParam(required = true) Long id
    ) {
        try{
            User user = userService.getUser(id);

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    };

}
