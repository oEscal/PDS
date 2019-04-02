package aula06.Ex2;

public class Test {

    public static void main(String[] args){

        Contacts list_contacts = new Contacts();
        list_contacts.openAndLoad(new ContactsStorage("contacts", FileType.bin));

        list_contacts.add(new Contact("Best mae", 9174234));
        list_contacts.add(new Contact("Escaleira", 911));
        list_contacts.add(new Contact("Escaleira", 910));
        list_contacts.add(new Contact("Baião", 933));

        Contact mae = list_contacts.getByName("Best mae");
        System.out.println(list_contacts.exist(mae));
        list_contacts.remove(mae);
        System.out.println(list_contacts.exist(mae));
        System.out.println(list_contacts.getByName("Best mae"));

        list_contacts.saveAndClose(new ContactsStorage("contacts", FileType.bin));
    }

}
