package com.example.demo.service.Impl;

import com.example.demo.dto.CustomUserDetails;
import com.example.demo.entity.User1;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User1> optionalUser=userRepository.findByEmail(username);
          return optionalUser.map(CustomUserDetails::new).orElse(null);
    // yuqoirdagi oxirgi qatorni asl ko'rinishi shunaqa bo'ladi.
        // if(optionalUser.isPresent())
    //  {  return new CustomUserDetails(optionalUser.get());
        //            }
    //
    //   else{return null;}

    }
}
