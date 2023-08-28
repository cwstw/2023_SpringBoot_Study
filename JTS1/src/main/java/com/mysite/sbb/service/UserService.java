package com.mysite.sbb.service;

import com.mysite.sbb.entity.SiteUser;
import com.mysite.sbb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;


    public SiteUser create(String username, String email, String password){
        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //user.setPassword(passwordEncoder.encoder(password));
        user.setPassword(password);
        this.userRepository.save(user);
        return user;
    }
}
