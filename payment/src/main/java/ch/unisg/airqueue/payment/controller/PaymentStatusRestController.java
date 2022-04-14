package ch.unisg.airqueue.payment.controller;

import ch.unisg.airqueue.payment.messages.Message;
import ch.unisg.airqueue.payment.messages.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
public class PaymentStatusRestController {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender sender;

    @RequestMapping(path= "/payment", method = RequestMethod.POST)
    public ResponseEntity<String> bookTicket(String bookingId){
        LOGGER.info("bookTicket requested for bookingId: " + bookingId);

        // Async message for potentially long-running verification service
        // Message<Ticket> message = new Message<>("TicketStatusUpdateEvent", ticket);
        // sender.send(message);

        return new ResponseEntity<>("Payment for " + bookingId + " accepted.", new HttpHeaders(), HttpStatus.CREATED);
    }
}
