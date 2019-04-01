package aula06.Ex2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsStorage implements ContactsStorageInterface {

    String file_name;
    FileType file_type;

    public ContactsStorage(String file_name, FileType file_type) {

        this.file_name = file_name;
        this.file_type = file_type;
    }

    @Override
    public List<Contact> loadContacts() {

        List<Contact> contacts_list = new ArrayList<>();
        readFile(contacts_list);

        return contacts_list;
    }

    @Override
    // returns false if there was an error reading the file
    public boolean saveContacts(List<Contact> list) {

        // save files that are not binary
        Path path = Paths.get(this.file_name);
        for (Contact contact : list) {
            try {
                Files.write(
                        path,
                        (contact.getNome() + "\t" + contact.getNumero()).getBytes()
                );
            } catch (IOException e) {
                return false;
            }
        }

        return true;
    }

    private void readFile(List<Contact> contacts_list){

        // read files that are not binary
        Path path = Paths.get(this.file_name);
        try {
            Files.lines(path).forEach(line -> {
                String[] line_contact = line.split("\t");

                // verify if line_contact[1] is a number
                assert isNumber(line_contact[1]);

                String name = line_contact[0];
                int number = Integer.parseInt(line_contact[1]);

                // add new contact
                contacts_list.add(new Contact(name, number));
            });
        } catch (IOException ex) {
            System.err.println("Error reading to file!");
        }
    }

    private boolean isNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
