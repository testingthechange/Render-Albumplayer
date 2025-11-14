package com.maven.album.auth;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JwtService {

    /**
     * For now this just returns a random opaque token.
     * Replace with real JWT generation later if you want.
     */
    public String generateToken(String subject) {
        return UUID.randomUUID().toString();
    }
}
