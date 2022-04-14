package ch.unisg.airqueue.notification.messages;

public class NotificationSentEvent {

    private String bookingId;
    private String receiverEmailAddress;

    public NotificationSentEvent() {
    }

    public NotificationSentEvent(String bookingId, String receiverEmailAddress) {
        this.bookingId = bookingId;
        this.receiverEmailAddress = receiverEmailAddress;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getReceiverEmailAddress() {
        return receiverEmailAddress;
    }

    public void setReceiverEmailAddress(String receiverEmailAddress) {
        this.receiverEmailAddress = receiverEmailAddress;
    }

    @Override
    public String toString() {
        return "NotificationSentEvent [bookingId=" + bookingId + ", receiverEmailAddress=" + receiverEmailAddress + "]";
    }
}
