package History;

import java.util.Date;

public class AccountHistory {
    protected Integer accountArrival;
    protected int amount;
    private Date transferDate;
    private String message;

    public AccountHistory(Integer accountArrival, int amount, String message) {
        this.accountArrival = accountArrival;
        this.amount = amount;
        this.message = message;
        this.transferDate = new Date();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public void setAccountArrival(Integer accountArrival) {
        this.accountArrival = accountArrival;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "History.AccountHistory{" +
                "accountArrival=" + accountArrival +
                ", amount=" + amount +
                ", transferDate=" + transferDate +
                ", message='" + message + '\'' +
                '}';
    }
}
