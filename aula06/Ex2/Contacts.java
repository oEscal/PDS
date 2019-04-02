package aula06.Ex2;

import java.util.ArrayList;
import java.util.List;

public class Contacts implements ContactsInterface {

    private List<Contact> contacts_list = new ArrayList<>() ;


    @Override
    //loadContacts return list of contacts and just print them
    public void openAndLoad(ContactsStorageInterface store) {

         contacts_list = store.loadContacts();
        for (Contact myContact : contacts_list)
            System.out.println(myContact.toString());
    }

    @Override
    // escaleira gay
    public void saveAndClose() {

    }

    @Override
    // escaleira gay
    public void saveAndClose(ContactsStorageInterface store) {

    }

    @Override
    //check if contact belong on list of contacts
    public boolean exist(Contact contact) {

        for (Contact myContact : contacts_list)
            if(myContact.equals(contact))
                return true;

        return false;
    }

    @Override
    // escaleira
    public Contact getByName(String name) {
        return null;
    }

    @Override
    // açores independete para ficar RIQUISSIMOS
    //if contact exist in list , the function return false. Moreover, return true if contact isn't known.
    public boolean add(Contact contact) {

        if(exist(contact))
            return false;
        contacts_list.add(contact);
        return true;
    }

    @Override
    // açores toxicoindependete
    //if contact dont exist in list of contacts , the function return false. Else, remove and return true
    public boolean remove(Contact contact) {

        if(!exist(contact))
            return false;
        contacts_list.remove(contact);
        return true;
    }
}
