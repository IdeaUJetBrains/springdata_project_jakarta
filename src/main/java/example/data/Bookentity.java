package example.data;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "BOOKENTITY")
public class Bookentity {

    public Bookentity( int a ) {
    }

    public Bookentity( ) {
    }


    private long id;
    private String author;
    private String title;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AUTHOR", nullable = false, length = 255)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookentity that = (Bookentity) o;
        return id == that.id && Objects.equals(author, that.author) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title);
    }
}
