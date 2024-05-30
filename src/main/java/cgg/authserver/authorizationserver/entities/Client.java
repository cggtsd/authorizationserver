package cgg.authserver.authorizationserver.entities;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clientId;
    private String secret;
    private String scope;
    private String redirectUri;
    private String authMethod;
    private String grantType;

    public static Client from(RegisteredClient registeredClient){
        Client client = new Client();
        client.setClientId(registeredClient.getClientId());
        client.setSecret(registeredClient.getClientSecret());
        client.setAuthMethod(registeredClient.getClientAuthenticationMethods().stream().findAny().get().getValue());
        client.setGrantType(registeredClient.getAuthorizationGrantTypes().stream().findAny().get().getValue());
        client.setRedirectUri(registeredClient.getRedirectUris().stream().findAny().get());
        client.setScope(registeredClient.getScopes().stream().findAny().get());

        return client;
    }

    public static RegisteredClient from(Client client){
        return RegisteredClient.withId(String.valueOf(client.getId()))
         .clientId(client.getClientId())
         .clientSecret(client.getSecret())
         .scope(client.getScope())
         .redirectUri(client.getRedirectUri())
         .clientAuthenticationMethod(new ClientAuthenticationMethod(client.getAuthMethod()))
         .authorizationGrantType(new AuthorizationGrantType(client.getGrantType()))
         .build();
    }

}
