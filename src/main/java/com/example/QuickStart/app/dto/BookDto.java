package com.example.QuickStart.app.dto;


import com.example.QuickStart.app.Entity.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private String isbn;
    private String title;
    private AuthorEntity author;

}
