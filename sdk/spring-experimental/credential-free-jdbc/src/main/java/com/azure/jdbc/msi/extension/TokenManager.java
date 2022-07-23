package com.azure.jdbc.msi.extension;

import com.azure.core.credential.AccessToken;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class TokenManager {

    private TokenManager() {

    }

    private static TokenManager instance = new TokenManager();

    public static TokenManager getInstance() {
        return instance;
    }

    /**
     * Stores the access tokens.
     * There is one token per managed identity. System managed identity id is
     * "system".
     */
    private Map<String, SyncTokenManager> accessTokenCache = new HashMap<String, SyncTokenManager>();

    ReentrantLock lock = new ReentrantLock();

    protected AccessToken getAccessToken(String clientId) {
        String key = getKey(clientId);
        if (accessTokenCache.containsKey(key)) {
            return accessTokenCache.get(key).getAccessToken(clientId);
        } else {
            try {
                lock.lock();
                // check again after acquiring the lock as the previous thread may have already added the token
                if (accessTokenCache.containsKey(key)) {
                    return accessTokenCache.get(key).getAccessToken(clientId);
                } else {
                    SyncTokenManager tokenManager = new SyncTokenManager();
                    accessTokenCache.put(key, tokenManager);
                    // exit from lock as soon as possible. get the access token after unlocking the lock
                }
            } finally {
                lock.unlock();
            }
            return accessTokenCache.get(key).getAccessToken(clientId);
        }
    }

    private String getKey(String clientId) {
        if (clientId == null || clientId.isEmpty()) {
            return "system";
        } else {
            return clientId;
        }
    }
}
