package org.example.Server.Services;

import org.example.Server.PersistentProvider.PersistentProvider;

public class AuthorizationConductor {

    private final PersistentProvider persistentProvider;

    public AuthorizationConductor(PersistentProvider persistentProvider) {
        this.persistentProvider = persistentProvider;
    }

    public boolean tryAuthorize(String login, String password) {
        persistentProvider.getUser(login, password);
    }

    public boolean tryRegisterNewUser(){

    }


}
