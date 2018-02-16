/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package platform.stream.config.binding;

import platform.service.factory.ServiceFactory;
import platform.stream.Event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(PersonaStreamConfiguration.PersonaSink.class)
@ConditionalOnProperty(name = "spring.cloud.stream.bindings.personaChannel1111.enabled", havingValue = "true", matchIfMissing = false)
public class PersonaStreamConfiguration {

	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	ServiceFactory factory;

	@StreamListener(value = PersonaSink.PERSONA_CHANNEL)
	public void processPersonaMessage(Event message) {
		try {
			//PlatformService service = factory.getService(message.getEventName());
			//service.transformAndSend(message);
			logger.info(" processPersonaMessage "+message);
		} catch (BeansException exception) {
			logger.error("exception occured in processPersonaMessage " + exception.getMessage());
		}
	}
	
	public interface PersonaSink {
	    String PERSONA_CHANNEL="personaChannel";

	    @Input
	    SubscribableChannel personaChannel();
	}


}
