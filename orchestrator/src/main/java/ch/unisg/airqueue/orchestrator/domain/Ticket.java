package ch.unisg.airqueue.orchestrator.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Random;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String ticketId;
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
        return "Ticket [flightNumber=" + flightNumber + ", startPort=" + startPort + ", destinationPort=" + destinationPort +"]";
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDate getDate() {
        return date;
    }

}
