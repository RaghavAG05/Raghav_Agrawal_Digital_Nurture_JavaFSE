package com.cognizant.jwt.controller;

import com.cognizant.jwt.model.AuthenticationResponse;
import com.cognizant.jwt.service.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    private final JwtService jwtService;

    public AuthenticationController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(
            @RequestHeader(
                    value = HttpHeaders.AUTHORIZATION,
                    required = false
            ) String authorizationHeader) {

        LOGGER.debug("START");

        if (authorizationHeader == null ||
                !authorizationHeader.startsWith("Basic ")) {

            LOGGER.warn("Authorization header is missing or invalid");

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "error",
                            "Authorization header is missing"
                    ));
        }

        try {

            String encodedCredentials =
                    authorizationHeader.substring(6);

            byte[] decodedBytes =
                    Base64.getDecoder().decode(encodedCredentials);

            String decodedCredentials =
                    new String(decodedBytes, StandardCharsets.UTF_8);

            String[] credentials =
                    decodedCredentials.split(":", 2);

            if (credentials.length != 2) {

                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of(
                                "error",
                                "Invalid credentials format"
                        ));
            }

            String username = credentials[0].trim();
            String password = credentials[1].trim();

            LOGGER.debug("Username received: {}", username);

            if (!"user".equals(username) ||
                    !"pwd".equals(password)) {

                LOGGER.warn("Invalid username or password");

                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of(
                                "error",
                                "Invalid username or password"
                        ));
            }

            String token = jwtService.generateToken(username);

            LOGGER.debug("JWT token generated successfully");
            LOGGER.debug("END");

            return ResponseEntity.ok(
                    new AuthenticationResponse(token)
            );

        } catch (Exception exception) {

            LOGGER.error(
                    "Unable to process Authorization header",
                    exception
            );

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of(
                            "error",
                            "Invalid Authorization header"
                    ));
        }
    }
}