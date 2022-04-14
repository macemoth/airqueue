package ch.unisg.airqueue.payment.validator;

import ch.unisg.airqueue.payment.domain.Transaction;
import ch.unisg.airqueue.payment.messages.Message;
import ch.unisg.airqueue.payment.messages.MessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Random;

public class PaymentValidator {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private MessageSender sender;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @StreamListener(target = Sink.INPUT, condition = "(headers['type']?:'')=='PaymentReceivedEvent'")
//    @Transactional
//    public void decidePayment(String messageJson) throws JsonProcessingException {
//        Message<Transaction> inMessage = objectMapper.readValue(messageJson, new TypeReference<Message<Transaction>>() {});
//        Transaction payload = inMessage.getData();
//
//        // Here, a longer verification mechanism could be implemented
//
//        Message<Transaction> outMessage;
//
//        Random rand = new Random();
//        if (rand.nextDouble() > 0.9) {
//             outMessage = new Message<>("PaymentDeclinedEvent", payload);
//        } else {
//            outMessage = new Message<>("PaymentAcceptedEvent", payload);
//        }
//
//        sender.send(outMessage);
//    }
}
