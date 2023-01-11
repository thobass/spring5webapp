package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorRestController {

    private final AuthorRepository authorRepository;

    public AuthorRestController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping(value="", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateAuthor(@RequestBody Author author){
        Author auth = authorRepository.findById(author.getId()).get();
        auth.setFirstName(author.getFirstName());
        auth.setLastName(author.getLastName());
        authorRepository.save(auth);
    }
}
