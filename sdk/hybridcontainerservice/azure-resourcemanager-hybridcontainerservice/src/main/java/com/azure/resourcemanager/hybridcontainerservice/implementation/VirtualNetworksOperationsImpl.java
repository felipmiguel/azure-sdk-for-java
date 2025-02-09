// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcontainerservice.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.hybridcontainerservice.fluent.VirtualNetworksOperationsClient;
import com.azure.resourcemanager.hybridcontainerservice.fluent.models.VirtualNetworksInner;
import com.azure.resourcemanager.hybridcontainerservice.models.VirtualNetworks;
import com.azure.resourcemanager.hybridcontainerservice.models.VirtualNetworksOperations;

public final class VirtualNetworksOperationsImpl implements VirtualNetworksOperations {
    private static final ClientLogger LOGGER = new ClientLogger(VirtualNetworksOperationsImpl.class);

    private final VirtualNetworksOperationsClient innerClient;

    private final com.azure.resourcemanager.hybridcontainerservice.HybridContainerServiceManager serviceManager;

    public VirtualNetworksOperationsImpl(
        VirtualNetworksOperationsClient innerClient,
        com.azure.resourcemanager.hybridcontainerservice.HybridContainerServiceManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<VirtualNetworks> getByResourceGroupWithResponse(
        String resourceGroupName, String virtualNetworksName, Context context) {
        Response<VirtualNetworksInner> inner =
            this.serviceClient().getByResourceGroupWithResponse(resourceGroupName, virtualNetworksName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new VirtualNetworksImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public VirtualNetworks getByResourceGroup(String resourceGroupName, String virtualNetworksName) {
        VirtualNetworksInner inner = this.serviceClient().getByResourceGroup(resourceGroupName, virtualNetworksName);
        if (inner != null) {
            return new VirtualNetworksImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteByResourceGroupWithResponse(
        String resourceGroupName, String virtualNetworksName, Context context) {
        return this.serviceClient().deleteWithResponse(resourceGroupName, virtualNetworksName, context);
    }

    public void deleteByResourceGroup(String resourceGroupName, String virtualNetworksName) {
        this.serviceClient().delete(resourceGroupName, virtualNetworksName);
    }

    public PagedIterable<VirtualNetworks> listByResourceGroup(String resourceGroupName) {
        PagedIterable<VirtualNetworksInner> inner = this.serviceClient().listByResourceGroup(resourceGroupName);
        return Utils.mapPage(inner, inner1 -> new VirtualNetworksImpl(inner1, this.manager()));
    }

    public PagedIterable<VirtualNetworks> listByResourceGroup(String resourceGroupName, Context context) {
        PagedIterable<VirtualNetworksInner> inner =
            this.serviceClient().listByResourceGroup(resourceGroupName, context);
        return Utils.mapPage(inner, inner1 -> new VirtualNetworksImpl(inner1, this.manager()));
    }

    public PagedIterable<VirtualNetworks> list() {
        PagedIterable<VirtualNetworksInner> inner = this.serviceClient().list();
        return Utils.mapPage(inner, inner1 -> new VirtualNetworksImpl(inner1, this.manager()));
    }

    public PagedIterable<VirtualNetworks> list(Context context) {
        PagedIterable<VirtualNetworksInner> inner = this.serviceClient().list(context);
        return Utils.mapPage(inner, inner1 -> new VirtualNetworksImpl(inner1, this.manager()));
    }

    public VirtualNetworks getById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String virtualNetworksName = Utils.getValueFromIdByName(id, "virtualNetworks");
        if (virtualNetworksName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'virtualNetworks'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, virtualNetworksName, Context.NONE).getValue();
    }

    public Response<VirtualNetworks> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String virtualNetworksName = Utils.getValueFromIdByName(id, "virtualNetworks");
        if (virtualNetworksName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'virtualNetworks'.", id)));
        }
        return this.getByResourceGroupWithResponse(resourceGroupName, virtualNetworksName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String virtualNetworksName = Utils.getValueFromIdByName(id, "virtualNetworks");
        if (virtualNetworksName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'virtualNetworks'.", id)));
        }
        this.deleteByResourceGroupWithResponse(resourceGroupName, virtualNetworksName, Context.NONE);
    }

    public Response<Void> deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String virtualNetworksName = Utils.getValueFromIdByName(id, "virtualNetworks");
        if (virtualNetworksName == null) {
            throw LOGGER
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'virtualNetworks'.", id)));
        }
        return this.deleteByResourceGroupWithResponse(resourceGroupName, virtualNetworksName, context);
    }

    private VirtualNetworksOperationsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.hybridcontainerservice.HybridContainerServiceManager manager() {
        return this.serviceManager;
    }

    public VirtualNetworksImpl define(String name) {
        return new VirtualNetworksImpl(name, this.manager());
    }
}
