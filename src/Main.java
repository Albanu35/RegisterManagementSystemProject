
public class Main {

	public static void main(String[] args) {
		
		// create 2 object type Guest and GuestList
		
		
		Guest alex = new Guest();
		
		alex.setFirstName("Alex");
		alex.setLastName("Vrancea");
		alex.setEmail("alex.vrancea@gmail.com");
		alex.setPhoneNumber("+407211111");
		
		Guest ion = new Guest();
		Guest andrei = new Guest();
		Guest dan = new Guest();
		
	
		GuestList devMind = new GuestList("devMind", 3);
		GuestList waitList = new GuestList(null, 0);
		
		devMind.add(alex);
		devMind.add(ion);
		devMind.add(andrei);
		devMind.add(dan);
		
		devMind.remove(andrei);
				
		devMind.update(dan);
		
		Guest Zaharia = new Guest();
		
		devMind.add(Zaharia);
		
		
		
		
		

	}

	

}
