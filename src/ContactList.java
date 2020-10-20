import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContactList {

    // Create a HashMap with names as the key, and contact objects as values
    private HashMap<String, Contact> contactList = new HashMap<>();

    public ContactList(Contact...contacts){
        for (Contact contact: contacts){
            addContact(contact);
        }
    }

    public void addContact(Contact newContact){
        contactList.put(newContact.getName(), newContact);
    }

    public Contact getContactFromName(String contactName){
        // TODO handle invalid name error
//        if (contactList.containsKey(contactName)){
            return contactList.get(contactName);
//        } else {
//            System.err.println("Contact name is invalid");
////            return getContactFromName(contactName);
//        }
    }

    public void delContact(Contact rmContact){
        if (contactList.containsKey(rmContact.getName())){
            contactList.remove(rmContact.getName());
        } else {
            System.err.printf("%s is not a valid contact", rmContact.getName());
        }
    }

    public void printContactMap(){
        // %-15s = 15 character columns, - is left justified
        System.out.println();
        System.out.printf("%-15s | %-15s%n", "Name", "Phone" );
        System.out.println("---------------------------------");
        for (String key : contactList.keySet()){
            System.out.printf("%-15s | %-15s%n", key, contactList.get(key).getPhoneNumber());
        }
        System.out.println("---------------------------------");
        System.out.println();
    }

    // The Files.Write method takes a List<String> in order to populate a file, so we need a list of Contact Strings
    public List<String> exportMapToList(){
        List<String> exportList = new ArrayList<>();
        for (String key : contactList.keySet()){
            String contactString = key + " | " + contactList.get(key).getPhoneNumber();
            exportList.add(contactString);
        }
        return exportList;
    }
}
