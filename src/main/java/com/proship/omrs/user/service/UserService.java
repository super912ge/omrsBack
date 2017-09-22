package com.proship.omrs.user.service;


import com.proship.omrs.user.entity.User;
import com.proship.omrs.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword_hash(user.getPassword());
        user.setPassword_salt(user.getPassword().substring(0,40));
        user.setUuid(UUID.randomUUID().getLeastSignificantBits());
        user.setRequisition_mail_recipient(true);
        user.setActive(true);
        user.setIncentive_bracket_setting_id((long)2);

        return userRepository.save(user);
    }

}
