package course.java_core.oop.mini_project3.models;

import course.java_core.oop.mini_project3.models.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Transaction {

    private int id;
    private String comment;
    private Account fromAccount;
    private Account toAccount;
    private Double amount;
    private LocalDateTime dataTime;
    private TransactionType transactionType;


    public Transaction() {
    }

    public Transaction(int id, String comment, Account fromAccount, Account toAccount, Double amount, LocalDateTime dataTime, TransactionType transactionType) {
        this.id = id;
        this.comment = comment;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.dataTime = dataTime;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", amount=" + amount +
                ", dataTime=" + dataTime +
                ", transactionType=" + transactionType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Objects.equals(comment, that.comment) && Objects.equals(fromAccount, that.fromAccount) && Objects.equals(toAccount, that.toAccount) && Objects.equals(amount, that.amount) && Objects.equals(dataTime, that.dataTime) && transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, fromAccount, toAccount, amount, dataTime, transactionType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
