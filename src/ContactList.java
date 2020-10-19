import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContactList {

    // After further testing, wasn't sure we needed an actual arrayList
    // Decided to simplify and just use a HashMap with names as the key, and contact objects as values
    private HashMap<String, Contact> contactList = new HashMap<>();
//    private List<String> exportList = Arrays.asList();

    public ContactList(Contact...contacts){
        for (Contact contact: contacts){
            addContact(contact);
        }
    }

    public void addContact(Contact newContact){
        contactList.put(newContact.getName(), newContact);
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
        System.out.printf("%-15s | %-15s%n", "Name", "Phone" );
        System.out.println("---------------------------------");
        for (String key : contactList.keySet()){
            System.out.printf("%-15s | %-15s%n", key, contactList.get(key).getPhoneNumber());
        }
        System.out.println("---------------------------------");
        System.out.println();
    }

    public List<String> exportMapToList(){
        List<String> exportList = new ArrayList<>();
        for (String key : contactList.keySet()){
//            System.out.printf("%-15s | %-15s%n", key, contactList.get(key).getPhoneNumber());
            String contactString = key + " | " + contactList.get(key).getPhoneNumber();
            exportList.add(contactString);
        }
        return exportList;
    }
}
