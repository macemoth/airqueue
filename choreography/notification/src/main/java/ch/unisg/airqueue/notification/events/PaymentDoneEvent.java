package ch.unisg.airqueue.notification.events;

public class PaymentDoneEvent {
    private String bookingId;
    private String customerEmail;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

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
        return "PaymentDoneEvent [bookingId=" + bookingId + ", customerEmail=" + customerEmail +"]";
    }
}
