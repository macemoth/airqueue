package ch.unisg.airqueue.booking.controller;

import ch.unisg.airqueue.booking.domain.Booking;
import ch.unisg.airqueue.booking.domain.Customer;
import ch.unisg.airqueue.booking.domain.Ticket;
import ch.unisg.airqueue.booking.messages.Message;
import ch.unisg.airqueue.booking.messages.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.unisg.airqueue.booking.utils.WorkflowLogger;

@RestController
public class BookingHttpController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSender sender;

    @RequestMapping(path = "/booking", method = RequestMethod.PUT)
    public String bookTicket(@RequestParam("startPort") String startPort,
                             @RequestParam("destinationPort") String destinationPort){
        System.out.println(startPort + ", " + destinationPort);
        Customer customer = new Customer("Maximilian", "maximilian@familyoffice.uk");
        Ticket ticket = new Ticket(startPort, destinationPort);
        Booking booking = new Booking(customer, ticket);

        Message<Booking> message = new Message<>("BookingEvent", booking);
        sender.send(message);
        return "{\"traceId\": \"" + message.getTraceId() + "\"}";
    }
}
