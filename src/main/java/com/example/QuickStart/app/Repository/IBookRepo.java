package com.example.QuickStart.app.Repository;

import com.example.QuickStart.app.Entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends CrudRepository<BookEntity,String>,
        PagingAndSortingRepository<BookEntity,String> {
}
