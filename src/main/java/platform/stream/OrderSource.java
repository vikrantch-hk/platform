package platform.stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {
        "platform.stream"
})
public class OrderSource {

    private MessageSink orderOut;

    @Autowired
    public OrderSource(MessageSink orderOut) {
        this.orderOut = orderOut;
    }

    public void sendOrder(Event event) {
        orderOut.ordersOut().send(new GenericMessage<>(event));
    }
}
