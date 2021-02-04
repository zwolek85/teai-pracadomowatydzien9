package pl.home.dzw.mongozadanie.services;

import pl.home.dzw.mongozadanie.model.Person;

import java.util.List;

public interface PersonSave {
    void save(List<Person> personList);
}
