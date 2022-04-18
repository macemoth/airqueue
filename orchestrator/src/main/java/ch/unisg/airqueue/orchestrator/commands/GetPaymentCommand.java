package ch.unisg.airqueue.orchestrator.commands;

public class GetPaymentCommand {

    private String bookingId;
    private String subject;
    private int amount;

    public GetPaymentCommand() {}

    public GetPaymentCommand(String bookingId, String subject, int amount) {
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
        return "PaymentCommand [subject=" + subject + ", amount=" + amount + ", bookingId=" + bookingId + "]";
    }

}
