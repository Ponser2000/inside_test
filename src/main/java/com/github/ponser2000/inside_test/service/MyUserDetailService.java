package com.github.ponser2000.inside_test.service;


import com.github.ponser2000.inside_test.model.MyUser;
import com.github.ponser2000.inside_test.repository.datajpa.CrudUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private CrudUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        MyUser myUser = userRepository.findByName(name);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + name);
        }

        UserDetails userDetails = User.builder()
                .username(myUser.getName())
                .password(myUser.getPassword())
                .roles(myUser.getRole())
                .build();

        return userDetails;
    }
}
