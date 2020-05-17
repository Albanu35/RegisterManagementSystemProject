import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {
	private final String eventName; // name of event
	private int maxParticipants; // number of participants to event
	private ArrayList<Guest> participantsList; // list of participants type Guest
	private ArrayList<Guest> waitingList; // list of waiting participants type Guest
	Scanner sc = new Scanner(System.in);

	//constructor
	public GuestList(String eventName, int maxParticipants) {
		this.eventName = eventName;
		this.maxParticipants = maxParticipants;
		this.participantsList = new ArrayList<Guest>();
		this.waitingList = new ArrayList<Guest>();
	}

	//method of add a guest
	public int add(Guest guest) {

		System.out.println("Se adauga o noua persoana..");
		System.out.println("Introduceti numele de familie:");
		String lastName = sc.nextLine();
		System.out.println("Introduceti prenumele:");
		String firstName = sc.nextLine();
		System.out.println("Introduceti emailul:");
		String email = sc.nextLine();
		System.out.println("Introduceti telefonul:");
		String numberPhone = sc.nextLine();

		if ((!check(guest, lastName) && !check(guest, firstName)) && participantsList.size() <= maxParticipants) {
			participantsList.add(guest);
			System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		} else if ((!check(guest, lastName) && !check(guest, firstName))
				&& participantsList.size() >= maxParticipants) {
			waitingList.add(guest);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "
					+ waitingList.lastIndexOf(guest) + ". Te vom notifica daca un loc devine disponibil");
			return waitingList.lastIndexOf(guest);
		} else {
			System.out.println("Te-ai inscris deja la eveniment!");
			return -1;

		}
	}

	// method of search - return true if person is check
	public boolean checkByName(String lastName, String firstName) {

		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getFirstName().equals(firstName)
					&& participantsList.get(i).getLastName().equals(lastName)) {
				return true;

			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (waitingList.get(i).getFirstName().equals(firstName)
					&& waitingList.get(i).getLastName().equals(lastName)) {
				return true;
			}
		}

		return false;
	}

	//metod of search a person by email
	public boolean checkByEmail(String email) {
		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getEmail().equals(email)) {
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (waitingList.get(i).getEmail().equals(email)) {

			}
		}

		return false;

	}
	
	//metod of search a person by phone
	public boolean checkByPhone(String numberPhone) {
		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getPhoneNumber().equals(numberPhone)) {
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (waitingList.get(i).getPhoneNumber().equals(numberPhone)) {
				return true;
			}
		}
		return false;
	}

	//metod of search a person by option
	public boolean check(Guest guest, String filter) {
		if (filter == "1") {
			checkByName(guest.getFirstName(), guest.getLastName());
			return true;
		} else if (filter == "2") {
			checkByEmail(guest.getEmail());
			return true;
		} else if (filter == "3") {
			checkByPhone(guest.getPhoneNumber());
			return true;
		}

		return false;
	}

	// method of delete a person from list
	public boolean remove(Guest guest) {
		System.out.println("Se sterge o persoana existenta din lista…");
		System.out.println("Alege modul de autentificare, tastand:\r\n" + "\"1\" - Nume si prenume\r\n"
				+ "\"2\" - Email\r\n" + "\"3\" - Numar de telefon (format \"+40733386463\")");
		String option = sc.nextLine();

		if (option == "1") {
			System.out.println("Introduceti numele:");
			String lastName = sc.nextLine();
			String firstName = sc.nextLine();
			if (lastName.equals(guest.getLastName()) && firstName.equals(guest.getFirstName())) {
				removeByName(guest.getFirstName(), guest.getLastName());
			}

		} else if (option == "2") {
			System.out.println("Introduceti email:");
			String email = sc.nextLine();
			if (email.equals(guest.getEmail())) {
				removeByEmail(guest.getEmail());
			}
		} else if (option == "3") {
			System.out.println("Introduceti numarul de telefon:");
			String phoneNumber = sc.nextLine();
			if (phoneNumber.equals(guest.getPhoneNumber())) {
				removeByPhoneNumber(guest.getPhoneNumber());
			}
		}
		return false;

	}

	// method of delete a person from list by Name
	public boolean removeByName(String firstName, String lastName) {
		if (checkByName(firstName, lastName)) {

			System.out.println("Stergerea persoanei s-a realizat cu succes");
			return true;
		}
		System.out.println("eroare: persoana nu era inscrisa");
		return false;
	}

	// method of delete a person from list by Email
	public boolean removeByEmail(String email) {
		if (checkByEmail(email)) {
			System.out.println("Stergerea persoanei s-a realizat cu succes");
			return true;
		}
		System.out.println("eroare: persoana nu era inscrisa");
		return false;
	}

	// method of delete a person from list by phone
	public boolean removeByPhoneNumber(String phoneNumber) {
		if (checkByPhone(phoneNumber)) {
			System.out.println("Stergerea persoanei s-a realizat cu succes");
			return true;
		}
		System.out.println("eroare: persoana nu era inscrisa");
		return false;
	}

	//method update date a person
	public boolean update(Guest guest) {
		System.out.println("Se actualizeaza detaliile unei persoane…");
		System.out.println("Alege modul de autentificare, tastand:\r\n" + "\"1\" - Nume si prenume\r\n"
				+ "\"2\" - Email\r\n" + "\"3\" - Numar de telefon (format \"+40733386463\")");

		String option = sc.nextLine();

		if (option == "1") {
			System.out.println("Introduceti numele:");
			String lastName = sc.nextLine();
			String firstName = sc.nextLine();
			checkByName(lastName, firstName);
			return true;
		} else if (option == "2") {
			System.out.println("Introduceti emailul:");
			String email = sc.nextLine();
			checkByEmail(email);
			return true;
		} else if (option == "3") {
			System.out.println("Introduceti numarul de telefon:");
			String phoneNumber = sc.nextLine();
			checkByPhone(phoneNumber);
			return true;
		}

		System.out.println("Alege campul de actualizat, tastand:\r\n" + "\"1\" - Nume\r\n" + "\"2\" - Prenume\r\n"
				+ "\"3\" - Email\r\n" + "\"4\" - Numar de telefon (format \"+40733386463\")");

		String field = sc.nextLine();

		if (field == "1") {
			
			String firstName = sc.nextLine();
			updateByFirstName(firstName, guest.getLastName());
		} else if (field == "2") {
			String lastName = sc.nextLine();
			updateByLastName(guest.getFirstName(), lastName);
		} else if (field == "3") {
			String email = sc.nextLine();
			updateByEmail(email);
		} else if (field == "4") {
			String phoneNumber = sc.nextLine();
			updateByPhone(phoneNumber);
		}

		return false;
	}

	//method update a firstName person
	public boolean updateByFirstName(String firstName, String lastName) {
		System.out.println("Introduceti prenumele");
		String firstNameChanged = sc.nextLine();
		for (int i = 0; i < participantsList.size(); i++) {
			if (checkByName(firstName, lastName)) {
				participantsList.get(i).setFirstName(firstNameChanged);;
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (checkByName(firstName, lastName)) {
				waitingList.get(i).setFirstName(firstNameChanged);
				return true;
			}
		}
		return false;
	}

	//method update a lastname person
	public boolean updateByLastName(String firstName, String lastName) {
		System.out.println("Introduceti numele de familie");
		String lastNameChanged = sc.nextLine();
		for (int i = 0; i < participantsList.size(); i++) {
			if (checkByName(firstName, lastName)) {
				participantsList.get(i).setLastName(lastNameChanged);
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (checkByName(firstName, lastName)) {
				waitingList.get(i).setLastName(lastNameChanged);
				return true;
			}
		}
		return false;
	}

	//method update a email person
	public boolean updateByEmail(String email) {
		System.out.println("Introduceti emailul:");
		String emailChanged = sc.nextLine();
		for (int i = 0; i < participantsList.size(); i++) {
			if (checkByEmail(email)) {
				participantsList.get(i).setEmail(emailChanged);
				;
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (checkByEmail(email)) {
				waitingList.get(i).setEmail(emailChanged);
				return true;
			}
		}
		return false;
	}

	//method update a phone person
	public boolean updateByPhone(String phoneNumber) {
		System.out.println("Introduceti nr. de telefon:");
		String phoneNumberChanged = sc.nextLine();
		for (int i = 0; i < participantsList.size(); i++) {
			if (checkByPhone(phoneNumber)) {
				participantsList.get(i).setPhoneNumber(phoneNumberChanged);
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (checkByPhone(phoneNumber)) {
				waitingList.get(i).setPhoneNumber(phoneNumberChanged);
				return true;
			}
		}
		return false;

	}
}
