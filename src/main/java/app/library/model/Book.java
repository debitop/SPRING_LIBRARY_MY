package app.library.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "books")
@Entity
public class Book {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "pages")
    private int pages;

    @NotNull
    @Column(name = "author")
    private String author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
