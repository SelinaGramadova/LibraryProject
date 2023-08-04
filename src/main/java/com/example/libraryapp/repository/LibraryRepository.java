package com.example.libraryapp.repository;

import com.example.libraryapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LibraryRepository extends JpaRepository<Book, UUID> {

  @Query(value = "SELECT * FROM books WHERE name = :name", nativeQuery = true)
  public Optional<Book> findByBookName(@Param("name") String name);

  @Query(value = "SELECT * FROM books WHERE author = :author", nativeQuery = true)
  public List<Book> findByBookAuthor(@Param("author") String author);

  @Query(value = "SELECT * FROM books WHERE genre = :genre", nativeQuery = true)
  public List<Book> findByBookGenre(@Param("genre") String bookGenre);

}
