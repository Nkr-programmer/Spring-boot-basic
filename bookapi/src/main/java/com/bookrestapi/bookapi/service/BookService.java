package com.bookrestapi.bookapi.service;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookrestapi.bookapi.dao.BookRepository;
import com.bookrestapi.bookapi.entities.Book;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository ;

    // for all get
    public List<Book> getAllBooks(){
    List<Book> list= (List<Book>)bookRepository.findAll();
        return list;
    }
    //for single get
    public Book getBook(int id){ 
        Book book=bookRepository.findById(id);
        return book;
    //    return list.stream().filter(e->e.getId()==id).findFirst().get();
    } 
    //create a new
    public Book addBook(Book book){ 
        Book b= bookRepository.save(book);
        return b;        
        //list.add(book); 
        //return book;
    } 
    //delete a book
    public void deleteBook(int id){ 
        bookRepository.deleteById(id);
        //list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
    } 
    //update a book
    public void updateBook(Book book,int id){ 
    book.setId(id);
    bookRepository.save(book);
        //list=list.stream().map(e->e.getId()==id?book:e).collect(Collectors.toList());
    } 
}
