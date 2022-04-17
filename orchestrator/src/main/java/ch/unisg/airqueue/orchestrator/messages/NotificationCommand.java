package ch.unisg.airqueue.orchestrator.messages;

public class NotificationCommand {
    private String content;
    private String receiverEmailAddress;
    private String bookingId;

    public NotificationCommand(String content, String bookingId, String receiverEmailAddress) {
        this.content = content;
        this.bookingId = bookingId;
        this.receiverEmailAddress = receiverEmailAddress;
    }

    public NotificationCommand() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReceiverEmailAddress() {
        return receiverEmailAddress;
    }

    public void setReceiverEmailAddress(String receiverEmailAddress) {
        this.receiverEmailAddress = receiverEmailAddress;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "NotificationCommand [content=" + content + ", receiverEmailAddress=" + receiverEmailAddress + ", bookingId=" + bookingId + "]";
    }
}
