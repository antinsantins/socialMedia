package com.example.socialmediaapi.Security;

import com.example.socialmediaapi.entity.User;
import com.example.socialmediaapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {
    UserRepository userRepository;
    @Override
    public UserDetailsImp loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with nickname - '" + username + "' not found"));
        return UserDetailsImp.build(user);
    }
}
