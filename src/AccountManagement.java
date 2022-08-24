import History.AccountHistory;

import java.util.ArrayList;
import java.util.List;

public class AccountManagement {
    List<AccountData> accountList;
    List<MasterAccountSecurity> masterAccountSecurityList;

    public AccountManagement() {
        this.accountList = new ArrayList<>();
    }

    public void addAccount(AccountData account) {
        this.accountList.add(account);
    }

    public AccountData getAccountByNumber(int accNumber) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accNumber == accountList.get(i).getAccNumber()) {
                return accountList.get(i);
            }
        }
        return null;
    }

    public boolean checkAccount(int accNumber) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accNumber == accountList.get(i).getAccNumber()) {
                return true;
            }
        }
        return false;
    }

    public int getAccIndex(int accNumber) {
        for (int i = 0; i < accountList.size(); i++){
            if (accNumber == accountList.get(i).getAccNumber()) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkPassword(int accNumber, int accPassword) {
        if (accPassword == accountList.get(getAccIndex(accNumber)).getAccPassword()) {
            return true;
        }
        return false;
    }

    public int checkAccBalance(int accNumber) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accNumber == accountList.get(i).getAccNumber()) {
                return accountList.get(i).getAmountBalance();
            }
        }
        return -1;
    }

    public void addMoney(int accNumber, int amountAdd) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accNumber == accountList.get(i).getAccNumber()) {
                int newBalance = accountList.get(i).getAmountBalance() + amountAdd;
                accountList.get(i).setAmountBalance(newBalance);
                accountList.get(i).addHistory(new AccountHistory(accNumber, amountAdd, "Add " + amountAdd + " to " + accNumber));
            }
        }
    }

    public void withdrawMoney(int accNumber, int amountWithdraw) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accNumber == accountList.get(i).getAccNumber()) {
                int newBalance = accountList.get(i).getAmountBalance() - amountWithdraw;
                accountList.get(i).setAmountBalance(newBalance);
                accountList.get(i).addHistory(new AccountHistory(null, -amountWithdraw, "Withdraw " + amountWithdraw + " from " + accNumber));
            }
        }
    }

    public boolean checkAccountArrivalValidity(int accNumber, int accountArrival) {
        if (accNumber == accountArrival) {
            return false;
        } else if (checkAccount(accountArrival)) {
            return true;
        }
        return false;
    }

    public void makeTransfer(int accNumber, int accountArrival, int amountTransfer) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accNumber == accountList.get(i).getAccNumber()) {
                int newBalance = accountList.get(i).getAmountBalance() - amountTransfer;
                accountList.get(i).setAmountBalance(newBalance);
                accountList.get(i).addHistory(new AccountHistory(accountArrival, -amountTransfer, "send " + amountTransfer + " to " + accountArrival));
            }
        }
        for (int i = 0; i < accountList.size(); i++) {
            if (accountArrival == accountList.get(i).getAccNumber()) {
                int newBalance = accountList.get(i).getAmountBalance() + amountTransfer;
                accountList.get(i).setAmountBalance(newBalance);
                accountList.get(i).addHistory(new AccountHistory(accountArrival, amountTransfer, "receiver " + amountTransfer + " from " + accNumber));
            }
        }
    }

    public List<AccountHistory> getTopHistory(int accNumber, int numRecord) {
        List<AccountHistory> result = new ArrayList<>();
        AccountData accountData = getAccountByNumber(accNumber);
        if (accountData.getAccountHistoryList() == null || accountData.getAccountHistoryList().size() == 0) {
            return null;
        }
        for (int i = 0; i < numRecord; i++) {
            if (i < accountData.getAccountHistoryList().size()) {
                result.add(accountData.getAccountHistoryList().get(i));
            }
        }
        return result;
    }

    public boolean checkMasterAccountToAddAccount(String name, String password){
        for (int i = 0; i < masterAccountSecurityList.size(); i++){
            if (name.equals(masterAccountSecurityList.get(i).getMasterAccountName())){
                if (password.equals(masterAccountSecurityList.get(i).getMasterAccountPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
