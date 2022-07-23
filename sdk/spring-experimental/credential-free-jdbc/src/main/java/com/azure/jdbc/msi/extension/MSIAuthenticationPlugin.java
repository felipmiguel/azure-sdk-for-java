package com.azure.jdbc.msi.extension;

import com.azure.core.credential.AccessToken;

public abstract class MSIAuthenticationPlugin {
    

    protected abstract String getClientId();

    protected AccessToken getAccessToken(){
        return TokenManager.getInstance().getAccessToken(getClientId());
    }
}
