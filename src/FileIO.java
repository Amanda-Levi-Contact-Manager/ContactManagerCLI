import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static Path createDirectoryAndFile(String dirName, String fileName) throws IOException {

        Path dataDirectoryPath = Paths.get(dirName);
        Path dataFilePath = Paths.get(dirName, fileName);

        if (Files.notExists(dataDirectoryPath)) {
            Files.createDirectories(dataDirectoryPath);
        }

        if (! Files.exists(dataFilePath)) {
            Files.createFile(dataFilePath);
        }

        return dataFilePath;
    }

    public static List<Contact> importContactFile(Path contactFilePath) throws IOException {
        List<Contact> formattedContactList = new ArrayList<>();
        List<String> rawContactList = Files.readAllLines(contactFilePath);
        for (int i = 0; i < rawContactList.size(); i++) {

            String rawInputString = rawContactList.get(i);

            String contactName = rawInputString.substring(0, rawInputString.indexOf('|')).trim();

            String phoneNumber = rawInputString.substring(rawInputString.indexOf('|') + 1).trim();

            Contact newContact = new Contact(contactName, phoneNumber);
            formattedContactList.add(newContact);
        }
        return formattedContactList;
    }

}
