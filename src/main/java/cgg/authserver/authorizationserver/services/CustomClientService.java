package cgg.authserver.authorizationserver.services;

import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

import cgg.authserver.authorizationserver.entities.Client;
import cgg.authserver.authorizationserver.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class CustomClientService  implements RegisteredClientRepository{
    
    
    
    private ClientRepository clientRepository;
    
    @Override
    public void save(RegisteredClient registeredClient) {
       clientRepository.save(Client.from(registeredClient));
    }

    @Override
    public RegisteredClient findById(String id) {
      var client=  clientRepository.findById(Integer.valueOf(id)).orElseThrow();
      return Client.from(client);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var client=  clientRepository.findByClientId(clientId).orElseThrow();
        return Client.from(client);
    }
    
}
