package ch.unisg.airqueue.booking.domain;

import java.time.LocalDate;
import java.util.Random;

public class Ticket {

    private String flightNumber;
    private LocalDate date;

    public Ticket() {
        Random random = new Random();
        this.flightNumber = String.valueOf(random.nextInt(999));
        this.date = LocalDate.now();
    }

    public Ticket(String flightNumber) {
        this.flightNumber = flightNumber;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Ticket with flight number " + flightNumber + " for " + date.toString();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDate getDate() {
        return date;
    }

}
