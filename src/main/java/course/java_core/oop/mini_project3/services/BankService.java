package course.java_core.oop.mini_project3.services;

import course.java_core.oop.mini_project3.models.Account;
import course.java_core.oop.mini_project3.models.Transaction;
import course.java_core.oop.mini_project3.models.enums.TransactionType;

import java.time.LocalDateTime;

public final class BankService {

    private final TransactionService transactionService;

    public BankService() {
        transactionService = new TransactionService();
    }

    public boolean transfer(Account fromAccount, Account toAccount, Double amount, String comment){

        if (fromAccount.equals(toAccount)) {
            System.err.println("Не можна переказувати на той самий рахунок.");
            return false;
        }
        if (fromAccount.getBalance() < amount) {
            System.err.println("Недостатньо коштів.");
            return false;
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setAmount(amount);
        transaction.setComment(comment);
        transaction.setTransactionType(TransactionType.TRANSFER);
        transaction.setDataTime(LocalDateTime.now());

        transactionService.addTransaction(transaction);
        return true;

    }

    public boolean withdraw(Account account, Double amount, String comment){
        if (amount <= 0) {
            System.err.println("Сума має бути більшою за нуль.");
            return false;
        }
        if (account.getBalance() < amount) {
            System.err.println("Недостатньо коштів.");
            return false;
        }

        account.withdraw(amount);

        Transaction transaction = new Transaction();
//        transaction.setId(); // TODO - create generator for ids
        transaction.setFromAccount(account);
        transaction.setToAccount(null);
        transaction.setAmount(amount);
        transaction.setComment(comment);
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setDataTime(LocalDateTime.now());

        transactionService.addTransaction(transaction);
        return true;
    }

    public boolean deposit(Account account, Double amount, String comment){
        if (amount <= 0) {
            System.err.println("Сума має бути більшою за нуль.");
            return false;
        }

        account.deposit(amount);

        account.withdraw(amount);

        Transaction transaction = new Transaction();
//        transaction.setId(); // TODO - create generator for ids
        transaction.setFromAccount(null);
        transaction.setToAccount(account);
        transaction.setAmount(amount);
        transaction.setComment(comment);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setDataTime(LocalDateTime.now());

        transactionService.addTransaction(transaction);
        return true;
    }

}
