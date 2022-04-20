package ch.unisg.airqueue.orchestrator.adapters;

import ch.unisg.airqueue.orchestrator.commands.NotificationCommand;
import ch.unisg.airqueue.orchestrator.domain.Booking;
import ch.unisg.airqueue.orchestrator.messages.Message;
import ch.unisg.airqueue.orchestrator.messages.MessageSender;
import ch.unisg.airqueue.orchestrator.persistence.BookingRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentApprovalFailedAdapter implements JavaDelegate {

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Booking booking = bookingRepository.findById((String) execution.getVariable("bookingId")).get();
        String traceId = execution.getProcessBusinessKey();

        String customerEmail = booking.getCustomer().getEmail();
        String content = "Your payment approval failed for your booking " + booking.getBookingId() + ". Please reapply for a successful approval." +
                "\ntrace ID: " + traceId;
        NotificationCommand command = new NotificationCommand(content, booking.getBookingId(), customerEmail);
        messageSender.send(new Message<>("NotificationCommand", traceId, command));
    }
}
