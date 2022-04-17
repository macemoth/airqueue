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
    public Booking() {

    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", ticket=" + ticket + ", customer=" + customer + "]";
    }
}
