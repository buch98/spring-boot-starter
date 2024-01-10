package com.example.QuickStart.app.Controller;

import com.example.QuickStart.app.Entity.BookEntity;
import com.example.QuickStart.app.Service.IBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @PutMapping (path="/books/{isbn}")
    public ResponseEntity<BookEntity> createBook(@PathVariable("isbn") String isbn, @RequestBody BookEntity book){
        return new ResponseEntity<>(iBookService.createBook(book,isbn), HttpStatus.CREATED);
    }

    @GetMapping(path="/books")
    public Page<BookEntity> getBook(Pageable pageable){
        Page<BookEntity> books = iBookService.findAll(pageable);
        return books;
    }


    @GetMapping(path="/book/{isbn}")
    public ResponseEntity<BookEntity> getBook(@PathVariable("isbn") String isbn){
        Optional<BookEntity> book = iBookService.findOne(isbn);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path="/book/{isbn}")
    public ResponseEntity<BookEntity> fullUpdateBook(@PathVariable("isbn") String isbn,@RequestBody BookEntity book){
        if(!iBookService.isExists(isbn)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iBookService.createBook(book,isbn), HttpStatus.OK);
    }

}
