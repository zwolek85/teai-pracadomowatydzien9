package pl.home.dzw.mongozadanie.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.home.dzw.mongozadanie.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonCsvReader {

    private final String[] HEADERS = {"first_name", "last_name", "email", "gender", "ip_address"};

    public List<Person> readPersonCsv() {
        List<Person> result = new ArrayList<>();
        Reader in = null;
        try {
            File file = new File("src/main/resources/csv_file/PERSON_DATA.csv");
            in = new FileReader(file);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader(HEADERS)
                    .withFirstRecordAsHeader()
                    .parse(in);
            for (CSVRecord record : records) {
                String firstName = record.get("first_name");
                String lastName = record.get("last_name");
                String email = record.get("email");
                String gender = record.get("gender");
                String ipAddress = record.get("ip_address");
                result.add(new Person(firstName, lastName, email, gender, ipAddress));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
