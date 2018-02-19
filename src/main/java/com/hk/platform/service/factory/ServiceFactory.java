package com.hk.platform.service.factory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.hk.platform.service.PlatformService;

@Component
public class ServiceFactory {
	
	@Autowired
	private ApplicationContext applicationContext;

	public PlatformService getService(String eventName) throws BeansException{
			return (PlatformService) applicationContext.getBean(eventName);
		
	}
}
