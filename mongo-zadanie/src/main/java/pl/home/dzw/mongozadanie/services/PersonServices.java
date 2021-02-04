package pl.home.dzw.mongozadanie.services;

import org.springframework.stereotype.Service;
import pl.home.dzw.mongozadanie.aop.TimeLog;
import pl.home.dzw.mongozadanie.csv.PersonCsvReader;
import pl.home.dzw.mongozadanie.model.Person;
import pl.home.dzw.mongozadanie.repositores.PersonRepo;

import java.util.List;

@Service
public class PersonServices implements PersonSave, PersonRead {

    private PersonRepo personRepo;
    private PersonCsvReader personCsvReader;

    public PersonServices(PersonRepo personRepo, PersonCsvReader personCsvReader) {
        this.personRepo = personRepo;
        this.personCsvReader = personCsvReader;
    }

    @TimeLog
    @Override
    public void save(List<Person> personList) {
        personList.stream().forEach(person -> personRepo.save(person));
    }

    @TimeLog
    @Override
    public void read() {
        personRepo.findAll();
    }


}
