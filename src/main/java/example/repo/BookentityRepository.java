package example.repo;

import example.data.Bookentity;
import example.data.Enumstest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookentityRepository extends CrudRepository<Bookentity, Long> {
    List<Bookentity> findByTitle(String title);

    @Query("SELECT s FROM Bookentity s where s.id =  :id ")
    Bookentity findOne(Long id);

    @Query("SELECT s FROM Bookentity s")
    List<Bookentity> findAll();

    @Query("select cast(c.id as integer ) from Bookentity c ")
    Optional<Bookentity> findById(long id);


    @Query("select count(c) filter (where c.id  < 30) from Bookentity c ")
    Integer getCount(long id);

//==================================================================================================================

    //union
    @Query("select p.author from Bookentity p union select p.author from Bookentity p  ")
    Integer test_Union(long id);
    @Query("select p.author from Bookentity p union all select p.author from Bookentity p  ")
    Integer test_UnionAll(long id);

    //intersect
    @Query("select p.author from Bookentity p intersect select p.author from Bookentity p  ")
    Integer test_Intersect(long id);
    @Query("select p.author from Bookentity p intersect all select p.author from Bookentity p  ")
    Integer test_IntersectAll(long id);

    //except
    @Query("select p.author from Bookentity p except select p.author from Bookentity p  ")
    Integer test_except(long id);
    @Query("select p.author from Bookentity p except all select p.author from Bookentity p  ")
    Integer test_exceptAll(long id);
//=======================================================================================================================

    // TODO    it doesn't work - request leads to   Whitelabel Error Page
    //select new
    @Query("select new  example.repo.CallStatistics(	count(c) ) from Bookentity c  ")
    CallStatistics test_seelct_new();



    //select new map
    @Query("select new map(c.title  )  from Bookentity c" )
    List<Map> test_select_map( );



    //select new list
    @Query("select new list(c.id, c.author )  from Bookentity c")
    List<List> test_select_list( );


    //listagg
    @Query("select listagg(p.author, ', ') within group (order by p.id) from Bookentity p group by p.id")
    List<List> test_listagg( );


//=================================================================================================================
    // nulls first/last
    @Query("select p.id  from Bookentity p ORDER BY p.id desc NULLS FIRST")
    String test_nulls_first( );

    //=================================================================================================================
    // dates
    @Query("select sysdate() ")
    String test_date1( );

    @Query("select current_time()")
    String test_date2( );

    @Query("select day (current_date())")
    String test_date3( );

    @Query("select month ( current_date() )")
    String test_date4( );

    @Query("select year (current_timestamp())")
    String test_date5( );


    //TODO it doesn't suggest second, minute, hour for completion in queries: https://youtrack.jetbrains.com/issue/IDEA-304235

    @Query("select second(current_time())")
    String test_date6( );

    @Query("select minute(current_time())")
    String test_date7( );

    @Query("select hour(current_time())")
    String test_date8( );

//======================================================================================
// Hexadecimal literals
    @Query("select a from Bookentity a where a.id > 0X0001")
    List<List> test_Hexadecimal( );


    //======================================================================================
    // Enum literals
    @Query("SELECT o FROM Enumstest o WHERE o.type = 'LAND_LINE' OR o.type = 'MOBILE'")
    List<Enumstest> testEnums();
    @Query("SELECT o FROM Enumstest o WHERE o.type = LAND_LINE OR o.type = MOBILE")
    List<Enumstest> testEnums1();
    @Query("SELECT o FROM Enumstest o WHERE o.type IN ('LAND_LINE','MOBILE')")
    List<Enumstest> testEnums2();
    @Query("SELECT o FROM Enumstest o WHERE o.type IN (LAND_LINE,MOBILE)")
    List<Enumstest> testEnums3();

    //======================================================================================
    // Datetime arithmetic:  arithmetic operations

    //    "by unit" operator
    @Query("select (local date - p.vDate) by day  from DateTimeTypesTable p")
    List<Integer> testByUnitOperator();

    //======================================================================================
    // every() and any() aggregate functions

    @Query("select every(p.id < 1000 )    from Bookentity p")
    List<Boolean> testEvery();
    @Query("select any(p.id < 1000 )    from Bookentity p")
    List<Boolean> testAny();

    //======================================================================================

//    collate() function
    @Query("select collate(p.title as  SQL_TEXT_UCC)  from Bookentity p")
    List<String> testCollate();

//    format() function
    @Query("select  format(local datetime, 'YYYY-MM-DD') ")
    List<String> testFormat();

//    sql() function
    @Query("select a.id from Bookentity a order by sql('?', a.title) ")
    List<String> testSql();


    //======================================================================================

//    other functions
    @Query("select nullif(p.author, p.author)  from Bookentity p")
    List<String> test_nullif();
    @Query("select case when p.title = p.title then null else p.title	end from Bookentity p")
    List<String> test_case();
    @Query("select coalesce(p.title, '<no nick name>')  from Bookentity p")
    List<String> test_coalesce();
    @Query("select concat (p.title, ':', cast(p.id as string))  from  Bookentity p")
    List<String> test_concat();
    @Query("select substring(p.title, 1,2)  from Bookentity p")
    List<String> test_substring();
    @Query("select upper(p.title)  from Bookentity p")
    List<String> test_upper();
    @Query("select lower(p.title)  from Bookentity p")
    List<String> test_lower();
    @Query("select trim(leading ' ' from p.title)  from Bookentity p")
    List<String> test_trim();
    @Query("select length(p.title)  from Bookentity p")
    List<String> test_length();
    @Query("select locate('John',p.title)  from Bookentity p")
    List<String> test_locate();
    @Query("select abs(p.id)  from Bookentity p")
    List<String> test_abs();
    @Query("select mod(p.id, 10)  from Bookentity p")
    List<String> test_mod();
    @Query("select sqrt(p.id)  from Bookentity p")
    List<String> test_sqrt();
    @Query("select count(p.id)  from Bookentity p")
    List<String> test_count();
    @Query("select count(*)  from Bookentity p")
    List<String> test_count1();


    @Query("select sum(p.id)  from Bookentity p")
    List<String> test_sum();
    @Query("select min(p.id)  from Bookentity p")
    List<String> test_min();
    @Query("select max(p.id)  from Bookentity p")
    List<String> test_max();
    @Query("select avg (p.id)  from Bookentity p")
    List<String> test_avg();


    @Query("select every(p.id < 1000 )    from Bookentity p")
    List<String> test_every();
    @Query("select any(p.id < 1000 )    from Bookentity p")
    List<String> test_any();




    @Query("select cast(p.title as String)  from Bookentity p")
    List<String> test_cast();
    @Query("select extract(month from local date) ")
    List<String> test_extract();
    @Query("select a from  Bookentity a where a.id  in (1,2,3)")
    List<String> test_in();
    @Query("select exp(p.id)  from Bookentity p")
    List<String> test_exp();


    //        power(arg0, arg1)  returns arg0 value raised to the arg1  power.
    @Query("select power(p.id, 2)  from Bookentity p")
    List<String> test_power();

    //      floor(arg)  -  returns the largest integer less than or equal to the given value  arg.
    @Query("select floor(p.id)  from Bookentity p")
    List<String> test_floor();

    //     position (substr IN str)   - returns the position of a substring within a string
    @Query("select p from Bookentity p where position ('1' in p.title) = 0")
    List<String> test_position();

    //        OVERLAY ( <char value expr 1> PLACING <char value expr 2> FROM <start position> [ FOR <string length> ] [ USING CHARACTERS ] )
//       The character version of OVERLAY returns a character string based on <char value expr 1>
//       in which <string length> characters have been removed from the <start position> and in their place, the whole <char value expr 2> is copied.
    @Query("select overlay(p.title  PLACING  'TEST' from 7 FOR 1 )  from Bookentity p")
    List<String> test_overlay();


//=====================================================================================================================================================
//        a number of additional "standard" functions:

    //        left(string, length) - returns a character string from the left
    @Query("select left(p.title, 1)  from Bookentity p")
    List<String> test_left();
    //        right(string, length) - returns a character string from the right
    @Query("select right(p.title, 1)  from Bookentity p")
    List<String> test_right();
    //        replace(string, pattern, replacement)
    @Query("select replace(p.title, '1','4')  from Bookentity p")
    List<String> test_replace();


    //        log10(arg)
    @Query("select log10(p.id)  from Bookentity p")
    List<String> test_log10();
    //        sign(arg)
    @Query("select sign(p.id)  from Bookentity p")
    List<String> test_sign();
    //        sin(arg)
    @Query("select sin(p.id)  from Bookentity p")
    List<String> test_sin();
    //         cos(arg)
    @Query("select cos(p.id)  from Bookentity p")
    List<String> test_cos();
    //        asin(arg)
    @Query("select asin(p.id)  from Bookentity p")
    List<String> test_asin();
    //        acos(arg)
    @Query("select acos(p.id)  from Bookentity p")
    List<String> test_acos();
    //        tan(arg)
    @Query("select tan(p.id)  from Bookentity p")
    List<String> test_tan();
    //        atan(arg)
    @Query("select atan(p.id)  from Bookentity p")
    List<String> test_atan();
    //        atan2(arg0, arg1)
    @Query("select atan2(p.id, 1)  from Bookentity p")
    List<String> test_atan2();
    //        round(arg0, arg1)
    @Query("select round(p.id, 2)  from Bookentity p")
    List<String> test_round();
    //        least(arg0, arg1, ...)
    @Query("select least(p.id,3)  from Bookentity p")
    List<String> test_least();
    //        greatest(arg0, arg1, ...)
    @Query("select greatest(p.id, 3)  from Bookentity p")
    List<String> test_greatest();


    //str(arg) - synonym of cast(a as String)
    @Query("select str(p.title)  from Bookentity p")
    List<String> test_str();
    //        ifnull(arg0, arg1) - synonym of coalesce(a, b)      ,  COALESCE function returns the first non-NULL expression in the specified list.
    @Query("select ifnull(p.title, '2')  from Bookentity p")
    List<String> test_ifnull();

}
