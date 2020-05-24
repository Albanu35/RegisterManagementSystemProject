import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//create a scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Salut! Introduceti numarul de locuri disponibile: ");
		int maxParticipants = sc.nextInt(); //in a number of guest to the event
		GuestList listEvent = new GuestList(maxParticipants); // create a list event
		listEvent.help(); //print a list of commands
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		//create 2 object type Guest
		Guest Andrei = new Guest("Vrancea", "Andrei", "andrei@gmail.com", "07213111");
		Guest Ion = new Guest("Bobocea", "Ion", "ion@yahoo.com", "0722355222");
		
		//add each guest object to the event list
		listEvent.add("1", Andrei);
		listEvent.add("2", Ion);
		System.out.println("Exista persoana cautata? ");
		//check if an object Guest exist in the list event
		System.out.println(listEvent.check("1", "Vrancea,Andrei"));
		
		//print guests list
		listEvent.guests();
		
		//print to waiting list
		listEvent.waitlist();
		
		//method search a person by a substring
		listEvent.search("cel");
		listEvent.search("And");
		
		//number of participants
		System.out.println(listEvent.guests_no());
		
		//number of person enroll in waiting list
		System.out.println(listEvent.waitlist_no());
		
		//number of total person enroll to event
		System.out.println(listEvent.subscribe_no());
		
		//number of seats available to the event
		System.out.println(listEvent.available());
		
		//create a new Guest
		Guest Max = new Guest("Moisescu","Maxim","maxim@email.ro","0745644000");
		
		//add guest to the list
		listEvent.add("3", Max);
		listEvent.add("2", Andrei);
		
		
		//print new List of participants
		listEvent.guests();
		
		//print new List of waiting person
		listEvent.waitlist();
		
		//remove a guest from the list
		listEvent.remove("2", "ion@yahoo.com");
		
		//print the list of guest
		listEvent.guests();
		
		//number of participants
		System.out.println(listEvent.guests_no());
		
		//update info a guest
		listEvent.update("4", "721000000", Max);
		
		//print list of participants
		listEvent.guests();
		
		//create new Guests
		
		Guest Daria = new Guest("Vornicescu","Daria","daria@hotmail.com","0728333777");
		Guest Ivanka = new Guest("Ciobanu","Ivanka","ivanka@gmail.ro","073446779");
		
		//add new guest to the event
		listEvent.add("1", Daria);
		listEvent.add("3", Ivanka);
		
		//print new List of participants
		listEvent.guests();
				
		//print new List of waiting person
		listEvent.waitlist();
				
		//number of participants
		System.out.println(listEvent.guests_no());
				
		//number of person enroll in waiting list
		System.out.println(listEvent.waitlist_no());
				
		//number of total person enroll to event
		System.out.println(listEvent.subscribe_no());
				
		//number of seats available to the event
		System.out.println(listEvent.available());		
		
		//quit aplication
		listEvent.quit();
	}

}
