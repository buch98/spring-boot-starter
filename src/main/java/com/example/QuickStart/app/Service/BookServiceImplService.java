package com.example.QuickStart.app.Service;

import com.example.QuickStart.app.Entity.BookEntity;
import com.example.QuickStart.app.Repository.IBookRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImplService implements IBookService {

    private IBookRepo iBookRepo;

    public BookServiceImplService(IBookRepo iBookRepo) {
        this.iBookRepo = iBookRepo;
    }

    @Override
    public BookEntity createBook(BookEntity book,String isbn) {
        book.setIsbn(isbn);
        return iBookRepo.save(book);

    }

    @Override
    public List<BookEntity> findAll() {
        return StreamSupport.stream(iBookRepo.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Page<BookEntity> findAll(Pageable pageable){
        return iBookRepo.findAll(pageable);
    }

    @Override
    public Optional<BookEntity> findOne(String isbn) {
        return iBookRepo.findById(isbn);
    }

    @Override
    public boolean isExists(String isbn) {
        return iBookRepo.existsById(isbn);
    }
}
