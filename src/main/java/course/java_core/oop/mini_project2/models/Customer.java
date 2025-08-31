package course.java_core.oop.mini_project2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Customer extends User{

    private List<Book> intendToRead;
    private List<Book> activeRead;
    private List<Book> doneRead;


    public Customer() {
        intendToRead = new ArrayList<>();
        activeRead = new ArrayList<>();
        doneRead = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(intendToRead, customer.intendToRead) && Objects.equals(activeRead, customer.activeRead) && Objects.equals(doneRead, customer.doneRead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), intendToRead, activeRead, doneRead);
    }

    public List<Book> getIntendToRead() {
        return intendToRead;
    }

    public boolean setIntendToRead(Book book) {
        return this.intendToRead.add(book);
    }

    public List<Book> getActiveRead() {
        return activeRead;
    }

    public boolean setActiveRead(Book book) {
        return this.activeRead.add(book);
    }

    public List<Book> getDoneRead() {
        return doneRead;
    }

    public boolean setDoneRead(Book book) {
        return this.doneRead.add(book);
    }
}
