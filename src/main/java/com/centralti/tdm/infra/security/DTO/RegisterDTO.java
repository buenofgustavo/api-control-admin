package com.centralti.tdm.infra.security.DTO;

import com.centralti.tdm.infra.security.USER.UserRole;

public record RegisterDTO(String login, String password, UserRole role, String name) {
}
