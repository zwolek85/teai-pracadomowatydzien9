package pl.home.dzw.ormzadanie.services;

import pl.home.dzw.ormzadanie.model.Person;

import java.util.List;

public interface PersonSave {
    void save(List<Person> personList);
}
