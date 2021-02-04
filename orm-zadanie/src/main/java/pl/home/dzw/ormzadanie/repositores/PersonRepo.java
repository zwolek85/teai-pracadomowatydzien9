package pl.home.dzw.ormzadanie.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.home.dzw.ormzadanie.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

}
