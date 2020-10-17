import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.write;

public class ContactApp {


    public static void main(String[] args) throws IOException {
        // Directory for contact output

        // Methods for
        // Printing/Viewing, adding, searching, and updating/deleting a contact.
        // Hashmap <Name, contactObj or PhoneNumber>

        // Create contact objects for testing
        Contact Amanda = new Contact("Amanda", "5555555");
        Contact Levi = new Contact("Levi", "2222222");
        Contact David = new Contact("David", "8675309");

        // Create our list HashMap with our contact objects
        ContactList list = new ContactList(Amanda, Levi);

        // See our output using 2 contacts
        list.printContactMap();

        // Add a 3rd contact
        list.addContact(David);

        // Print again
        list.printContactMap();

        // Remove David
        list.delContact(David);

        // Print one last time
        list.printContactMap();

        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        //printing to contacts.txt
        List<String> contactList = Arrays.asList("name1", "name2", "bacon");
        Files.write(dataFile, contactList);

        //printing to console
        List<String> fileContents = Files.readAllLines(dataFile);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, fileContents.get(i));
        }
    printMenu();
    }

    public static void printMenu(){
        System.out.println("1. View contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
    }
}

