package ch.unisg.airqueue.payment.domain;

public class Transaction {
    private String bookingId;
    private int amount;

    public Transaction(String bookingId, int amount) {
        this.bookingId = bookingId;
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "Transaction for" + bookingId + " with amount " + amount;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
