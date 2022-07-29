package com.azure.samples;

import java.util.Set;

import javax.annotation.sql.DataSourceDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.azure.jdbc.msi.extension.mysql.AzureMySqlMSIAuthenticationPlugin;

// @DataSourceDefinition(name = "java:app/CredentialFreeDataSource", className = "com.mysql.cj.jdbc.Driver", url = "jdbc:mysql://mysql-checklist-credential-free.mysql.database.azure.com:3306/checklist?useSSL=true&requireSSL=true&defaultAuthenticationPlugin=com.azure.jdbc.msi.extension.mysql.AzureMySqlMSIAuthenticationPlugin&authenticationPlugins=com.azure.jdbc.msi.extension.mysql.AzureMySqlMSIAuthenticationPlugin&clientid=6f75da39-8c15-45a2-ba60-5bc2907c4048", user = "checklistapp@microsoft.com@mysql-checklist-credential-free")
@ApplicationPath("/")
public class JAXRSConfiguration extends Application {

    // private void poc() {
    //     AzureMySqlMSIAuthenticationPlugin plugin = new AzureMySqlMSIAuthenticationPlugin();
    //     String name = plugin.getProtocolPluginName();
    // }

    // @Override
    // public Set<Object> getSingletons() {
    //     Set<Object> singletons = super.getSingletons();
    //     singletons.add(new AzureMySqlMSIAuthenticationPlugin());
    //     return singletons;
    // }

}
