package example.rest;

import example.data.Bookentity;
import example.exceptions.BookentityIdMismatchException;
import example.exceptions.BookentityNotFoundException;
import example.repo.BookentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//  MyAppName
//  http://localhost:9092/h6
@RestController
@RequestMapping("/h6")
public class Hibernate6TestController {
    @Autowired
    private BookentityRepository bookentityRepository;
    @GetMapping
    public Iterable findAll() {
        return bookentityRepository.findAll();
    }


// =============================================================================================================
// TODO   Hibernate6 "filter" function:   http://localhost:9092/h6/filter/3,  works OK
// =============================================================================================================
    @GetMapping("/filter/{id}")
    public Integer testFilter(@PathVariable Long id) {
        return bookentityRepository.getCount( id);
    }


}
