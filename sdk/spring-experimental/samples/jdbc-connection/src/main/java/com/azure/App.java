package com.azure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {


    public static void main(String[] args) {
        String result = "not executed";
        
        String jdbcUrl= "REMOVE THIS LINE";
        // TODO: UNCOMMENT ONE OF THE FOLLOWING LINES AND REPLACE THE [VALUES] BY THE CORRESPONDING PARAMETERS OF YOUR DATABASE
        
        // MySQL jdbc url sample
        //String jdbcUrl = "jdbc:mysql://[MYSQL HOST].mysql.database.azure.com:3306/[DB NAME]?sslMode=REQUIRED&useSSL=true&defaultAuthenticationPlugin=com.azure.jdbc.msi.extension.mysql.AzureMySqlMSIAuthenticationPlugin&authenticationPlugins=com.azure.jdbc.msi.extension.mysql.AzureMySqlMSIAuthenticationPlugin&user=[YOUR USER]@[YOUR AAD DOMAIN]@[MYSQL HOST]";
        // Postgresql jdbc url sample
        //String jdbcUrl = "jdbc:postgresql://[POSTGRESQL HOST]:5432/$[DB NAME]]?sslmode=require&authenticationPluginClassName=com.azure.jdbc.msi.extension.postgresql.AzurePostgresqlMSIAuthenticationPlugin&user=[YOUR USER]@[YOUR AAD DOMAIN]@[POSTGRESQL HOST]";

        Connection connection;
        try {
            connection = DriverManager.getConnection(jdbcUrl);
            if (connection != null) {
                ResultSet queryResult = connection.prepareStatement("SELECT now() as now").executeQuery();
                if (queryResult.next()) {
                    result = queryResult.getString("now");
                }
                connection.close();
            } else {
                result = "Failed to connect.";
            }
        } catch (SQLException se) {
            result = "JDBC Url=" + jdbcUrl + "\n" + se.getMessage();
            se.printStackTrace();
        } catch (Exception e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
