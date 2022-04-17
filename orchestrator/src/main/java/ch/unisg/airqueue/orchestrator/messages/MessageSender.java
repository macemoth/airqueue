package ch.unisg.airqueue.orchestrator.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class MessageSender {

    @Autowired
    private MessageChannel output;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(Message<?> message) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(message);
            output.send(MessageBuilder.withPayload(jsonMessage).setHeader("type", message.getType()).build());
        } catch (Exception e) {
            throw new RuntimeException("Could not send message " + message.toString() + ". Following exception occurred: " + e.getMessage());
        }
    }
}
