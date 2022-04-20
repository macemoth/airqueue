package ch.unisg.airqueue.booking.domain;


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
        return "Ticket [flightNumber=" + flightNumber + ", startPort=" + startPort + ", destinationPort=" + destinationPort + "]";
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
}
