// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Target Azure File Share Info. */
@Fluent
public final class TargetAfsRestoreInfo {
    /*
     * File share name
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Target file share resource ARM ID
     */
    @JsonProperty(value = "targetResourceId")
    private String targetResourceId;

    /** Creates an instance of TargetAfsRestoreInfo class. */
    public TargetAfsRestoreInfo() {
    }

    /**
     * Get the name property: File share name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: File share name.
     *
     * @param name the name value to set.
     * @return the TargetAfsRestoreInfo object itself.
     */
    public TargetAfsRestoreInfo withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the targetResourceId property: Target file share resource ARM ID.
     *
     * @return the targetResourceId value.
     */
    public String targetResourceId() {
        return this.targetResourceId;
    }

    /**
     * Set the targetResourceId property: Target file share resource ARM ID.
     *
     * @param targetResourceId the targetResourceId value to set.
     * @return the TargetAfsRestoreInfo object itself.
     */
    public TargetAfsRestoreInfo withTargetResourceId(String targetResourceId) {
        this.targetResourceId = targetResourceId;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
