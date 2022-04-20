package ch.unisg.airqueue.orchestrator.adapters;

import ch.unisg.airqueue.orchestrator.domain.Booking;
import ch.unisg.airqueue.orchestrator.messages.MessageSender;
import ch.unisg.airqueue.orchestrator.persistence.BookingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class RevertBookingAdapter implements JavaDelegate {

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private BookingRepository repository;

    @Transactional
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Booking booking = repository.findById((String) execution.getVariable("bookingId")).get();
        String traceId = execution.getProcessBusinessKey();

        if(booking != null) {
            // Customer and Ticket are automatically deleted due to cascade
            repository.deleteById(booking.getBookingId());
            LOGGER.info("The booking with id " + booking.getBookingId() + " was deleted.");
        } else {
            LOGGER.warn("Could not find booking with id " + booking.getBookingId() + " to delete.");
        }
    }
}
