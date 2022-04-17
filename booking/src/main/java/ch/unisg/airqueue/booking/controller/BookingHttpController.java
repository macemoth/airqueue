package ch.unisg.airqueue.booking.controller;

import ch.unisg.airqueue.booking.domain.Booking;
import ch.unisg.airqueue.booking.domain.Customer;
import ch.unisg.airqueue.booking.domain.Ticket;
import ch.unisg.airqueue.booking.messages.Message;
import ch.unisg.airqueue.booking.messages.MessageSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
public class BookingHttpController {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender sender;

    @RequestMapping(path = "/booking", method = RequestMethod.PUT)
    public String bookTicket(@RequestParam("startPort") String startPort,
                             @RequestParam("destinationPort") String destinationPort,
                             @RequestParam("email") String email){
        LOGGER.info("Received Booking from " + startPort + " to " + destinationPort + " with email " + email);
        Customer customer = new Customer("Maximilian", email);
        Ticket ticket = new Ticket(startPort, destinationPort);
        Booking booking = new Booking(customer, ticket);

        Message<Booking> message = new Message<>("BookingEvent", booking);
        sender.send(message);
        LOGGER.info("Sent BookingEvent for " + startPort + " to " + destinationPort);
        return "{\"traceId\": \"" + message.getTraceId() + "\"}";
    }
}
