package ru.netology.hw2_AuthorizationService.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.hw2_AuthorizationService.models.Authorities;
import ru.netology.hw2_AuthorizationService.models.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map<String, User> users = new ConcurrentHashMap<>(
            Map.of(
                    "admin", new User("admin", "qwerty", List.of(Authorities.DELETE, Authorities.WRITE, Authorities.READ)),
                    "Ivan", new User("Ivan", "asdfgh", List.of(Authorities.WRITE, Authorities.READ)),
                    "Shyngis", new User("Shyngis", "zxcvbn", List.of(Authorities.READ))
            )
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        var userObj = users.get(user);
        if (userObj == null || !userObj.getPassword().equals(password)){
            return List.of();
        } else {
            return userObj.getAuthorities();
        }
    }
}

