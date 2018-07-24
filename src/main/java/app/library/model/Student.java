package app.library.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "age")
    @NotNull
    private int age;
    @Column(name = "admin")
        private Boolean admin;
    @Column(name = "createddate")
    @NotNull
    private Timestamp createddate;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate() {
        this.createddate = new Timestamp(System.currentTimeMillis());
    }
}
