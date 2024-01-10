package com.example.QuickStart.app.Service;

import com.example.QuickStart.app.Entity.AuthorEntity;
import com.example.QuickStart.app.Repository.IAuthorRepo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImplService implements IAuthorService {

    private IAuthorRepo iAuthorRepo;

    public AuthorServiceImplService(IAuthorRepo iAuthorRepo) {
        this.iAuthorRepo = iAuthorRepo;
    }

    @Override
    public AuthorEntity createAuthor(AuthorEntity author) {
        return iAuthorRepo.save(author);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(iAuthorRepo.findAll().spliterator(),false).collect(Collectors.toList());

    }

    @Override
    public Optional<AuthorEntity> findOne(Long id) {
        return iAuthorRepo.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return iAuthorRepo.existsById(id);
    }
}
