package com.example.libraryapp.controller;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;

@Value
@Getter
@Setter
@ToString
public class BookDTO {

  private String bookName;
  private String bookAuthor;
  private String genre;
}
