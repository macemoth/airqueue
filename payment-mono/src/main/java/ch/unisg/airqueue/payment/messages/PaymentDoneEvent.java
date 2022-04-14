package ch.unisg.airqueue.payment.messages;

public class PaymentDoneEvent {
    private String bookingId;

    public PaymentDoneEvent(String bookingId) {
        this.bookingId = bookingId;
    }

    public PaymentDoneEvent() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "PaymentDoneEvent [bookingId=" + bookingId + "]";
    }
}
