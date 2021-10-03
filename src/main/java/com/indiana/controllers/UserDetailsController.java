package com.indiana.controllers;


import com.indiana.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping(path = "/updateDetails", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Object> updateUserDetails(@RequestParam Long id, @RequestParam String name,
                                           @RequestParam String surname, @RequestParam String phone,
                                           @RequestParam String description, @RequestParam String placeOfLiving,
                                           @RequestPart MultipartFile imageProfile) {
        userDetailsService.updateUserDetails(id, name, surname, phone, description, placeOfLiving, imageProfile);
        return ResponseEntity.ok().build();
    }
}
