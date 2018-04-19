package examples.boot.simpleboard.controller;

import examples.boot.simpleboard.dto.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    @GetMapping(path = "/{id}")
    public Book getBook(@PathVariable(name = "id") Long id){

        Book book = new Book();
        book.setTitle("java!!");
        book.setPrice(500);

        return book;
    }
}
