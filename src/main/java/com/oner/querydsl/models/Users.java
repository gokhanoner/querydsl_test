package com.oner.querydsl.models;

import javax.annotation.Generated;

/**
 * Users is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class Users {

    private Boolean enabled;

    private String password;

    private String username;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

