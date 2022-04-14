package ch.unisg.airqueue.orchestrator.domain;

import java.time.LocalDate;
import java.util.Random;

public class Ticket {

    private String flightNumber;
    private LocalDate date;
    private String startPort;
    private String destinationPort;

    public Ticket(String startPort, String destinationPort) {
        Random random = new Random();
        this.flightNumber = String.valueOf(random.nextInt(999));
        this.date = LocalDate.now();
        this.startPort = startPort;
        this.destinationPort = destinationPort;
    }

    public Ticket() {
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
