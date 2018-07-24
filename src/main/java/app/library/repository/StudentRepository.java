package app.library.repository;

import app.library.model.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> getStudens();

    void addStudent(Student student);

    void delStudent(int id);

    void editStudent(Student student);

    Student getStudentById(int id);

}
