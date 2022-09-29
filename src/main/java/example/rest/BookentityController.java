package example.rest;

import example.data.Bookentity;
import example.repo.BookentityRepository;
import example.exceptions.BookentityIdMismatchException;
import example.exceptions.BookentityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//  MyAppName
//  http://localhost:9092/api/books
@RestController
@RequestMapping("/api/books")
public class BookentityController {
    @Autowired
    private BookentityRepository bookentityRepository;

    @GetMapping
    public Iterable findAll() {
        return bookentityRepository.findAll();
    }

    //      http://localhost:9092/api/books/title/2TITLE
    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookentityRepository.findByTitle(bookTitle);
    }



// TODO   Hibernate6 "filter" function:   http://localhost:9092/api/books/filter/3,  works OK
    @GetMapping("/filter/{id}")
    public Integer testFilter(@PathVariable Long id) {
        return bookentityRepository.getCount( id);
    }


    @GetMapping("/{id}")
    public Bookentity findOne(@PathVariable Long id) {
        Bookentity bookentity = bookentityRepository.findOne(id);
        if (bookentity == null)
            throw new BookentityNotFoundException("Error BookentityNotFoundException");
        return bookentity;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bookentity
    create(@RequestBody Bookentity bookentity) {
        return bookentityRepository.save(bookentity);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Bookentity bookentity = bookentityRepository.findOne(id);
        if (bookentity == null)
            throw new BookentityNotFoundException("Error BookentityNotFoundException");
        bookentityRepository.delete(bookentity);
    }

    @PutMapping("/{id}")
    public Bookentity updateBookentity(@RequestBody Bookentity bookentity, @PathVariable Long id) {
        if (bookentity.getId() != id) {
            try {
                throw new BookentityIdMismatchException("Error BookentityIdMismatchException" );
            } catch (BookentityIdMismatchException e) {
                e.printStackTrace();
            }
        }
        Bookentity old = bookentityRepository.findOne(id);
        if (old == null) {
            throw new BookentityNotFoundException("Error BookentityNotFoundException");
        }
        return bookentityRepository.save(bookentity);
    }
}
