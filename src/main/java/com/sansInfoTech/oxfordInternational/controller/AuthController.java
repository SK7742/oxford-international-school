package com.sansInfoTech.oxfordInternational.controller;

import com.sansInfoTech.oxfordInternational.constants.Role;
import com.sansInfoTech.oxfordInternational.model.LoginRequest;
import com.sansInfoTech.oxfordInternational.responseDTO.AuthResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        log.debug("Received login attempt, for username: {}, password: {}", loginRequest.getUsername(), loginRequest.getPassword());
        AuthResponseDTO response = new AuthResponseDTO();
        if ("test".equals(loginRequest.getUsername()) && "test".equals(loginRequest.getPassword())) {
            log.debug("Login successful for username: {}, Role: {}", loginRequest.getUsername(), Role.ADMIN.toString());
            response.setUsername("Shivam Kumar");
            response.setRole(Role.ADMIN.toString());
            response.setMessage("Login Successful");
            return ResponseEntity
                    .ok()
                    .body(response);
        } else {
            return ResponseEntity
                    .status(401)
                    .body("Invalid credentials");
        }
    }
}
