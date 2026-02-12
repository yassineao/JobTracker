package dev.yassine.jobtracker.user.controller;

import dev.yassine.jobtracker.user.dto.AuthRequest;
import dev.yassine.jobtracker.user.dto.AuthResponse;
import dev.yassine.jobtracker.user.dto.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody AuthRequest req) {
        String token = service.register(req.getEmail(), req.getPassword());
        return new AuthResponse(token);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody AuthRequest req) {
        String token = service.login(req.getEmail(), req.getPassword());
        return new AuthResponse(token);
    }
}
