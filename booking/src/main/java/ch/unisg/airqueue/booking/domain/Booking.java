package ch.unisg.airqueue.booking.domain;

import java.util.UUID;

public class Booking {

    private String bookingId;
    private Passenger passenger;
    private Ticket ticket;

    public Booking() {}

    public Booking(Passenger passenger, Ticket ticket) {
        this.passenger = passenger;
        this.ticket = ticket;
        this.bookingId = "booking-" + UUID.randomUUID().toString();
    }

    public String getBookingId() {
        return bookingId;
    }

    public Passenger getCustomer() {
        return passenger;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ",ticket=" + ticket + ",passenger=" + passenger + "]";
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
