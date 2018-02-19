package com.hk.platform.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import com.hk.platform.stream.Event;

@EnableBinding(OrderSource.Source.class)
public class OrderSource {
	private final Log logger = LogFactory.getLog(getClass());
	Source orderOut;

	public OrderSource(Source orderOut) {
		this.orderOut = orderOut;
	}

	public void sendOrder(Event event) {
		logger.info("Event sent: " + event.toString());
		orderOut.ordersOut().send(new GenericMessage<>(event));
	}

	public interface Source {
		@Output
		MessageChannel ordersOut();
	}
}
