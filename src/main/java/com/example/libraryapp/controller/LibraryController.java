package com.example.libraryapp.controller;


import com.example.libraryapp.model.Book;
import com.example.libraryapp.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/library")
public class LibraryController {

  @Autowired
  LibraryService libraryService;

  @GetMapping("/genre")
  public List<Book> getBooksByGenre(@RequestParam String genre){
    return libraryService.getBooksByGenre(genre);
  }

  @GetMapping ("/author")
  public List<Book> getBooksByAuthor(@RequestParam String authorName){
    return libraryService.getBooksByAuthor(authorName);
  }

  @PostMapping ("/books")
  public ResponseEntity<Book> saveBook(@RequestBody BookDTO bookDTO){
    return ResponseEntity.ok(libraryService.saveBook(bookDTO));
  }

  @PutMapping("/books/update")
  public Book updateBook(@RequestBody BookDTO bookDTO){
    return libraryService.updateBook(bookDTO);
  }

  @DeleteMapping("/books/{book}")
  public Book deleteBook(@PathVariable String book){
    return libraryService.deleteBook(book);

  }

}
