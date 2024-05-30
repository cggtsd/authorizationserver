package cgg.authserver.authorizationserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.authserver.authorizationserver.entities.User;

public interface UserRepository  extends JpaRepository<User,Integer>{
    
    Optional<User> findByUsername(String username);
}
