package com.indiana.controllers;

import com.indiana.models.User;
import com.indiana.services.UserDetailsService;
import com.indiana.services.UserService;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public ResponseEntity<Object> updateUserDetails(@RequestParam(required = false) Long id, @RequestParam(required = false) String name,
                                           @RequestParam(required = false) String surname, @RequestParam(required = false) String phone,
                                           @RequestParam(required = false) String description, @RequestParam(required = false) String placeOfLiving,
                                           @RequestPart(required = false) MultipartFile imageProfile) {
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

    @GetMapping("/changePassword")
    public ResponseEntity<Map<String, Object>> changePassword(
            @RequestParam(required = true) Long id,
            @RequestParam(required = true) String oldPassword,
            @RequestParam(required = true) String password
    ) {
        try{
            Map<String, Object> response = new HashMap<>();
            if(userService.changePassword(id, oldPassword, password)){
                response.put("status", "Hasło zostało zmienione");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else{
                response.put("status", "Hasło nie zostało zmienione");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {

        try {
            List<User> users = new ArrayList<User>();
            Pageable paging = PageRequest.of(page, size, Sort.by("username").descending());

            Page<User> pageTuts;

            pageTuts = userService.getAll(paging);

            users = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("users", users);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
