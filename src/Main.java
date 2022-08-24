import History.AccountHistory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        AccountManagement accountManagement = new AccountManagement();
        accountManagement = Reader.loadData(new File("/Users/namnguyenvu/Desktop/IdeaProjects/BankingAccountExerciseLecture2/src/data.txt"));
        AccountManagement security = new AccountManagement();
        security = MasterAccountReader.loadData(new File("/Users/namnguyenvu/Desktop/IdeaProjects/BankingAccountExerciseLecture2/src/MasterAcc.txt"));
        while (true) {
            System.out.println("Welcome to bank!");
            System.out.println("Please enter account");
            int accNumber = scanner.nextInt();
            if (accountManagement.checkAccount(accNumber)) {
                System.out.println("Please enter account password");
                int accPassword = scanner.nextInt();
                if (accountManagement.checkPassword(accNumber, accPassword)) {
                    System.out.println("\nAccess granted!\n");
                    int choice = 0;
                    while (choice <= 5) {
                        System.out.println("Please select the following actions");
                        System.out.println("1. Check account balance");
                        System.out.println("2. Add/Withdraw money");
                        System.out.println("3. Transfer money");
                        System.out.println("4. Check history");
                        System.out.println("5. Add new account");
                        System.out.println("6. Exit");
                        choice = scanner.nextInt();

                        if (choice == 1) {
                            System.out.println("Your account balance is " + accountManagement.checkAccBalance(accNumber));
                        }
                        else if (choice == 2) {
                            System.out.println("Please the following action");
                            System.out.println("1. Add money");
                            System.out.println("2. Withdraw money");
                            int choice1 = scanner.nextInt();
                            switch (choice1) {
                                case 1: {
                                    System.out.println("Please select amount you want to add");
                                    int amountAdd = scanner.nextInt();
                                    accountManagement.addMoney(accNumber, amountAdd);
                                    System.out.println("Money Added!");
                                    System.out.println("New balance: " + accountManagement.checkAccount(accNumber));
                                    break;
                                }
                                case 2: {
                                    System.out.println("Please select amount you want to withdraw");
                                    int amountWithdraw = scanner.nextInt();
                                    if (amountWithdraw <= accountManagement.checkAccBalance(accNumber)) {
                                        accountManagement.withdrawMoney(accNumber, amountWithdraw);
                                        System.out.println("Money Withdraw");
                                        System.out.println("New balance: " + accountManagement.checkAccount(accNumber));
                                    } else {
                                        System.out.println("Don't have enough money");
                                        break;
                                    }
                                    break;
                                }
                            }
                        }
                        else if (choice == 3) {
                            System.out.println("Please type the account number you want to transfer to");
                            int accountArrival = scanner.nextInt();
                            if (accountManagement.checkAccountArrivalValidity(accNumber, accountArrival)) {
                                System.out.println("Please select amount you want to transfer");
                                int amountTransfer = scanner.nextInt();
                                if (amountTransfer > accountManagement.checkAccBalance(accNumber)) {
                                    System.out.println("Don't have enough money");
                                } else {
                                    accountManagement.makeTransfer(accNumber, accountArrival, amountTransfer);
                                    System.out.println("Money Transferred");
                                    System.out.println("New balance: " + accountManagement.checkAccBalance(accNumber));
                                }
                            } else {
                                System.out.println("Account don't exist");
                            }
                        }
                        else if (choice == 4) {
                            System.out.println("Please select number of history");
                            int number = scanner.nextInt();
                            List<AccountHistory> lstHistory = accountManagement.getTopHistory(accNumber, number);
                            if (lstHistory == null) {
                                System.out.println("No history found");
                            } else {
                                for (AccountHistory accountHistory : lstHistory) {
                                    System.out.println(accountHistory.toString());
                                }
                            }
                        }
                        else if (choice == 5) {
                            Scanner scanner1 = new Scanner(System.in);
                            System.out.println("Please enter master account name to access");
                            String name = scanner1.nextLine();
                            System.out.println("Please enter master account password to access");
                            String password = scanner1.nextLine();
                            if (security.checkMasterAccountToAddAccount(name, password)){
                                System.out.println("Please enter user name to add: ");
                                String accName = scanner1.nextLine();
                                System.out.println("Please enter account number to add: ");
                                int accountNumber = scanner1.nextInt();
                                System.out.println("Please enter account password to add: ");
                                int accPass = scanner1.nextInt();
                                System.out.println("Please enter account initial balance to add: ");
                                int accBalance = scanner1.nextInt();
                                AccountData account = new AccountData(accName, accountNumber, accPass, accBalance);
                                accountManagement.addAccount(account);
                            }
                        }
                        else if (choice == 6) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Wrong Password!");
                }
            }
            System.out.println(" Do you want continue? ");
            System.out.println(" 1. Y  ");
            System.out.println(" 2. N  ");
            int choice = scanner.nextInt();
            if (choice == 2) {
                break;
            }
        }
    }
}
