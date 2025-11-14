package com.maven.album.auth;

import org.springframework.stereotype.Service;

@Service
public class MagicAuthService {

    private final JwtService jwtService;

    public MagicAuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    /**
     * STUB implementation.
     * Right now it just logs the DID token and fakes an email.
     */
    public LoginResponse authenticateWithDidToken(String didToken) {
        if (didToken == null || didToken.isBlank()) {
            throw new IllegalArgumentException("Missing DID token");
        }

        // TEMP: log the token so you can see it's arriving
        System.out.println("Received DID token from client: " +
                didToken.substring(0, Math.min(40, didToken.length())) + "...");

        // TEMP: fake email until we plug in real Magic validation
        String email = "dev@example.com";

        String accessToken = jwtService.generateToken(email);
        return new LoginResponse(accessToken, email);
    }
}
