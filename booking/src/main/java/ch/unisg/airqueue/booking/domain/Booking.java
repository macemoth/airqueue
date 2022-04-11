package ch.unisg.airqueue.booking.domain;

import java.util.UUID;

public class Booking {

    private String bookingId;
    private Customer customer;
    private Ticket ticket;

    public Booking(Customer customer, Ticket ticket) {
        this.customer = customer;
        this.ticket = ticket;
        this.bookingId = "booking-" + UUID.randomUUID().toString();
    }


    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return bookingId + " for " + ticket + " with customer " + customer;
    }
}
