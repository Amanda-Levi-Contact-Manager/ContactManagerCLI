import java.util.Scanner;

public class Input {
    private final Scanner inputScan;

    public Input() {
        this.inputScan = new Scanner(System.in);
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return this.inputScan.nextLine();
    }

    public int getInt(String prompt){
        int userInput;
        try {
            String userChoice = this.getString(prompt);
            userInput = Integer.parseInt(userChoice);
        }
        catch (NumberFormatException e) {
            System.err.println("Please enter a valid selection number.");
            return getInt(prompt);
        }
        if (1 <= userInput && userInput <= 5)
            return userInput;
        else {
            return getInt(prompt);
        }
    }
}