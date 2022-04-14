package ch.unisg.airqueue.orchestrator.messages;

public class BookingDoneEvent {
    private String bookingId;

    public BookingDoneEvent(String bookingId) {
        this.bookingId = bookingId;
    }

    public BookingDoneEvent() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "BookingDoneEvent [bookingId=" + bookingId + "]";
    }
}
