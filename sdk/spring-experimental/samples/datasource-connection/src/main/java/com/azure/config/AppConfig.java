package com.azure.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.azure.controller.CheckListResource;
import com.azure.repository.CheckItemRepository;
import com.azure.repository.CheckListRepository;
import com.azure.service.CheckListService;
import com.azure.service.impl.CheckListServiceImpl;


public class AppConfig extends ResourceConfig {

	public AppConfig() {
		register(CheckListResource.class);
		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(CheckListServiceImpl.class).to(CheckListService.class);
				bind(CheckListRepository.class).to(CheckListRepository.class);
                bind(CheckItemRepository.class).to(CheckItemRepository.class);
			}
		});
		// Now you can expect validation errors to be sent to the
		// client.
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}
}