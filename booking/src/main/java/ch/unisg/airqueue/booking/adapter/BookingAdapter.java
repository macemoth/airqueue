package ch.unisg.airqueue.booking.adapter;

import ch.unisg.airqueue.booking.domain.Booking;
import ch.unisg.airqueue.booking.messages.MessageSender;
import ch.unisg.airqueue.booking.messages.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingAdapter implements JavaDelegate {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender sender;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String bookingId = (String)delegateExecution.getVariable("bookingId");
        String traceId = delegateExecution.getProcessBusinessKey();

        // TODO maybe payload instead of bookingId
        //Message<Booking> message = new Message<>("BookingCompletedEvent", traceId, bookingId);
        LOGGER.info("message: " );
        //sender.send(message);
    }
}
