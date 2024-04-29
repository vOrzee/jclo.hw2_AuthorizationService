package ru.netology.hw2_AuthorizationService.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hw2_AuthorizationService.models.Authorities;
import ru.netology.hw2_AuthorizationService.models.User;
import ru.netology.hw2_AuthorizationService.services.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user.getLogin(), user.getPassword());
    }
}
