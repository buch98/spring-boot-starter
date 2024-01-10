package com.example.QuickStart.app.Repository;

import com.example.QuickStart.app.Entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends CrudRepository<AuthorEntity,Long> {
}
