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

        Contact Amanda = new Contact("Amanda", "5555555");
        Contact Levi = new Contact("Levi", "2222222");


        Amanda.printContact();
        Levi.printContact();


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
    }
}
