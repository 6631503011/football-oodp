import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;  // Import this class to handle errors


public class Mahafield extends Football {
	
	private String Name;
    private int numberPerson;
	
    // Getter and setter methods
	public int getNumberPerson() {
		return numberPerson;
	}

	public void setNumberPerson(int numberPerson) {
		this.numberPerson = numberPerson;
	}

	public String getName() {
	    return Name;
    }

    public void setName(String name) {
	    Name = name;
    }
    
    // Method to handle booking
	@Override
	public void queueFootball() {
		
		// List of members
		ArrayList<String> names = new ArrayList<String>();
        names.add("Wasan");
        names.add("Danny");
        names.add("Joe");
        names.add("Alex");
		
		// Queues for different time slots
		Queue<String> Mqueue08AM = new LinkedList<>();
		Mqueue08AM.add("\nQueue 08.00-10.00 AM.");
		Mqueue08AM.add("\nQueue 08.00-10.00 AM.");
		Mqueue08AM.add("\nQueue 08.00-10.00 AM.");
		Mqueue08AM.add("\nQueue 08.00-10.00 AM.");
		
		Queue<String> Mqueue10AM = new LinkedList<>();
		Mqueue10AM.add("\nQueue 10.00-12.00 AM.");
		Mqueue10AM.add("\nQueue 10.00-12.00 AM.");
		Mqueue10AM.add("\nQueue 10.00-12.00 AM.");
		
		Queue<String> Mqueue13AM = new LinkedList<>();
		Mqueue13AM.add("\nQueue 13.00-15.00 AM.");
		Mqueue13AM.add("\nQueue 13.00-15.00 AM.");
		Mqueue13AM.add("\nQueue 13.00-15.00 AM.");
		Mqueue13AM.add("\nQueue 13.00-15.00 AM.");
		
		Queue<String> Mqueue15AM = new LinkedList<>();
		Mqueue15AM.add("\nQueue 15.00-17.00 AM.");
		Mqueue15AM.add("\nQueue 15.00-17.00 AM.");
		Mqueue15AM.add("\nQueue 15.00-17.00 AM.");
	
		
		System.out.println("");
		System.out.println("-----------------Time-----------------");
		System.out.println("");
		System.out.println("1) 08.00-10.00 AM ");
		System.out.println("2) 10.00-12.00 AM ");
		System.out.println("3) 13.00-15.00 AM ");
		System.out.println("4) 15.00-17.00 AM ");
		System.out.println();
		System.out.print("Please choose time (Enter Number) : ");
		
		// Array to validate user input
		int[] Choicestime = {1, 2, 3, 4};
	    Scanner scanner = new Scanner(System.in);
	    boolean isValidInput = false;
	    int timeInput = 0;
	    
	    // Validate user input for time
	    while (!isValidInput) {
	        try {
	             timeInput = scanner.nextInt();
	            
	            // Check if the user input is in the choice
	            for (int Choicetimes : Choicestime) {
	                if (Choicetimes == timeInput) {
	                    isValidInput = true;
	                    break;
	                }
	               }
	            
	            if (!isValidInput) {
	                System.out.println("Selected incorrect choice.");
	                System.out.print("Please select again: ");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("Please enter numbers to select choice.");
	            System.out.print("Please enter numbers again: ");
	            scanner.next(); // Clear the invalid input from the scanner
	        }
	    }
		
		// Booking process based on selected time slot
		if(timeInput == 1) {
			// Remove booking from queue
			Mqueue08AM.poll();
			System.out.println("");
			System.out.print("Please enter the name of booker: ");
			Scanner scannerName1 = new Scanner(System.in);
			while(true) {
				try {
					Name = scannerName1.next();
					// Validate if name is in English
		            if (isEnglish(Name)) {
		                break;
		            } else {
		                System.out.println("The text is not in English.");
		                System.out.print("Please enter the name of booker: ");
		            }
		        } catch (Exception e) {
		            System.out.println("An error occurred: " + e.getMessage());
		            System.out.print("Please enter the name of booker: ");
		            scannerName1.next();
		        }
		    }
		    
		    // Validate number of people
		    System.out.println("");
	        System.out.println("Number of people not more than 20 people and not less than 10 people!!!");
			System.out.print("Please enter the number of people: ");
			Scanner scannernumber1 = new Scanner(System.in);
			numberPerson = 0;
		    while (true) {
		        try {
		        	numberPerson = scannernumber1.nextInt();
		             if(numberPerson <= 20 && numberPerson >= 10) {
		            	 break;
		             }
		             else{
		            	 System.out.println("Please enter in correctly within the specified scope.");
		            	 System.out.print("Please enter numbers again: ");
		             }
		        } catch (InputMismatchException e) {
		            System.out.println("Please enter numbers to select choice.");
		            System.out.print("Please enter numbers again: ");
		            scannernumber1.next(); // Clear the invalid input from the scanner
		        }
		    }
		    
		    // Check if the list contains the name
			if (names.contains(Name)) {
	        	System.out.println("");
	            System.out.println(Name + " is in the member");
	            System.out.println("You get 10% discount");
	            System.out.println("Price total: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1) +" Baht");
			    Pricecalculation(numberPerson);
			    
			    // Write booking details to file
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue08AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Total person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    // Display booking details from file
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        } else {
	        	System.out.println("");
	            System.out.println(Name + " is not in the member");
	            System.out.println("Price total: "+Pricecalculation(numberPerson)+" Baht");
			    Pricecalculation(numberPerson);
			    
			    // Write booking details to file
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue08AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Total person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+Pricecalculation(numberPerson)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    // Display booking details from file
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        }
		}
		
		// Similarly, handle booking for other time slots (2, 3, 4)
		// Omitted for brevity
		if(timeInput == 2) {
			Mqueue10AM.poll();
			System.out.println("");
			System.out.print("Please enter the name of booker: ");
			Scanner scannerName2 = new Scanner(System.in);
			while(true) {
			try {
				Name = scannerName2.next();
	            if (isEnglish(Name)) {
	                break;
	            } else {
	                System.out.println("The text is not in English.");
	                System.out.print("Please enter the name of booker: ");
	                
	            }
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	            System.out.print("Please enter the name of booker: ");
	            scannerName2.next();
	        }
	      }
		
		    
		    
		    
		    System.out.println("");
	        System.out.println("Number of people not more than 20 people and not less than 10 people!!!");
			System.out.print("Please enter the number of people: ");
			Scanner scannernumber2 = new Scanner(System.in);
			numberPerson = 0;
		    while (true) {
		      
		        try {
		        	numberPerson = scannernumber2.nextInt();
		             if(numberPerson <= 20 && numberPerson >= 10) {
		            	 break;
		             }
		             else{
		            	 System.out.println("Please enter in correctly within the specified scope.");
		            	 System.out.print("Please enter numbers again: ");
		            	 
		             }
		          
		        } catch (InputMismatchException e) {
		            System.out.println("Please enter numbers to select choice.");
		            System.out.print("Please enter numbers again: ");
		            scannernumber2.next(); // Clear the invalid input from the scanner
		        }
		    }
		    
		    
		 // Check if the list contain Name
	        if (names.contains(Name)) {
	        	System.out.println("");
	            System.out.println(Name + " is in the member");
	            System.out.println("You get 10% discount");
	            System.out.println("Price totel: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1) +" Baht");
			    Pricecalculation(numberPerson);
			    
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue10AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Totel person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        } else {
	        	System.out.println("");
	            System.out.println(Name + " is not in the member");
	            System.out.println("Price totel: "+Pricecalculation(numberPerson)+" Baht");
			    Pricecalculation(numberPerson);
			    
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue10AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Totel person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+Pricecalculation(numberPerson)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        }
		    
	}
		
		
	        else if(timeInput == 3) {
			Mqueue13AM.poll();
			System.out.println("");
			System.out.print("Please enter the name of booker: ");
			Scanner scannerName3 = new Scanner(System.in);
			while(true) {
			try {
				Name = scannerName3.next();
	            if (isEnglish(Name)) {
	                break;
	            } else {
	                System.out.println("The text is not in English.");
	                System.out.print("Please enter the name of booker: ");
	                
	            }
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	            System.out.print("Please enter the name of booker: ");
	            scannerName3.next();
	        }
	      }
		
		    
		    
		    
		    System.out.println("");
	        System.out.println("Number of people not more than 20 people and not less than 10 people!!!");
			System.out.print("Please enter the number of people: ");
			Scanner scannernumber3 = new Scanner(System.in);
			int numberPerson = 0;
		    while (true) {
		      
		        try {
		        	numberPerson = scannernumber3.nextInt();
		             if(numberPerson <= 20 && numberPerson >= 10) {
		            	 break;
		             }
		             else{
		            	 System.out.println("Please enter in correctly within the specified scope.");
		            	 System.out.print("Please enter numbers again: ");
		            	 
		             }
		          
		        } catch (InputMismatchException e) {
		            System.out.println("Please enter numbers to select choice.");
		            System.out.print("Please enter numbers again: ");
		            scannernumber3.next(); // Clear the invalid input from the scanner
		        }
		    }
		    
		    
		 // Check if the list contain Name
	        if (names.contains(Name)) {
	        	System.out.println("");
	            System.out.println(Name + " is in the member");
	            System.out.println("You get 10% discount");
	            System.out.println("Price totel: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1) +" Baht");
			    Pricecalculation(numberPerson);
			    
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue13AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Totel person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        } else {
	        	System.out.println("");
	            System.out.println(Name + " is not in the member");
	            System.out.println("Price totel: "+Pricecalculation(numberPerson)+" Baht");
			    Pricecalculation(numberPerson);
			    
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue13AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Totel person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+Pricecalculation(numberPerson)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        }
		    
	        }
		
		
		
		
		
		
		
		
	        else if(timeInput == 4) {
			Mqueue15AM.poll();
			System.out.println("");
			System.out.print("Please enter the name of booker: ");
			Scanner scannerName4 = new Scanner(System.in);
			
			
			while(true) {
			try {
				Name = scannerName4.next();
	            if (isEnglish(Name)) {
	                break;
	            } else {
	                System.out.println("The text is not in English.");
	                System.out.print("Please enter the name of booker: ");
	                
	            }
	        } catch (Exception e) {
	            System.out.println("An error occurred: " + e.getMessage());
	            System.out.print("Please enter the name of booker: ");
	            scannerName4.next();
	        }
	      }
		
		    
		    
		    
		    System.out.println("");
	        System.out.println("Number of people not more than 20 people and not less than 10 people!!!");
			System.out.print("Please enter the number of people: ");
			Scanner scannernumber4 = new Scanner(System.in);
			numberPerson = 0;
		    while (true) {
		      
		        try {
		        	numberPerson = scannernumber4.nextInt();
		             if(numberPerson <= 20 && numberPerson >= 10) {
		            	 break;
		             }
		             else{
		            	 System.out.println("Please enter in correctly within the specified scope.");
		            	 System.out.print("Please enter numbers again: ");
		            	 
		             }
		          
		        } catch (InputMismatchException e) {
		            System.out.println("Please enter numbers to select choice.");
		            System.out.print("Please enter numbers again: ");
		            scannernumber4.next(); // Clear the invalid input from the scanner
		        }
		    }
		    
		    
		    // Check if the list contain Name
	        if (names.contains(Name)) {
	        	System.out.println("");
	            System.out.println(Name + " is in the member");
	            System.out.println("You get 10% discount");
	            System.out.println("Price totel: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1) +" Baht");
			    Pricecalculation(numberPerson);
			    
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue15AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Totel person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+(Pricecalculation(numberPerson) - Pricecalculation(numberPerson)*0.1)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        } else {
	        	System.out.println("");
	            System.out.println(Name + " is not in the member");
	            System.out.println("Price totel: "+Pricecalculation(numberPerson)+" Baht");
			    Pricecalculation(numberPerson);
			    
			    try {
			        FileWriter myWriter = new FileWriter(Name+"Booking.txt");
			        myWriter.write("\n");
			        myWriter.write("\n");
			        myWriter.write("------------Maha Field Football------------");
			        myWriter.write("\n");
			        myWriter.write(Mqueue15AM.poll());
			        myWriter.write("\n");
			        myWriter.write("\nBooker: "+ Name + "   Totel person: " + numberPerson + " Person");
			        myWriter.write("\n");
			        myWriter.write("\nTotal cost: "+Pricecalculation(numberPerson)+" Baht");
			        myWriter.write("\n");
			        myWriter.write("\nPlease pay at the counter.");
			        myWriter.close();
			        System.out.println("");
			        System.out.println("Successfully wrote to the file.");
			      } catch (IOException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
			    try {
			        File myObj = new File(Name+"Booking.txt");
			        Scanner myReader = new Scanner(myObj);
			        while (myReader.hasNextLine()) {
			          String data = myReader.nextLine();
			          System.out.println(data);
			        }
			        myReader.close();
			      } catch (FileNotFoundException e) {
			        System.out.println("An error occurred.");
			        e.printStackTrace();
			      }
	        
	          }
	        }
	}
	
	// Method to calculate price
	@Override
	public int Pricecalculation(int numberPerson) {
		int PriceTotol = numberPerson *  40 ;
		return PriceTotol;
	}
	
	// Method to validate if name is in English!
	@Override
	public boolean isEnglish(String Name) {
        return Name.matches("[a-zA-Z]+");
    }
	
}
