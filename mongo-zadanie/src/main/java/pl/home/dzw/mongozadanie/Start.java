package pl.home.dzw.mongozadanie;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.home.dzw.mongozadanie.csv.PersonCsvReader;
import pl.home.dzw.mongozadanie.model.Person;
import pl.home.dzw.mongozadanie.services.PersonRead;
import pl.home.dzw.mongozadanie.services.PersonSave;

import java.util.List;

@Component
public class Start {

    private PersonSave personSave;
    private PersonRead personRead;

    private PersonCsvReader personCsvReader;

    public Start(PersonSave personSave, PersonRead personRead, PersonCsvReader personCsvReader) {
        this.personSave = personSave;
        this.personRead = personRead;
        this.personCsvReader = personCsvReader;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        List<Person> people = personCsvReader.readPersonCsv();
        personSave.save(people);
        personRead.read();
    }
}
