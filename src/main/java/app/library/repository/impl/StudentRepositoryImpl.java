package app.library.repository.impl;

import app.library.model.Student;
import app.library.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Student> getStudens() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student").list();
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    @Override
    public void delStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
    }

    @Override
    public void editStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student studentOld = session.get(Student.class, student.getId());
        studentOld.setName(student.getName());
        studentOld.setAge(student.getAge());
        studentOld.setAdmin(student.getAdmin());
        session.merge(studentOld);
    }

    @Override
    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
}
