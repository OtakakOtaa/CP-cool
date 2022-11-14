package org.example.Server;

import org.example.Server.Services.AuthorizationConductor;

public class SessionLoop {

    private final AuthorizationConductor authorizationConductor;

    public SessionLoop(AuthorizationConductor authorizationConductor) {
        this.authorizationConductor = authorizationConductor;
    }

    public void clientListen()
    {
        authorize();

    }

    private void authorize() {
        authorizationConductor.tryAuthorize();
    }

}
