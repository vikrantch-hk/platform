package platform.service.impl;

import platform.pojo.request.Message;
import platform.service.PlatformService;
import platform.stream.Event;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("signUpAllService")
public class SignUpAllService implements PlatformService {

    private final Log logger = LogFactory.getLog(getClass());

	@Override
	public void transformAndSend(Message message) {
		transform();
		send();
	}

	private void transform() {
		// TODO Auto-generated method stub
		
	}

	private void send() {
		// TODO Auto-generated method stub
		
	}

}
