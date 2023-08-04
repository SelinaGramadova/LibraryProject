package com.example.libraryapp.service;

import com.example.libraryapp.controller.BookDTO;
import com.example.libraryapp.model.Book;
import com.example.libraryapp.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LibraryService {

  @Autowired
  LibraryRepository libaryRepository;
  public Book saveBook(BookDTO bookDTO) {
    Book book = new Book();
    book.setBookId(UUID.randomUUID());
    book.setBookName(bookDTO.getBookName());
    book.setBookAuthor(bookDTO.getBookAuthor());
    book.setGenre(bookDTO.getGenre());
    book.setReleaseDate(Instant.now());
    libaryRepository.save(book);
    return book;
  }

  public Book updateBook(BookDTO bookDTO) {
    Book registeredBook = libaryRepository.findByBookName(bookDTO.getBookName()).get();
    registeredBook.setBookName(bookDTO.getBookName());
    registeredBook.setBookAuthor(bookDTO.getBookAuthor());
    registeredBook.setGenre(bookDTO.getGenre());
    libaryRepository.save(registeredBook);
    return registeredBook;
  }

  public Book deleteBook(String bookName) {
    Optional<Book> bookToDelete = libaryRepository.findByBookName(bookName);
    if(bookToDelete.isPresent()){
      libaryRepository.deleteById(bookToDelete.get().getBookId());
    }
    return bookToDelete.get();
  }

  public List<Book> getBooksByGenre(String genre) {
    return libaryRepository.findByBookGenre(genre);
  }

  public List<Book> getBooksByAuthor(String authorName) {
    return libaryRepository.findByBookAuthor(authorName);
  }
}