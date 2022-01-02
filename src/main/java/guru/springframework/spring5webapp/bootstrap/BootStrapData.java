package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author erik = new Author("Erik", "Jung");
        Book spiegelreisende = new Book("Die Spiegelreisende", "123456");
        erik.getBooks().add(spiegelreisende);
        spiegelreisende.getAuthors().add(erik);

        authorRepository.save(erik);
        bookRepository.save(spiegelreisende);

        Author robin = new Author("Robin", "Sharma");
        Book fiveamclub = new Book("5 AM Club","12345");
        robin.getBooks().add(fiveamclub);
        fiveamclub.getAuthors().add(robin);

        authorRepository.save(robin);
        bookRepository.save(fiveamclub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}
