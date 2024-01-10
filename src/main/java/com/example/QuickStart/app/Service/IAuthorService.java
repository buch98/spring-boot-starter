package com.example.QuickStart.app.Service;

import com.example.QuickStart.app.Entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {

    AuthorEntity createAuthor(AuthorEntity author);


    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findOne(Long id);

    boolean isExists(Long id);
}
