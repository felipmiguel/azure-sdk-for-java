// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Network configuration diagnostic result corresponded to provided traffic query. */
@Fluent
public final class NetworkConfigurationDiagnosticResult {
    /*
     * Network configuration diagnostic profile.
     */
    @JsonProperty(value = "profile")
    private NetworkConfigurationDiagnosticProfile profile;

    /*
     * Network security group result.
     */
    @JsonProperty(value = "networkSecurityGroupResult")
    private NetworkSecurityGroupResult networkSecurityGroupResult;

    /** Creates an instance of NetworkConfigurationDiagnosticResult class. */
    public NetworkConfigurationDiagnosticResult() {
    }

    /**
     * Get the profile property: Network configuration diagnostic profile.
     *
     * @return the profile value.
     */
    public NetworkConfigurationDiagnosticProfile profile() {
        return this.profile;
    }

    /**
     * Set the profile property: Network configuration diagnostic profile.
     *
     * @param profile the profile value to set.
     * @return the NetworkConfigurationDiagnosticResult object itself.
     */
    public NetworkConfigurationDiagnosticResult withProfile(NetworkConfigurationDiagnosticProfile profile) {
        this.profile = profile;
        return this;
    }

    /**
     * Get the networkSecurityGroupResult property: Network security group result.
     *
     * @return the networkSecurityGroupResult value.
     */
    public NetworkSecurityGroupResult networkSecurityGroupResult() {
        return this.networkSecurityGroupResult;
    }

    /**
     * Set the networkSecurityGroupResult property: Network security group result.
     *
     * @param networkSecurityGroupResult the networkSecurityGroupResult value to set.
     * @return the NetworkConfigurationDiagnosticResult object itself.
     */
    public NetworkConfigurationDiagnosticResult withNetworkSecurityGroupResult(
        NetworkSecurityGroupResult networkSecurityGroupResult) {
        this.networkSecurityGroupResult = networkSecurityGroupResult;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (profile() != null) {
            profile().validate();
        }
        if (networkSecurityGroupResult() != null) {
            networkSecurityGroupResult().validate();
        }
    }
}
