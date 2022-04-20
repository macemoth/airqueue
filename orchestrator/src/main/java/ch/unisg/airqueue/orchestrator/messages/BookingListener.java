package ch.unisg.airqueue.orchestrator.messages;

import ch.unisg.airqueue.orchestrator.domain.Booking;
import ch.unisg.airqueue.orchestrator.messages.Message;
import ch.unisg.airqueue.orchestrator.persistence.BookingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.spin.plugin.variable.SpinValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@EnableBinding(Sink.class)
public class BookingListener {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private BookingRepository repository;

    @Autowired
    private ProcessEngine camunda;

    @Autowired
    private ObjectMapper objectMapper;

    @StreamListener(target=Sink.INPUT, condition = "(headers['type']?:'')=='BookingEvent'")
    @Transactional
    public void receiveBookingEvent(String jsonMessage)  {
        try {
            Message<Booking> message = objectMapper.readValue(jsonMessage, new TypeReference<Message<Booking>>() {});
            Booking booking = message.getData();

            LOGGER.info("Received message for booking " + booking.getBookingId());

            repository.save(booking);

            camunda.getRuntimeService().createMessageCorrelation(message.getType())
                    .processInstanceBusinessKey(message.getTraceId())
                    .setVariable("bookingId", booking.getBookingId())
                    .correlateWithResult();
        } catch (JsonProcessingException e) {
            LOGGER.error("Cannot parse incoming message " + jsonMessage + "Exception: " + e.getMessage());
        }

    }

    @StreamListener(target = Sink.INPUT,
            condition="(headers['type']?:'').endsWith('Event')")
    @Transactional
    public void messageReceived(String messageJson) throws Exception {
        Message<JsonNode> message = objectMapper.readValue( //
                messageJson, //
                new TypeReference<Message<JsonNode>>() {});

        long correlatingInstances = camunda.getRuntimeService().createExecutionQuery() //
                .messageEventSubscriptionName(message.getType()) //
                .processInstanceBusinessKey(message.getTraceId()) //
                .count();

        if (correlatingInstances==1) {
            System.out.println("Correlating " + message + " to waiting flow instance");

            camunda.getRuntimeService().createMessageCorrelation(message.getType())
                    .processInstanceBusinessKey(message.getTraceId())
                    .setVariable(//
                            "PAYLOAD_" + message.getType(), //
                            SpinValues.jsonValue(message.getData().toString()).create())//
                    .correlateWithResult();
        }

    }
}
