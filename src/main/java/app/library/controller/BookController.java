package app.library.controller;

import app.library.model.Book;
import app.library.repository.BookRepository;
import app.library.repository.impl.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getBookById(int studentId, Model model){
        List<Book>books =bookRepository.getAllBooksByUserId(studentId);
        model.addAttribute("books", books);
        return "listBook";
    }


}
