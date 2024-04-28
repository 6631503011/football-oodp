import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
public static void main(String[] arg) {
    
	while(true) {
	Football football = new Football();
	Football Yuifield = new Yuifield();
	Football Mahafield = new Mahafield();
	Football Totofield = new Totofield();
    
	System.out.println();
	System.out.println("--------Football field---------");
	System.out.println();
	System.out.println("1.Yui football field");
	System.out.println("2.Toto football field");
	System.out.println("3.Maha football field");
	System.out.println();
	System.out.print("Plase choose football field (Enter Number): ");

	
	//Check input
	int[] Choices = {1, 2, 3};
    Scanner scanner = new Scanner(System.in);
    boolean isValidInput = false;
    int userInput = 0;
    
    while (!isValidInput) {
      
        try {
             userInput = scanner.nextInt();
            
            // Check if the user input is in the choice
            for (int Choice : Choices) {
                if (Choice == userInput) {
                    isValidInput = true;
                    break;
                }
               }
            
            if (!isValidInput) {
                System.out.println("Selected incorrect choice.");
                System.out.println("Please select again: ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter numbers to select choice.");
            scanner.next(); // Clear the invalid input from the scanner
        }
    }
    
    
    if(userInput == 1) {
    	Yuifield.queueFootball();
    	
    }
    else if(userInput == 2) {
    	Totofield.queueFootball();
    }
    else if(userInput == 3) {
    	Mahafield.queueFootball();
    }
    
	}
 }
}

