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


    //union
    @Query("select p.author from Bookentity p union select p.author from Bookentity p  ")
    Integer test_Union(long id);

    //intersect
    @Query("select p.author from Bookentity p intersect select p.author from Bookentity p  ")
    Integer test_Intersect(long id);

    //except
    @Query("select p.author from Bookentity p except select p.author from Bookentity p  ")
    Integer test_except(long id);
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



}
