package com.example.QuickStart.app.Controller;

import com.example.QuickStart.app.Entity.AuthorEntity;
import com.example.QuickStart.app.Service.IAuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    private IAuthorService iAuthorService;

    public AuthorController(IAuthorService iAuthorService){
        this.iAuthorService = iAuthorService;
    }

    @PostMapping(path="/authors")
    public ResponseEntity<AuthorEntity> createAuthor(@RequestBody AuthorEntity author){
        return new ResponseEntity<>(iAuthorService.createAuthor(author), HttpStatus.CREATED);
    }

    @GetMapping(path="/authors")
    public List<AuthorEntity> getAuthors(){
        return iAuthorService.findAll();

    }

    @GetMapping(path = "/author/{id}")
    public ResponseEntity<AuthorEntity> getAuthor(@PathVariable("id") Long id){
        Optional<AuthorEntity> author = iAuthorService.findOne(id);
        return author.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "authors/{id}")
    public ResponseEntity<AuthorEntity> fullUpdateAuthor(@PathVariable("id") Long id, @RequestBody AuthorEntity author)
    {
        if(!iAuthorService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        author.setId(id);
        return new ResponseEntity<>(iAuthorService.createAuthor(author),HttpStatus.OK);

    }
}
