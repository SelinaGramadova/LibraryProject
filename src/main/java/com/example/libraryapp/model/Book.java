package com.example.libraryapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Entity
public class Book {
  @Id
  @Column(name = "book_id")
  private UUID bookId;
  @Column(name="name")
  private String bookName;
  @Column(name="author")
  private String bookAuthor;
  @Column(name="genre")
  private String genre;
  @Column(name="release_date")
  private Instant releaseDate;

  @ManyToOne
  @JoinColumn(name="reader_id", nullable=false)
  private Reader reader;
}
