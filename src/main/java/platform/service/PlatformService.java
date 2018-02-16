package platform.service;

import platform.pojo.request.Message;
import platform.stream.Event;

public interface PlatformService {
	
    public void transformAndSend(Message message);
}
