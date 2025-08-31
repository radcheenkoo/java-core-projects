package course.java_core.oop.mini_project3.models;

import java.util.Objects;

public abstract class Account {

    private String id;
    private Double balance;


    public void withdraw(Double amount){
        if (amount > 0 && (this.balance - amount) >= 0){
            this.balance = this.balance - amount;
        }else {
            System.err.println("Недостатня коштів.");
        }
    }

    public void deposit(Double amount){
        if (amount > 0){
            this.balance = this.balance + amount;
        }else {
            System.err.println("Не можна завести менше 0.");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }
}
