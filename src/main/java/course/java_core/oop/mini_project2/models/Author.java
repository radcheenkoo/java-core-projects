package course.java_core.oop.mini_project2.models;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public final class Author extends User {

    private List<Book> writtenBooks;
    private LocalDate dateOfBirth;



    @Override
    public String toString() {
        return "Author{" +
                "writtenBooks=" + writtenBooks +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(writtenBooks, author.writtenBooks) && Objects.equals(dateOfBirth, author.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), writtenBooks, dateOfBirth);
    }

    public List<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(List<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
