package ru.netology.hw2_AuthorizationService.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    @NotBlank
    @Size(min = 5, max = 20)
    private String login;

    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    private List<Authorities> authorities = List.of(Authorities.READ);

    public User() {
    }

    public User(String login, String password, List<Authorities> authorities) {
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

}

