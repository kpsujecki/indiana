package com.indiana.services;


import com.indiana.models.User;
import com.indiana.models.UserDetails;
import com.indiana.repository.UserDetailsRepository;
import com.indiana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public void updateUserDetails(Long id, String name, String surname,
                                  String phone, String description, String placeOfLiving, MultipartFile imageProfile){
        byte [] byteImage= new byte[0];
        try {
                if(imageProfile != null) byteImage = imageProfile.getBytes();

        } catch (IOException e) {
            e.printStackTrace();
        }


        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));

        UserDetails userDetails = user.getUserDetails();
        userDetails.setName(name);
        userDetails.setSurname(surname);
        userDetails.setPhone(phone);
        userDetails.setDescription(description);
        userDetails.setImageProfile(byteImage);
        userDetails.setPlaceOfLiving(placeOfLiving);

        userDetailsRepository.save(userDetails);
    }

}
