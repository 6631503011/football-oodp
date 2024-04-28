import java.util.LinkedList;
import java.util.Queue;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Football {

	private int numberPerson;
	private int Price;
    private String Name;
	
	public String getName() {
		return Name;
	}




	public void setName(String name) {
		Name = name;
	}


	

	public int getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}

	
	public int getNumberPerson() {
		return numberPerson;
	}


	public void setNumberPerson(int numberPerson) {
		this.numberPerson = numberPerson;
	}
	

	public void queueFootball() {
		
		Queue<String> queue08AM = new LinkedList<>();
		queue08AM.add("\nQueue 8.00-10.00 AM.");
		queue08AM.add("\nQueue 8.00-10.00 AM.");
		queue08AM.add("\nQueue 8.00-10.00 AM.");
		queue08AM.add("\nQueue 8.00-10.00 AM.");
		
		Queue<String> queue10AM = new LinkedList<>();
		queue10AM.add("\nQueue 10.00-12.00 AM.");
		queue10AM.add("\nQueue 10.00-12.00 AM.");
		queue10AM.add("\nQueue 10.00-12.00 AM.");
		queue10AM.add("\nQueue 10.00-12.00 AM.");
		
		Queue<String> queue13AM = new LinkedList<>();
		queue13AM.add("\nQueue 13.00-15.00 AM.");
		queue13AM.add("\nQueue 13.00-15.00 AM.");
		queue13AM.add("\nQueue 13.00-15.00 AM.");
		queue13AM.add("\nQueue 13.00-15.00 AM.");
		
		Queue<String> queue15AM = new LinkedList<>();
		queue15AM.add("\nQueue 15.00-17.00 AM.");
		queue15AM.add("\nQueue 15.00-17.00 AM.");
		queue15AM.add("\nQueue 15.00-17.00 AM.");
		queue15AM.add("\nQueue 15.00-17.00 AM.");
		
		System.out.println("");
		System.out.println("-----------------Time-----------------");
		System.out.println("");
		System.out.println("1) 08.00-10.00 AM "+"  Available queues "+queue08AM.size());
		System.out.println("2) 10.00-12.00 AM "+"  Available queues "+queue10AM.size());
		System.out.println("3) 13.00-15.00 AM "+"  Available queues "+queue13AM.size());
		System.out.println("4) 15.00-17.00 AM "+"  Available queues "+queue15AM.size());
		System.out.println();
		System.out.print("Plase choose time (Enter Number) : ");
		
		}
        
	public int Pricecalculation(int numberPerson) {
		int PriceTotol = numberPerson * Price;
		return PriceTotol;
	}
	
	public boolean isEnglish(String Name) {
        return Name.matches("[a-zA-Z]+");
    }
    
}
	

