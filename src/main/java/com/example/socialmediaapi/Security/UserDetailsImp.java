package com.example.socialmediaapi.Security;

import com.example.socialmediaapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@AllArgsConstructor
public class UserDetailsImp implements UserDetails {
    private long id;
    private String name;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsImp build(User user) {
        List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(user.getRole().name()));
        return new UserDetailsImp(
                user.getId(), user.getName(), user.getEmail(), user.getPassword(), authorityList);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return name;
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
        return true;
    }
}
