// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcontainers.models.AllowedPrincipals;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class AllowedPrincipalsTests {
    @Test
    public void testDeserialize() {
        AllowedPrincipals model =
            BinaryData
                .fromString("{\"groups\":[\"urzafb\",\"jjgpb\",\"oq\"],\"identities\":[\"klj\",\"vbqid\"]}")
                .toObject(AllowedPrincipals.class);
        Assertions.assertEquals("urzafb", model.groups().get(0));
        Assertions.assertEquals("klj", model.identities().get(0));
    }

    @Test
    public void testSerialize() {
        AllowedPrincipals model =
            new AllowedPrincipals()
                .withGroups(Arrays.asList("urzafb", "jjgpb", "oq"))
                .withIdentities(Arrays.asList("klj", "vbqid"));
        model = BinaryData.fromObject(model).toObject(AllowedPrincipals.class);
        Assertions.assertEquals("urzafb", model.groups().get(0));
        Assertions.assertEquals("klj", model.identities().get(0));
    }
}
