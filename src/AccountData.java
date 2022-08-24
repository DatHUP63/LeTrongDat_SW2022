import History.AccountHistory;

import java.util.ArrayList;
import java.util.List;

public class AccountData {
    protected String name;
    protected int accNumber;
    protected int accPassword;
    protected int amountBalance;
    List<AccountHistory> accountHistoryList;

    public AccountData(String name, int accNumber, int accPassword, int amountBalance){
        this.name = name;
        this.accNumber = accNumber;
        this.accPassword = accPassword;
        this.amountBalance = amountBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getAccPassword() {
        return accPassword;
    }

    public void setAccPassword(int accPassword) {
        this.accPassword = accPassword;
    }

    public int getAmountBalance() {
        return amountBalance;
    }

    public void setAmountBalance(int amountBalance) {
        this.amountBalance = amountBalance;
    }

    public List<AccountHistory> getAccountHistoryList() {
        return accountHistoryList;
    }

    public void setAccountHistoryList(List<AccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

    public void addHistory(AccountHistory accountHistory){
        if(this.accountHistoryList == null){
            this.accountHistoryList = new ArrayList<>();
        }
        this.accountHistoryList.add(accountHistory);
    }
}
