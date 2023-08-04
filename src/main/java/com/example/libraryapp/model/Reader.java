package com.example.libraryapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "readers")
@Entity
public class Reader {
  @Id
  @Column(name = "reader_id")
  private UUID readerId;
  @Column(name="first_name")
  private String readerFirstName;
  @Column(name="last_name")
  private String readerLastName;

  @OneToMany(mappedBy="readers")
  private Set<Book> borrowedBooks;

}