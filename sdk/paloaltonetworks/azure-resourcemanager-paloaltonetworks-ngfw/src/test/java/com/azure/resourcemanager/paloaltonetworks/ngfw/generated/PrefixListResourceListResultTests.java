// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.paloaltonetworks.ngfw.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.paloaltonetworks.ngfw.fluent.models.PrefixListResourceInner;
import com.azure.resourcemanager.paloaltonetworks.ngfw.models.PrefixListResourceListResult;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class PrefixListResourceListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        PrefixListResourceListResult model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"description\":\"eyqxtjjfzql\",\"prefixList\":[],\"etag\":\"ycavodggxdbees\",\"auditComment\":\"eknlra\",\"provisioningState\":\"Accepted\"},\"id\":\"wiuagydwqf\",\"name\":\"ylyrfgiagtco\",\"type\":\"ocqwogfnzjvus\"},{\"properties\":{\"description\":\"ld\",\"prefixList\":[],\"etag\":\"zuxylfsbtkadpyso\",\"auditComment\":\"btgkbugrjqctoj\",\"provisioningState\":\"Creating\"},\"id\":\"of\",\"name\":\"eypefojyqd\",\"type\":\"cuplcplcwkhih\"},{\"properties\":{\"description\":\"lhzdsqtzb\",\"prefixList\":[],\"etag\":\"gnowcjhfgmveca\",\"auditComment\":\"xmwoteyowcluqo\",\"provisioningState\":\"Deleting\"},\"id\":\"vgqouwifzmpj\",\"name\":\"yivqikfxcvhrfsp\",\"type\":\"uagrttikteusqc\"}],\"nextLink\":\"vyklxuby\"}")
                .toObject(PrefixListResourceListResult.class);
        Assertions.assertEquals("eyqxtjjfzql", model.value().get(0).description());
        Assertions.assertEquals("ycavodggxdbees", model.value().get(0).etag());
        Assertions.assertEquals("eknlra", model.value().get(0).auditComment());
        Assertions.assertEquals("vyklxuby", model.nextLink());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        PrefixListResourceListResult model =
            new PrefixListResourceListResult()
                .withValue(
                    Arrays
                        .asList(
                            new PrefixListResourceInner()
                                .withDescription("eyqxtjjfzql")
                                .withPrefixList(Arrays.asList())
                                .withEtag("ycavodggxdbees")
                                .withAuditComment("eknlra"),
                            new PrefixListResourceInner()
                                .withDescription("ld")
                                .withPrefixList(Arrays.asList())
                                .withEtag("zuxylfsbtkadpyso")
                                .withAuditComment("btgkbugrjqctoj"),
                            new PrefixListResourceInner()
                                .withDescription("lhzdsqtzb")
                                .withPrefixList(Arrays.asList())
                                .withEtag("gnowcjhfgmveca")
                                .withAuditComment("xmwoteyowcluqo")))
                .withNextLink("vyklxuby");
        model = BinaryData.fromObject(model).toObject(PrefixListResourceListResult.class);
        Assertions.assertEquals("eyqxtjjfzql", model.value().get(0).description());
        Assertions.assertEquals("ycavodggxdbees", model.value().get(0).etag());
        Assertions.assertEquals("eknlra", model.value().get(0).auditComment());
        Assertions.assertEquals("vyklxuby", model.nextLink());
    }
}
