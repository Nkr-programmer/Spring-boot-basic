package com.bookrestapi.bookapi.controllers;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookrestapi.bookapi.entities.Book;
import com.bookrestapi.bookapi.service.BookService;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks()
    {
        List<Book> list= this.bookService.getAllBooks();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
//        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id )
    {
        try{
        Book book= this.bookService.getBook(id);
       // return ResponseEntity.of(Optional.of(book));
     return ResponseEntity.status(HttpStatus.CREATED).body(book);
        }
        catch(Exception e)
        {   System.out.println("...............................................................");
            e.printStackTrace();
            System.out.println("...............................................................");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book>  createBook(@RequestBody Book book)
    {
        try{
        Book b= this.bookService.addBook(book);
        //return ResponseEntity.of(Optional.of(b));
           return ResponseEntity.status(HttpStatus.CREATED).body(b);
        }
        catch(Exception e)
        {   System.out.println("...............................................................");
            e.printStackTrace();
            System.out.println("...............................................................");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> removeBook(@PathVariable("id") int id )
    {
         try{
        this.bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e)
        {   System.out.println("...............................................................");
            e.printStackTrace();
            System.out.println("...............................................................");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> changeBook(@PathVariable("id") int id,@RequestBody Book book  )
    {
         
          try{
        this.bookService.updateBook(book, id);
        return ResponseEntity.ok().body(book);
        }
        catch(Exception e)
        {   System.out.println("...............................................................");
            e.printStackTrace();
            System.out.println("...............................................................");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
