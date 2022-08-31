package com.azure.jdbc.msi.extension;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.core.credential.AccessToken;

public class TokenManager {

    Logger logger = LoggerFactory.getLogger(TokenManager.class);

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
        logger.warn("Getting access token for clientId: %s", clientId);
        String key = getKey(clientId);
        if (accessTokenCache.containsKey(key)) {
            return accessTokenCache.get(key).getAccessToken(clientId);
        } else {
            SyncTokenManager tokenManager;
            try {
                lock.lock();
                // check again after acquiring the lock as the previous thread may have already
                // added the token
                if (accessTokenCache.containsKey(key)) {
                    tokenManager = accessTokenCache.get(key);
                } else {
                    logger.debug("creating token manager for %s", key);
                    tokenManager = new SyncTokenManager();
                    accessTokenCache.put(key, tokenManager);
                    // exit from lock as soon as possible. get the access token after unlocking the
                    // lock
                }
            } finally {
                lock.unlock();
            }
            if (tokenManager != null) {
                return tokenManager.getAccessToken(clientId);
            } else {
                throw new IllegalStateException("TokenManager is null");
            }
        }
    }

    private String getKey(String clientId) {
        if (clientId == null || clientId.isEmpty()) {
            return "system";
        } else {
            return clientId;
        }
    }

    public void resetAccessToken(String clientId) {
        String key = getKey(clientId);
        try {
            lock.lock();
            if (accessTokenCache.containsKey(key)) {
                accessTokenCache.remove(key);
            }
        } finally {
            lock.unlock();
        }
    }
}
