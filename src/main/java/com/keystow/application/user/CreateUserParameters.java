package com.keystow.application.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class CreateUserParameters {

    private final UserName userName;
    private final Email email;
    private final String password;
    private final Boolean enabled;
    private final LocalDateTime createdAt;
}
