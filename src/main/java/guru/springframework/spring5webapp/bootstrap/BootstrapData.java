package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book ericBook = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ericBook);
        ericBook.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ericBook);

        Author rod = new Author("Rod","Johnson");
        Book rodBook = new Book("J2EE Development without EJB","3939459495");
        rod.getBooks().add(rodBook);
        rodBook.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(rodBook);

        Publisher publisher = new Publisher("Altaya", "Main Street", "Miami", "FL", "33101");

        publisherRepository.save(publisher);

        System.out.println("Starting Bootstrap");
        System.out.println("Number of books : " + bookRepository.count());
        System.out.println("Number of publishers : " + publisherRepository.count());
    }
}
