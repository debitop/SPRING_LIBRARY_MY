package app.library.repository.impl;

import app.library.model.Book;
import app.library.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void removeBook(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, bookId);
        session.delete(book);
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void editBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Book bookOld = session.get(Book.class, book.getId());
        bookOld.setName(book.getName());
        bookOld.setPages(book.getPages());
        bookOld.setAuthor(book.getAuthor());
        session.update(bookOld);
    }

    @Override
    public List<Book> getAllBooksByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book b where b.student.id=:studentId")
                .setParameter("studentId", userId).list();
    }

    @Override
    public Book getBookById(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, bookId);
    }
}
