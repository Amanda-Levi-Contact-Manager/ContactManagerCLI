public class ContactApp {
    public static void main(String[] args) {
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
    }
}
