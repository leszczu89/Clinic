package com.clinic.domain.dto;

import com.clinic.domain.Role;

public class UserRequestDto {

    private Enum<Role> role;
    private String login;
    private String password;

    public UserRequestDto(Enum<Role> role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public UserRequestDto() {
    }

    public Enum<Role> getRole() {
        return role;
    }

    public void setRole(Enum<Role> role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
