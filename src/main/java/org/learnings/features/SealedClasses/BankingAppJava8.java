package org.learnings.features.SealedClasses;

public class BankingAppJava8 {
    public static void main(String[] args) {
        Account account = new SavingsAccount();
        System.out.println(account.processTransaction("Withdrawal", 6000));
    }
}

abstract class Account {
    String type;

    Account(String type) {
        this.type = type;
    }

    abstract String processTransaction(String transactionType, double amount);
}

class SavingsAccount extends Account {
    SavingsAccount() {
        super("Savings");
    }

    @Override
    String processTransaction(String transactionType, double amount) {
        if (transactionType.equals("Withdrawal") && amount > 5000) {
            return "Withdrawal limit exceeded for Savings Account.";
        }
        return "Transaction successful: " + transactionType;
    }
}

class CurrentAccount extends Account {
    CurrentAccount() {
        super("Current");
    }

    @Override
    String processTransaction(String transactionType, double amount) {
        return "Transaction successful: " + transactionType;
    }
}

class BusinessAccount extends Account {
    BusinessAccount() {
        super("Business");
    }

    @Override
    String processTransaction(String transactionType, double amount) {
        if (transactionType.equals("Loan Repayment") && amount < 1000) {
            return "Minimum repayment amount for Business Account is $1000.";
        }
        return "Transaction successful: " + transactionType;
    }
}
