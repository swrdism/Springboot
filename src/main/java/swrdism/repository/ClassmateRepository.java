package swrdism.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import swrdism.Classmate;

import java.util.List;



public interface ClassmateRepository extends CrudRepository<Classmate,Integer>{
//    List<Classmate> findByNames(String name);
//    List<Classmate> findByNames(String name, Sort sort);
}
