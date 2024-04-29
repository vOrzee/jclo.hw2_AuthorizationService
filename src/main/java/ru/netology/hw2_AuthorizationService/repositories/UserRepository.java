package ru.netology.hw2_AuthorizationService.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.hw2_AuthorizationService.models.Authorities;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return List.of();
    }
}

