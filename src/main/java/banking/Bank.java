package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        // complete the function
        this.accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        return this.accounts.get(accountNumber);
    }

    public synchronized Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
        Long accountNumber = (long) accounts.size() + 1;
        this.accounts.put(accountNumber, new CommercialAccount(company, accountNumber, pin, startingDeposit));
        return this.accounts.get(accountNumber).getAccountNumber();
    }

    public synchronized Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
        Long accountNumber = (long) accounts.size() + 1;
        this.accounts.put(accountNumber, new ConsumerAccount(person, accountNumber, pin, startingDeposit));
        return this.accounts.get(accountNumber).getAccountNumber();
    }

    public synchronized boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
        return this.accounts.get(accountNumber).validatePin(pin);
    }

    public synchronized double getBalance(Long accountNumber) {
        // complete the function
        return this.accounts.get(accountNumber).getBalance();
    }

    public synchronized void credit(Long accountNumber, double amount) {
        // complete the function
        this.accounts.get(accountNumber).creditAccount(amount);
    }

    public synchronized boolean debit(Long accountNumber, double amount) {
        // complete the function
        return this.accounts.get(accountNumber).debitAccount(amount);
    }
}
