package ch.unisg.notification.Messages;

public class NotificationEvent {
    private String content;
    private String receiverEmailAddress;
    private String source;

    public NotificationEvent(String content, String source, String receiverEmailAddress) {
        this.content = content;
        this.source = source;
        this.receiverEmailAddress = receiverEmailAddress;
    }

    public String getContent() {
        return content;
    }

    public String getReceiverEmailAddress() {
        return receiverEmailAddress;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Notification from " + source + " with content " + content;
    }
}
