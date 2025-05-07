package org.learnings.features.SealedClasses.BankingAppJava21;

public class BankingAppJava21 {
    public static void main(String[] args) {
        Account account = new BusinessAccount();
        String transactionType = "Loan Repayment";
        double amount = 6000;

        String result = switch (account) {
            case SavingsAccount() when transactionType.equals("Withdrawal") && amount > 5000 ->
                "Withdrawal limit exceeded for Savings Account.";
            case SavingsAccount() -> "Transaction successful: " + transactionType;
            case CurrentAccount() -> "Transaction successful: " + transactionType;
            case BusinessAccount() when transactionType.equals("Loan Repayment") && amount < 1000 ->
                "Minimum repayment amount for Business Account is $1000.";
            case BusinessAccount() -> "Transaction successful: " + transactionType;
        };

        System.out.println(result);
    }
}

sealed interface Account permits SavingsAccount, CurrentAccount, BusinessAccount {
}

record SavingsAccount() implements Account {
}

record CurrentAccount() implements Account {
}

record BusinessAccount() implements Account {
}
