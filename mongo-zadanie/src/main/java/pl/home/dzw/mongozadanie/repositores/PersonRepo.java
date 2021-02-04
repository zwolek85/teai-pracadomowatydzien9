package pl.home.dzw.mongozadanie.repositores;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.home.dzw.mongozadanie.model.Person;

@Repository
public interface PersonRepo extends MongoRepository<Person, String> {

}
