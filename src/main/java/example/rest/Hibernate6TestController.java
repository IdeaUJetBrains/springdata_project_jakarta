package example.rest;

import example.data.Bookentity;
import example.exceptions.BookentityIdMismatchException;
import example.exceptions.BookentityNotFoundException;
import example.repo.BookentityRepository;
import example.repo.CallStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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




    // TODO    it doesn't work, run fails
    //    http://localhost:9092/h6/test_seelct_new
//    @GetMapping("/test_seelct_new")
//    public String test_seelct_new( ) {
//        return bookentityRepository.test_seelct_new( ).toString();
//    }


    // TODO    it doesn't work - request leads to   Whitelabel Error Page
    //    http://localhost:9092/h6/test_select_map
    @GetMapping("/test_select_map ")
    public List<Map> test_select_map( ) {
        return bookentityRepository.test_select_map(  );
    }


//    http://localhost:9092/h6/test_select_list
    @GetMapping("/test_select_list")
    public List<List> test_select_list() {
        return bookentityRepository.test_select_list( );
    }


//    http://localhost:9092/h6/test_listagg/
    @GetMapping("/test_listagg")
    public  List<List> test_listagg( ) {
        return bookentityRepository.test_listagg( );
    }


}
