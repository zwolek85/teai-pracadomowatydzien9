package pl.home.dzw.ormzadanie.services;

import org.springframework.stereotype.Service;
import pl.home.dzw.ormzadanie.aop.TimeLog;
import pl.home.dzw.ormzadanie.csv.PersonCsvReader;
import pl.home.dzw.ormzadanie.model.Person;
import pl.home.dzw.ormzadanie.repositores.PersonRepo;

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
