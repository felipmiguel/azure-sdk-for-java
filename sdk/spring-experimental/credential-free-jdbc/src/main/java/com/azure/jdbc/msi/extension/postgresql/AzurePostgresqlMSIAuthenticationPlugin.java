package com.azure.jdbc.msi.extension.postgresql;

import static org.postgresql.util.PSQLState.INVALID_PASSWORD;

import java.util.Properties;

import org.postgresql.plugin.AuthenticationPlugin;
import org.postgresql.plugin.AuthenticationRequestType;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.azure.core.credential.AccessToken;
import com.azure.jdbc.msi.extension.MSIAuthenticationPlugin;

/**
 * The Authentication plugin that enables Azure AD managed identity support.
 */
public class AzurePostgresqlMSIAuthenticationPlugin extends MSIAuthenticationPlugin implements AuthenticationPlugin {

    Logger logger = LoggerFactory.getLogger(AzurePostgresqlMSIAuthenticationPlugin.class);
    
    /**
     * Stores the properties.
     */
    private Properties properties;

    /**
     * Constructor.
     */
    public AzurePostgresqlMSIAuthenticationPlugin() {
    }

    /**
     * Constructor with properties.
     *
     * @param properties the properties.
     */
    public AzurePostgresqlMSIAuthenticationPlugin(Properties properties) {
        this.properties = properties;
    }

    /**
     * Get the password.
     *
     * @param art the authentication request type.
     * @return the password.
     * @throws PSQLException when an error occurs.
     */
    @Override
    public char[] getPassword(AuthenticationRequestType art) throws PSQLException {
        char[] password;

        AccessToken accessToken = getAccessToken();

        if (accessToken != null) {
            password = accessToken.getToken().toCharArray();
        } else {
            throw new PSQLException("Unable to acquire access token", INVALID_PASSWORD);
        }

        return password;
    }

    @Override
    protected String getClientId() {
        String clientId = null;
        if (properties != null && properties.containsKey("clientid")) {
            clientId = properties.getProperty("clientid");
        }
        return clientId;
    }
}
