package ru.netology.hw2_AuthorizationService.services;

import org.springframework.stereotype.Service;
import ru.netology.hw2_AuthorizationService.exceptions.InvalidCredentials;
import ru.netology.hw2_AuthorizationService.exceptions.UnauthorizedUser;
import ru.netology.hw2_AuthorizationService.models.Authorities;
import ru.netology.hw2_AuthorizationService.repositories.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
