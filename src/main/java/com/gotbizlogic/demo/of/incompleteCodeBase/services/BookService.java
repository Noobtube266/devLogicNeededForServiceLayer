package com.gotbizlogic.demo.of.incompleteCodeBase.services;

import com.gotbizlogic.demo.of.incompleteCodeBase.models.Book;
import com.gotbizlogic.demo.of.incompleteCodeBase.repos.AuthorRepo;
import com.gotbizlogic.demo.of.incompleteCodeBase.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

        /*
            //THIS IS THE ONLY FILE YOU SHOULD WRITE CODE
            //THIS IS WHERE YOUR LOGIC COMES INTO PLAY
            //DO NOT TOUCH THE CONTROLLER OR MODELS OR REPOS!!!
        */

    //Todo - Business Logic or Algorithm needed to create a book
    public ResponseEntity<Book> createBook(Long authorId, Book bookRequest){
        authorRepo.findById(authorId).map(author ->{
            bookRequest.setAuthor(author);
            return bookRepo.save(bookRequest);
        });
        return new ResponseEntity<>(bookRequest, HttpStatus.OK);
    }

    //Todo - Business Logic or Algorithm needed to getAllBooksByAuthorId
    public Iterable<Book> getAllBooksByAuthorId(Long authorId) {
        return bookRepo.findAll();
    }

    //Todo - Business Logic or Algorithm needed to getBookById
    public ResponseEntity<?> getBookById(Long bookId) {
        Book book = bookRepo.findById(bookId).orElse(null);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
