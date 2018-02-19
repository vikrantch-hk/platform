package com.hk.platform.service.impl;

import com.hk.platform.pojo.request.Message;
import com.hk.platform.service.PlatformService;
import com.hk.platform.stream.Event;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("signUpService")
public class SignUpService implements PlatformService {

	@Autowired
	RestTemplate template;
	
    private final Log logger = LogFactory.getLog(getClass());

	@Override
	public void transformAndSend(Message message) {
		template.postForEntity("url", message, Object.class);
	}
	
	


}
