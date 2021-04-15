package nl.novi.springboot.first_demo.service;


import nl.novi.springboot.first_demo.payload.request.AuthenticationRequest;
import nl.novi.springboot.first_demo.payload.response.AuthenticationResponse;

public interface UserAuthenticateService {

    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest);

}
