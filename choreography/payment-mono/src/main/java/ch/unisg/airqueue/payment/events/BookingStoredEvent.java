package ch.unisg.airqueue.payment.events;

public class BookingStoredEvent {
    private String bookingId;
    private String subject;
    private int amount;
    private String customerEmail;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public BookingStoredEvent() {}

    public BookingStoredEvent(String bookingId, String subject, int amount) {
        this.bookingId = bookingId;
        this.subject = subject;
        this.amount = amount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BookingStoredEvent [subject=" + subject + ", amount=" + amount + ", bookingId=" + bookingId + ", customerEmail=" + customerEmail + "]";
    }

}
