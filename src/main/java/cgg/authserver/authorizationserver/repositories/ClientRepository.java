package cgg.authserver.authorizationserver.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.authserver.authorizationserver.entities.Client;

public interface ClientRepository  extends JpaRepository<Client,Integer>{
    
    Optional<Client> findByClientId(String clinetId);
}
