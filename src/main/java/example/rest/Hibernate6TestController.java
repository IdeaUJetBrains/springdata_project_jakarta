package example.rest;

import example.data.Bookentity;
import example.exceptions.BookentityIdMismatchException;
import example.exceptions.BookentityNotFoundException;
import example.repo.BookentityRepository;
import example.repo.CallStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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




    // TODO    it doesn't work  - request leads to   Whitelabel Error Page
    //    http://localhost:9092/h6/test_seelct_new
    @GetMapping("/test_seelct_new")
    public CallStatistics test_seelct_new( ) {
        return bookentityRepository.test_seelct_new( );
    }



//  localhost:9092/h6/test_select_map
    @GetMapping("/test_select_map ")
    public List<Map> test_select_map( ) {
        return bookentityRepository.test_select_map(  );
    }


//  localhost:9092/h6/test_select_list
    @GetMapping("/test_select_list")
    public List<List> test_select_list() {
        return bookentityRepository.test_select_list( );
    }


//  localhost:9092/h6/test_select_list
    @GetMapping("/test_listagg")
    public  List<List> test_listagg( ) {
        return bookentityRepository.test_listagg( );
    }

//    =========================================================================

    @GetMapping("/date1")
    public  String test_date1( ) {
        return bookentityRepository.test_date1();
    }
    @GetMapping("/date2")
    public  String test_date2( ) {
        return bookentityRepository.test_date2();
    }
    @GetMapping("/date3")
    public  String test_date3( ) {
        return bookentityRepository.test_date3();
    }
    @GetMapping("/date4")
    public  String test_date4( ) {
        return bookentityRepository.test_date4();
    }
    @GetMapping("/date5")
    public  String test_date5( ) {
        return bookentityRepository.test_date5();
    }
    @GetMapping("/date6")
    public  String test_date6( ) {
        return bookentityRepository.test_date6();
    }
    @GetMapping("/date7")
    public  String test_date7( ) {
        return bookentityRepository.test_date7();
    }
    @GetMapping("/date8")
    public  String test_date8( ) {
        return bookentityRepository.test_date8();
    }

//======================================================================================
// Hexadecimal literals
@GetMapping("/hexadecimal")
public  List<List> test_Hexadecimal( ) {
    return bookentityRepository.test_Hexadecimal();
}


//======================================================================================
// Datetime arithmetic:  arithmetic operations
    @GetMapping("/byunit")
    public  List<Integer> testByUnitOperator( ) {
        return bookentityRepository.testByUnitOperator();
    }

//======================================================================================
// every() and any() aggregate functions
    @GetMapping("/every")
    public  List<Boolean> testEvery( ) {
        return bookentityRepository.testEvery();
    }
    @GetMapping("/any")
    public  List<Boolean> testAny( ) {
        return bookentityRepository.testAny();
    }

    //======================================================================================

    //    collate() function
    @GetMapping("/collate")
    public  List<String> testCollate( ) {
        return bookentityRepository.testCollate();
    }


    //    format() function
    @GetMapping("/format")
    public  List<String> testFormat( ) {
        return bookentityRepository.testFormat();
    }


    //    sql() function
    @GetMapping("/sql")
    public  List<String> testSql( ) {
        return bookentityRepository.testSql();
    }


}
