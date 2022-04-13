package ch.unisg.airqueue.notification.messages;

import ch.unisg.airqueue.notification.email.EmailSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@EnableBinding(Sink.class)
public class MessageListener {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailSender emailSender;

    @StreamListener(target = Sink.INPUT, condition = "(headers['type']?:'')=='NotificationEvent'")
    @Transactional
    public void receiveMessage(String messageJson) throws JsonProcessingException {
        Message<NotificationEvent> message = objectMapper.readValue(messageJson, new TypeReference<Message<NotificationEvent>>() {});
        NotificationEvent notification = message.getData();
        LOGGER.info("Received notification event" + notification.toString());

        emailSender.sendEmail(notification.getReceiverEmailAddress(), "airqueue Notification", notification.getContent());
        // add further notification methods here
    }

}
