package app.library.controller;

import app.library.model.Book;
import app.library.repository.BookRepository;
import app.library.repository.impl.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{studentId}")
    public String getBookById(int studentId, Model model) {
        List<Book> books = bookRepository.getAllBooksByUserId(studentId);
        model.addAttribute("books", books);
        model.addAttribute("studentId", studentId);
        return "listBook";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addBook/{studentId}")
    public String addBook(int studentId) {
        return "addBook";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addBook/{studentId}")
    public String addBook(@RequestParam("author") String author, @RequestParam("name") String name,
                          @RequestParam("pages") Integer pages, @PathVariable("studentId") Integer studentId) {
        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setPages(pages);
        bookRepository.addBook(book, studentId);
        return "redirect:/book/{studentId}";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deleteBook/{id}")
    public String delBook(@PathVariable("id") Integer id, Model model) {
        Integer studentId = bookRepository.getBookById(id).getStudent().getId();
        model.addAttribute("studentId", studentId);
        bookRepository.removeBook(id);
        return "redirect:/book/{studentId}";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editBook/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bookAttribute", bookRepository.getBookById(id));
        return "editBook";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editBook/{id}")
    public String editBook(@PathVariable("id") Integer id, @RequestParam("pages") Integer pages,
                           @RequestParam("name") String name, @RequestParam("author") String author, Model model) {
        Book book = bookRepository.getBookById(id);
        book.setPages(pages);
        book.setName(name);
        book.setAuthor(author);
        bookRepository.editBook(book);
        model.addAttribute("studentId", book.getStudent().getId());
        return "redirect:/book/{studentId}";
    }

}
