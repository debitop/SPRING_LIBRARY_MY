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
    private int studentid;
    private String name;
    private int pages;
    private String author;



}
