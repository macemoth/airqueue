package ch.unisg.airqueue.test.domain;

public class NotificationEvent {
    private String content;
    private String receiverEmailAddress;
    private String source;

    public NotificationEvent(String content, String source, String receiverEmailAddress) {
        this.content = content;
        this.source = source;
        this.receiverEmailAddress = receiverEmailAddress;
    }

    public NotificationEvent() {

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "NotificationEvent [content=" + content + ", receiverEmailAddress=" + receiverEmailAddress + ", source=" + source + "]";
    }
}
