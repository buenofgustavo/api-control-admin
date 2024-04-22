package com.centralti.tdm.infra.security.USER;

public record RegistersDTO (

            String id,

            String name,

            String login,

            String password,

            UserRole role

    ) {

    public RegistersDTO(User user) {
        this(
                user.getId(), user.getName(), user.getLogin(), user.getPassword(), user.getRole()
        );
    }
}

