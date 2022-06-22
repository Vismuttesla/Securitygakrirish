package com.example.demo.dto;

import com.example.demo.entity.User1;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private User1 user1;
  public CustomUserDetails(User1 user1)
  {
        this.user1 = user1;


  }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user1.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user1.getPassword();
    }

    @Override
    public String getUsername() {
        return user1.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;

    }

    @Override
    public boolean isEnabled() {
        return user1.isConfirmed();
    }
}
