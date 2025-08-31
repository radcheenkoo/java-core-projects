package course.java_core.oop.mini_project2.models;

import course.java_core.oop.mini_project2.models.enums.Genre;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private String title;
    private String description;
    private Author author;
    private double price;
    private Genre genre;
    private LocalDate writtenAt;


    public Book(String title, String description, Author author, double price, Genre genre, LocalDate writtenAt) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.price = price;
        this.genre = genre;

        this.writtenAt = writtenAt;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", genre=" + genre +
                ", writtenAt=" + writtenAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(price, book.price) == 0 && Objects.equals(title, book.title) && Objects.equals(description, book.description) && Objects.equals(author, book.author) && genre == book.genre &&  Objects.equals(writtenAt, book.writtenAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, author, price, genre, writtenAt);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getWrittenAt() {
        return writtenAt;
    }

    public void setWrittenAt(LocalDate writtenAt) {
        this.writtenAt = writtenAt;
    }
}
