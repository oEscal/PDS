package aula06.Ex2;

public class Contacts implements ContactsInterface {


    @Override
    // açores
    public void openAndLoad(ContactsStorageInterface store) {

    }

    @Override
    // escaleira
    public void saveAndClose() {

    }

    @Override
    // escaleira
    public void saveAndClose(ContactsStorageInterface store) {

    }

    @Override
    // madeira > açores
    public boolean exist(Contact contact) {
        return false;
    }

    @Override
    // escaleira
    public Contact getByName(String name) {
        return null;
    }

    @Override
    // açores independete
    public boolean add(Contact contact) {
        return false;
    }

    @Override
    // açores independete
    public boolean remove(Contact contact) {
        return false;
    }
}
