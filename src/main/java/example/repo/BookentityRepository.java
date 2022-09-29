package example.repo;

import example.data.Bookentity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
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
}
