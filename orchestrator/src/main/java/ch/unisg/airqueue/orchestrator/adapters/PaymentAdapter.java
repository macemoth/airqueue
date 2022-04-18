package ch.unisg.airqueue.orchestrator.adapters;

import ch.unisg.airqueue.orchestrator.domain.Booking;
import ch.unisg.airqueue.orchestrator.domain.Ticket;
import ch.unisg.airqueue.orchestrator.messages.GetPaymentCommand;
import ch.unisg.airqueue.orchestrator.messages.Message;
import ch.unisg.airqueue.orchestrator.messages.MessageSender;
import ch.unisg.airqueue.orchestrator.persistence.BookingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentAdapter implements JavaDelegate {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void execute(DelegateExecution execution) {
        Booking booking = bookingRepository.findById((String) execution.getVariable("bookingId")).get();
        String traceId = execution.getProcessBusinessKey();

        // generate a random ticket cost value
        Random rand = new Random();
        int amount = (int) rand.nextDouble() * 100;
        Ticket ticket = booking.getTicket();
        ticket.setTicketCost(amount);

        LOGGER.info("Sending GetPaymentCommand for " + booking.getBookingId());
        GetPaymentCommand command = new GetPaymentCommand(booking.getBookingId(), "Your airqueue Booking", ticket.getTicketCost());
        messageSender.send(new Message<GetPaymentCommand>("GetPaymentCommand", traceId, command));
    }
}
