package org.example.Server.PersistentProvider;

import org.example.Server.Entities.User;

public abstract class PersistentProvider {
    public abstract User getUser(String login, String password);
}
