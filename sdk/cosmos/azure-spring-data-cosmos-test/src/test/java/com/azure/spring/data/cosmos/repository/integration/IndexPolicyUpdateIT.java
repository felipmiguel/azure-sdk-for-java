// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.data.cosmos.repository.integration;

import com.azure.cosmos.implementation.ImplementationBridgeHelpers;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.ExcludedPath;
import com.azure.cosmos.models.IncludedPath;
import com.azure.cosmos.models.IndexingMode;
import com.azure.cosmos.models.IndexingPolicy;
import com.azure.spring.data.cosmos.IntegrationTestCollectionManager;
import com.azure.spring.data.cosmos.core.CosmosTemplate;
import com.azure.spring.data.cosmos.domain.Address;
import com.azure.spring.data.cosmos.domain.ComplexIndexPolicyEntity;
import com.azure.spring.data.cosmos.domain.IndexPolicyOverwriteEntity;
import com.azure.spring.data.cosmos.domain.IndexPolicyEntity;
import com.azure.spring.data.cosmos.repository.TestRepositoryConfig;
import com.azure.spring.data.cosmos.repository.support.CosmosEntityInformation;
import com.azure.spring.data.cosmos.repository.support.SimpleCosmosRepository;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestRepositoryConfig.class)
public class IndexPolicyUpdateIT {

    @ClassRule
    public static final IntegrationTestCollectionManager collectionManager = new IntegrationTestCollectionManager();

    @Autowired
    CosmosTemplate template;

    @Autowired
    ApplicationContext context;

    CosmosEntityInformation<IndexPolicyEntity, String> defaultIndexPolicyEntityInformation = new CosmosEntityInformation<>(IndexPolicyEntity.class);

    CosmosEntityInformation<ComplexIndexPolicyEntity, String> complexIndexPolicyEntityInformation = new CosmosEntityInformation<>(ComplexIndexPolicyEntity.class);

    CosmosEntityInformation<IndexPolicyOverwriteEntity, String> indexPolicyOverwriteEntityInformation = new CosmosEntityInformation<>(IndexPolicyOverwriteEntity.class);

    CosmosEntityInformation<Address, String> addressEntityInformation = new CosmosEntityInformation<>(Address.class);

    @Before
    public void setup() {
        collectionManager.ensureContainersCreatedAndEmpty(template, IndexPolicyEntity.class, ComplexIndexPolicyEntity.class, IndexPolicyOverwriteEntity.class, Address.class);
    }

    @Test
    public void testIndexPolicyDoesntUpdateOnRepoInitialization() {
        // set index policy from entity annotation
        collectionManager.deleteContainer(defaultIndexPolicyEntityInformation);
        new SimpleCosmosRepository<>(defaultIndexPolicyEntityInformation, template);

        // get original index policy
        CosmosContainerProperties properties = template.getContainerProperties(defaultIndexPolicyEntityInformation.getContainerName());

        // assert
        assertThat(properties.getIndexingPolicy().getIncludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getIncludedPaths().get(0).getPath()).isEqualTo("/*");
        assertThat(properties.getIndexingPolicy().getExcludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getExcludedPaths().get(0).getPath()).isEqualTo("/\"_etag\"/?");
        assertThat(properties.getIndexingPolicy().isAutomatic()).isEqualTo(true);
        assertThat(properties.getIndexingPolicy().getIndexingMode()).isEqualTo(IndexingMode.CONSISTENT);

        // set new index policy
        IndexingPolicy newIndexPolicy = new IndexingPolicy();
        newIndexPolicy.setIncludedPaths(Collections.singletonList(new IncludedPath("/field/?")));
        newIndexPolicy.setExcludedPaths(Collections.singletonList(new ExcludedPath("/*")));

        // apply new index policy
        CosmosEntityInformation<IndexPolicyEntity, String> spyEntityInformation = Mockito.spy(defaultIndexPolicyEntityInformation);
        Mockito.doReturn(newIndexPolicy).when(spyEntityInformation).getIndexingPolicy();
        Mockito.doReturn(false).when(spyEntityInformation).isOverwriteIndexingPolicy();
        new SimpleCosmosRepository<>(spyEntityInformation, template);

        // retrieve updated index policy
        properties = template.getContainerProperties(defaultIndexPolicyEntityInformation.getContainerName());

        // assert
        assertThat(properties.getIndexingPolicy().getIncludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getIncludedPaths().get(0).getPath()).isEqualTo("/*");
        assertThat(properties.getIndexingPolicy().getExcludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getExcludedPaths().get(0).getPath()).isEqualTo("/\"_etag\"/?");
        assertThat(properties.getIndexingPolicy().isAutomatic()).isEqualTo(true);
        assertThat(properties.getIndexingPolicy().getIndexingMode()).isEqualTo(IndexingMode.CONSISTENT);
    }

    @Test
    public void testIndexPolicyUpdatesOnRepoInitialization() {
        // set index policy from entity annotation
        collectionManager.deleteContainer(indexPolicyOverwriteEntityInformation);
        new SimpleCosmosRepository<>(indexPolicyOverwriteEntityInformation, template);

        // get original index policy
        CosmosContainerProperties properties = template.getContainerProperties(indexPolicyOverwriteEntityInformation.getContainerName());

        // assert
        assertThat(properties.getIndexingPolicy().getIncludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getIncludedPaths().get(0).getPath()).isEqualTo("/\"_etag\"/?");
        assertThat(properties.getIndexingPolicy().getExcludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getExcludedPaths().get(0).getPath()).isEqualTo("/*");

        // set new index policy
        IndexingPolicy newIndexPolicy = new IndexingPolicy();
        newIndexPolicy.setIncludedPaths(Collections.singletonList(new IncludedPath("/*")));
        newIndexPolicy.setExcludedPaths(Collections.singletonList(new ExcludedPath("/\"_etag\"/?")));

        // apply new index policy
        CosmosEntityInformation<IndexPolicyOverwriteEntity, String> spyEntityInformation = Mockito.spy(indexPolicyOverwriteEntityInformation);
        Mockito.doReturn(newIndexPolicy).when(spyEntityInformation).getIndexingPolicy();
        Mockito.doReturn(true).when(spyEntityInformation).isOverwriteIndexingPolicy();
        new SimpleCosmosRepository<>(spyEntityInformation, template);

        // retrieve updated index policy
        properties = template.getContainerProperties(indexPolicyOverwriteEntityInformation.getContainerName());

        // assert
        assertThat(properties.getIndexingPolicy().getIncludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getIncludedPaths().get(0).getPath()).isEqualTo("/*");
        assertThat(properties.getIndexingPolicy().getExcludedPaths().size()).isEqualTo(1);
        assertThat(properties.getIndexingPolicy().getExcludedPaths().get(0).getPath()).isEqualTo("/\"_etag\"/?");
    }

    @Test
    public void testContainerReplaceShouldNotOccurIfDefaultIndexIsUnchanged() {
        new SimpleCosmosRepository<>(defaultIndexPolicyEntityInformation, template);
        CosmosTemplate spyTemplate = Mockito.spy(template);
        new SimpleCosmosRepository<>(defaultIndexPolicyEntityInformation, spyTemplate);
        Mockito.verify(spyTemplate, Mockito.never()).replaceContainerProperties(Mockito.any(), Mockito.any());
    }

    @Test
    public void testContainerReplaceShouldNotOccurIfComplexIndexIsUnchanged() {
        new SimpleCosmosRepository<>(complexIndexPolicyEntityInformation, template);
        CosmosTemplate spyTemplate = Mockito.spy(template);
        new SimpleCosmosRepository<>(complexIndexPolicyEntityInformation, spyTemplate);
        Mockito.verify(spyTemplate, Mockito.never()).replaceContainerProperties(Mockito.any(), Mockito.any());
    }

    @Test
    public void testContainerReplaceShouldNotOccurIfIndexingPolicyIsNotSpecified() {
        new SimpleCosmosRepository<>(addressEntityInformation, template);
        CosmosTemplate spyTemplate = Mockito.spy(template);
        new SimpleCosmosRepository<>(addressEntityInformation, spyTemplate);
        Mockito.verify(spyTemplate, Mockito.never()).replaceContainerProperties(Mockito.any(), Mockito.any());
    }
}
