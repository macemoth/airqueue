package ch.unisg.airqueue.payment.messages;

import ch.unisg.airqueue.booking.domain.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.spin.plugin.variable.SpinValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@EnableBinding(Sink.class)
public class MessageListener {

    @Autowired
    private ProcessEngine camunda;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Handles incoming BookingEvent
     */
    @StreamListener(target = Sink.INPUT,
            condition="(headers['type']?:'')=='BookingEvent'")
    @Transactional
    public void bookingPlaced(Message<Booking> message) throws JsonProcessingException {
        Booking booking = message.getData();
        //Message<Booking> message = objectMapper.readValue(messageJson, new TypeReference<Message<Booking>>(){});
        //Booking booking = message.getData();

        if(booking != null ) {
            System.out.println("New booking placed, start flow. " + booking);

            camunda.getRuntimeService().createMessageCorrelation(message.getType())
                    .processInstanceBusinessKey(message.getTraceId())
                    .setVariable("bookingId", booking.getBookingId())
                    .setVariable("passenger", booking.getPassenger())
                    .setVariable("ticket", booking.getTicket())
                    .setVariable("correlationId", message.getCorrelationid()) //
                    .correlateWithResult();
        } else {
            System.out.println("No booking");
        }
    }
}
