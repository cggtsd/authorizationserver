package cgg.authserver.authorizationserver.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cgg.authserver.authorizationserver.entities.User;
import cgg.authserver.authorizationserver.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserService {
    
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public User createUser(User user){
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
    }

}
