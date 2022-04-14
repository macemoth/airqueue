package ch.unisg.airqueue.booking.controller;

import ch.unisg.airqueue.booking.domain.Booking;
import ch.unisg.airqueue.booking.domain.Passenger;
import ch.unisg.airqueue.booking.domain.Ticket;
import ch.unisg.airqueue.booking.messages.Message;
import ch.unisg.airqueue.booking.messages.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class BookingHttpController {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender sender;

    @RequestMapping(path = "/booking", method = RequestMethod.PUT)
    public String bookTicket(@RequestParam("startPort") String startPort,
                             @RequestParam("destinationPort") String destinationPort){
        LOGGER.info("New booking for destinations: " + startPort + " to " + destinationPort);

        Passenger passenger = new Passenger("Maximilian", "maximilian@familyoffice.uk");
        Ticket ticket = new Ticket(startPort, destinationPort);
        Booking booking = new Booking(passenger, ticket);

        Message<Booking> message = new Message<>("BookingEvent", (Booking)booking);
        sender.send(message);

        return "{\"traceId\": \"" + message.getTraceId() + "\"}";
    }
}
