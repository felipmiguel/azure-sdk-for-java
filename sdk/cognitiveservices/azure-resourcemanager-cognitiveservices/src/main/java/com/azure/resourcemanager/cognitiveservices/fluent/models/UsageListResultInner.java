// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.cognitiveservices.models.Usage;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The response to a list usage request. */
@Fluent
public final class UsageListResultInner {
    /*
     * The list of usages for Cognitive Service account.
     */
    @JsonProperty(value = "value")
    private List<Usage> value;

    /** Creates an instance of UsageListResultInner class. */
    public UsageListResultInner() {
    }

    /**
     * Get the value property: The list of usages for Cognitive Service account.
     *
     * @return the value value.
     */
    public List<Usage> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of usages for Cognitive Service account.
     *
     * @param value the value value to set.
     * @return the UsageListResultInner object itself.
     */
    public UsageListResultInner withValue(List<Usage> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
