package ch.unisg.airqueue.orchestrator.persistence;

import ch.unisg.airqueue.orchestrator.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookingRepository extends CrudRepository<Booking, String> {
}
