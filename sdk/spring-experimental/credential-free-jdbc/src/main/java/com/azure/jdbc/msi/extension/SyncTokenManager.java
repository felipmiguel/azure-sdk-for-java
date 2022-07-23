package com.azure.jdbc.msi.extension;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class SyncTokenManager {

    private ReentrantLock lock = new ReentrantLock();
    AccessToken accessToken;

    protected synchronized AccessToken getAccessToken(String clientId) {
        try {
            lock.lock();
            if (accessToken == null || accessToken.isExpired()) {
                TokenCredential credential = getTokenCredential(clientId);
                TokenRequestContext request = new TokenRequestContext();
                ArrayList<String> scopes = new ArrayList<>();
                scopes.add("https://ossrdbms-aad.database.windows.net");
                request.setScopes(scopes);
                accessToken = credential.getToken(request).block(Duration.ofSeconds(30));
            }
        } finally {
            lock.unlock();
        }

        return accessToken;
    }

    

    private TokenCredential credential;

    private TokenCredential getTokenCredential(String clientId) {
        if (credential == null) {
            if (clientId != null && !clientId.isEmpty()) {
                credential = new DefaultAzureCredentialBuilder().managedIdentityClientId(clientId).build();
            } else {
                credential = new DefaultAzureCredentialBuilder().build();
            }
        }
        return credential;
    }
}
