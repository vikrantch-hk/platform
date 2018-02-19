package com.hk.platform.service.impl;

import com.hk.platform.dao.impl.BaseDaoImpl;
import com.hk.platform.dao.impl.SignUpDaoImpl;
import com.hk.platform.pojo.request.Message;
import com.hk.platform.service.PlatformService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("signUpAllService")
public class SignUpAllService implements PlatformService {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    SignUpDaoImpl dao;
    
	@Override
	public void transformAndSend(Message message) {
		transform();
		send();
	}

	private void transform() {
		//logger.info(dao.saveOrUpdate(null));
	}

	private void send() {
		// TODO Auto-generated method stub
		
	}

}
