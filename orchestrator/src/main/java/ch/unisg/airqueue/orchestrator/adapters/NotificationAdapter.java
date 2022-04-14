package ch.unisg.airqueue.orchestrator.adapters;

import ch.unisg.airqueue.orchestrator.domain.Booking;
import ch.unisg.airqueue.orchestrator.messages.Message;
import ch.unisg.airqueue.orchestrator.messages.MessageSender;
import ch.unisg.airqueue.orchestrator.messages.NotificationCommand;
import ch.unisg.airqueue.orchestrator.persistence.BookingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationAdapter implements JavaDelegate {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Booking booking = bookingRepository.findById((String) execution.getVariable("bookingId")).get();
        String traceId = execution.getProcessBusinessKey();

        // TODO: fetch customer e-mail to send to appropriate customer
        String customerEmail = "marcesoler@sns.network";
        String content = "Your booking " + booking.getBookingId() + " was reserved successfully. Thank you for flying with airqueue";
        NotificationCommand command = new NotificationCommand(content, booking.getBookingId(), customerEmail);
        messageSender.send(new Message<NotificationCommand>("NotificationCommand", traceId, command));
    }
}
