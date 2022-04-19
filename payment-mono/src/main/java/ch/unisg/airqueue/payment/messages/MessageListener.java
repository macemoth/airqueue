package ch.unisg.airqueue.payment.messages;

import ch.unisg.airqueue.payment.commands.GetPaymentCommand;
import ch.unisg.airqueue.payment.events.PaymentDoneEvent;
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
    private MessageSender messageSender;

    @StreamListener(target = Sink.INPUT, condition = "(headers['type']?:'')=='GetPaymentCommand'")
    @Transactional
    public void receiveMessage(String messageJson) throws JsonProcessingException {
        Message<GetPaymentCommand> message = objectMapper.readValue(messageJson, new TypeReference<Message<GetPaymentCommand>>() {});
        GetPaymentCommand command = message.getData();
        LOGGER.info("Received GetPaymentCommand" + command.getBookingId());

        // TODO: add payment validation logic

        PaymentDoneEvent event = new PaymentDoneEvent(command.getBookingId());
        messageSender.send(new Message<>("PaymentDoneEvent", message.getTraceId(), event));
    }

}
