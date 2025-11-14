package com.maven.album.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final MagicAuthService magicAuthService;

    public AuthController(MagicAuthService magicAuthService) {
        this.magicAuthService = magicAuthService;
    }

    @PostMapping("/magic-login")
    public ResponseEntity<?> loginWithMagic(
            @RequestHeader(value = "Authorization", required = false) String authorizationHeader
    ) {
        try {
            String didToken = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                didToken = authorizationHeader.substring(7).trim();
            }

            LoginResponse response = magicAuthService.authenticateWithDidToken(didToken);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Magic login failed");
        }
    }
}
