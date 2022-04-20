package ch.unisg.airqueue.store.messages;

import ch.unisg.airqueue.store.domain.Booking;
import ch.unisg.airqueue.store.events.BookingStoredEvent;
import ch.unisg.airqueue.store.persistence.BookingRepository;
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

import javax.transaction.Transactional;
import java.util.Random;

@Component
@EnableBinding(Sink.class)
public class MessageListener {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private BookingRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MessageSender messageSender;

    @StreamListener(target=Sink.INPUT, condition = "(headers['type']?:'')=='BookingEvent'")
    @Transactional
    public void receiveBookingEvent(String jsonMessage)  {
        try {
            Message<Booking> message = objectMapper.readValue(jsonMessage, new TypeReference<Message<Booking>>() {});
            Booking booking = message.getData();

            LOGGER.info("Received message for booking " + booking.getBookingId());

            repository.save(booking);

            Random rand = new Random();
            int amount = (int) rand.nextDouble() * 100;
            BookingStoredEvent event = new BookingStoredEvent(booking.getBookingId(), "airqueue payment", amount);
            event.setCustomerEmail(booking.getCustomer().getEmail());
            LOGGER.info("Sending Booking Stored Event for " + booking.getBookingId());
            messageSender.send(new Message<BookingStoredEvent>("BookingStoredEvent", "0", event));

        } catch (JsonProcessingException e) {
            LOGGER.error("Cannot parse incoming message " + jsonMessage + "Exception: " + e.getMessage());
        }

    }

}
