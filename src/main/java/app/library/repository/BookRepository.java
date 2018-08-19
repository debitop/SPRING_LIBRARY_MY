package app.library.repository;

import app.library.model.Book;

import java.util.List;

public interface BookRepository {
    
    public void removeBook(int bookId);
    
    public void addBook(Book book, Integer studentId);
    
    public  void editBook(Book book);
    
    List<Book> getAllBooksByUserId(int userId);
    
    Book getBookById(int bookId);
    
}
