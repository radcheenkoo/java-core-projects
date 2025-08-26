package course.java_core.basics.mini_final_project;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book>, Comparator<Book>, Cloneable {

    private String title;
    private String author;
    private int pages;


    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    /*
    * Сортування по книг за кількістю сторінок
    * */
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.pages < o2.pages){
            return -1;
        } else if (o1.pages > o2.pages) {
            return 1;
        }else {
            return 0;
        }
    }

    /*
    * Сортування по автору
    * */
    @Override
    public int compareTo(Book o) {
        return this.author.compareTo(o.author);
    }

    /*
    * Перевизначений метод для порівнювання
    * */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    /*
    * перевизначений хеш код
    * */
    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    /*
    * Перевизначений метод clone, що створює копії об'єктів
    * */
    @Override
    public Book clone() {
        try {
            Book clone = (Book) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
