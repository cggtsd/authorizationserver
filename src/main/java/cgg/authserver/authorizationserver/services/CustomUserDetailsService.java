package cgg.authserver.authorizationserver.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cgg.authserver.authorizationserver.models.SecurityUser;
import cgg.authserver.authorizationserver.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService  implements UserDetailsService{
    
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var user=userRepository.findByUsername(username);
        return user.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("No user exists !!"));
    }
    
}
