package platform.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MessageSink {

    public static final String MAIL_BOLT_CHANNEL="mailBoltChannel";
    
    public static final String PERSONA_CHANNEL="personaChannel";

    @Output
    MessageChannel ordersOut();

    @Input
    SubscribableChannel mailBoltChannel();

    @Input
    SubscribableChannel personaChannel();

}
