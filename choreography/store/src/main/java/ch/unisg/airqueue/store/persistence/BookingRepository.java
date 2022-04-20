package ch.unisg.airqueue.store.persistence;

import ch.unisg.airqueue.store.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookingRepository extends CrudRepository<Booking, String> {
}
