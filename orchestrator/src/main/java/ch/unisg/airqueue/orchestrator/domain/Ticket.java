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
    private int ticketCost;


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
        return "Ticket [flightNumber=" + flightNumber + ", startPort=" + startPort + ", destinationPort=" + destinationPort + "]";
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartPort() {
        return startPort;
    }

    public void setStartPort(String startPort) {
        this.startPort = startPort;
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort;
    }

    public int getTicketCost() { return ticketCost; }

    public void setTicketCost(int ticketCost) { this.ticketCost = ticketCost; }
}
