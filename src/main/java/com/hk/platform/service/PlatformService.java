package com.hk.platform.service;

import com.hk.platform.pojo.request.Message;

import com.hk.platform.stream.Event;

public interface PlatformService {
	
    public void transformAndSend(Message message);
}
