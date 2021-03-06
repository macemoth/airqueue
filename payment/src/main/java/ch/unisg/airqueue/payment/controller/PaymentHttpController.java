package ch.unisg.airqueue.payment.controller;

import ch.unisg.airqueue.payment.domain.Transaction;
import ch.unisg.airqueue.payment.messages.Message;
import ch.unisg.airqueue.payment.messages.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ch.unisg.airqueue.payment.utils.WorkflowLogger;

@RestController
public class PaymentHttpController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSender sender;

    @RequestMapping(path = "/payment", method = RequestMethod.PUT)
    public ResponseEntity<String> bookTicket(@RequestParam("bookingId") String bookingId,
                                             @RequestParam("amount") int amount){
        WorkflowLogger.info(logger, "payment received", bookingId + " from PaymentHttpController");

        Transaction transaction = new Transaction(bookingId, amount);

        // Async message for potentially long-running verification service
        Message<Transaction> message = new Message<>("PaymentReceivedEvent", transaction);
        sender.send(message);
        return new ResponseEntity<>("Payment for " + bookingId + " received.", new HttpHeaders(), HttpStatus.CREATED);
    }
}
