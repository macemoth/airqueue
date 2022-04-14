package ch.unisg.airqueue.payment.adapter;

import ch.unisg.airqueue.booking.domain.Booking;
import ch.unisg.airqueue.payment.messages.Message;
import ch.unisg.airqueue.payment.domain.Transaction;
import ch.unisg.airqueue.payment.messages.MessageSender;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// not sure if named is necessary
// @Named
@Service("PaymentAdapter")
public class PaymentAdapter implements JavaDelegate {

    @Autowired
    private MessageSender sender;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public void execute(DelegateExecution delegateExecution) throws Exception {
        Booking booking = (Booking) delegateExecution.getVariable("booking");
        String traceId = delegateExecution.getProcessBusinessKey();

        // TODO : do I need to add .get() above?
        LOGGER.info("Found booking " + booking);

        // generate a random ticket cost value
        Random rand = new Random();
        int amount = (int) rand.nextDouble() * 100;
        Transaction transaction = new Transaction(booking.getBookingId(), amount);

        // generate a randomised payment acceptal status
        boolean paymentStatus;
        rand = new Random();
        if (rand.nextDouble() > 0.9) {
            paymentStatus = false;
        } else {
            paymentStatus = true;
        }

        // set global expression variable for paymentapproval status
        delegateExecution.setVariable("paymentApproval", (boolean)paymentStatus);
        LOGGER.info("Updated payment status to " + paymentStatus);

        // not sure if message is necessary
        Message<Transaction> message = new Message<>("PaymentAcceptedEvent", traceId, transaction);
        LOGGER.info("message: " + message);
        sender.send(message);
    }
}