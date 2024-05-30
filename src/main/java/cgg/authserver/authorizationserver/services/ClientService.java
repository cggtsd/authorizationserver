package cgg.authserver.authorizationserver.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cgg.authserver.authorizationserver.entities.Client;
import cgg.authserver.authorizationserver.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientService {
    
    private ClientRepository clientRepository;

    private PasswordEncoder passwordEncoder;


    public Client createClient(Client client){
       
        client.setSecret(passwordEncoder.encode(client.getSecret()));
        return clientRepository.save(client);

    }
}
