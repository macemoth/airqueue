package ch.unisg.airqueue.store.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="OrderEntity")
public class Booking {

    @Id
    protected String bookingId;
    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    protected Customer customer;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Ticket ticket;

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
