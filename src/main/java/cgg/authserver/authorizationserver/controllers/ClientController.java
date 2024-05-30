package cgg.authserver.authorizationserver.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cgg.authserver.authorizationserver.entities.Client;
import cgg.authserver.authorizationserver.services.ClientService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClientController {
    
    private ClientService clientService;


    @PostMapping("/client")
    public Client createClient(@RequestBody Client client){
        
        return clientService.createClient(client);
    }
}
