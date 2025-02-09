// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** The IncidentProperty model. */
@Fluent
public final class IncidentProperty {
    /*
     * max severity of latest anomalies in the incident
     */
    @JsonProperty(value = "maxSeverity", required = true)
    private Severity maxSeverity;

    /*
     * incident status
     *
     * only return for alerting incident result
     */
    @JsonProperty(value = "incidentStatus", access = JsonProperty.Access.WRITE_ONLY)
    private IncidentStatus incidentStatus;

    /*
     * value of the root node
     */
    @JsonProperty(value = "valueOfRootNode", access = JsonProperty.Access.WRITE_ONLY)
    private Double valueOfRootNode;

    /*
     * expected value of the root node given by smart detector
     */
    @JsonProperty(value = "expectedValueOfRootNode", access = JsonProperty.Access.WRITE_ONLY)
    private Double expectedValueOfRootNode;

    /** Creates an instance of IncidentProperty class. */
    public IncidentProperty() {}

    /**
     * Get the maxSeverity property: max severity of latest anomalies in the incident.
     *
     * @return the maxSeverity value.
     */
    public Severity getMaxSeverity() {
        return this.maxSeverity;
    }

    /**
     * Set the maxSeverity property: max severity of latest anomalies in the incident.
     *
     * @param maxSeverity the maxSeverity value to set.
     * @return the IncidentProperty object itself.
     */
    public IncidentProperty setMaxSeverity(Severity maxSeverity) {
        this.maxSeverity = maxSeverity;
        return this;
    }

    /**
     * Get the incidentStatus property: incident status
     *
     * <p>only return for alerting incident result.
     *
     * @return the incidentStatus value.
     */
    public IncidentStatus getIncidentStatus() {
        return this.incidentStatus;
    }

    /**
     * Get the valueOfRootNode property: value of the root node.
     *
     * @return the valueOfRootNode value.
     */
    public Double getValueOfRootNode() {
        return this.valueOfRootNode;
    }

    /**
     * Get the expectedValueOfRootNode property: expected value of the root node given by smart detector.
     *
     * @return the expectedValueOfRootNode value.
     */
    public Double getExpectedValueOfRootNode() {
        return this.expectedValueOfRootNode;
    }
}
