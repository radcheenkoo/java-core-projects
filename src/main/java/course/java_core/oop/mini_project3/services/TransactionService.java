package course.java_core.oop.mini_project3.services;

import course.java_core.oop.mini_project3.models.Account;
import course.java_core.oop.mini_project3.models.Bank;
import course.java_core.oop.mini_project3.models.Transaction;

import java.util.List;

public final class TransactionService {

    public boolean addTransaction(Transaction transaction){
        if (transaction == null){
            return Bank.transactions.add(transaction);
        }else {
            System.err.println("Транзакція пуста, неможливо записати.");
            return false;
        }
    }

    public boolean deleteTransaction(int transactionId){
        return Bank.transactions.remove(getTransactionById(transactionId));
    }

    public Transaction getTransactionById(int transactionId){
        return Bank.transactions.stream().filter(transaction -> transaction.getId() == transactionId)
                .findFirst().get();
    }

    public List<Transaction> getTransactionsByAccountSender(Account sender){
        return Bank.transactions.stream().filter(transaction -> transaction.getFromAccount().equals(sender))
                .toList();
    }

    public List<Transaction> getTransactionByAccountRecipient(Account account){
        return Bank.transactions.stream().filter(transaction -> transaction.getToAccount().equals(account))
                .toList();
    }

}
