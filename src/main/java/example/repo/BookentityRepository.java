package example.repo;

import example.data.Bookentity;
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


    //TODO it doesn't suggest second, minute, hour for completion in queries:
    @Query("select second(current_time())")
    String test_date6( );

    @Query("select minute(current_time())")
    String test_date7( );

    @Query("select hour(current_time())")
    String test_date8( );






}
