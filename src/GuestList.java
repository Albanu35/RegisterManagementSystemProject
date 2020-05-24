import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {
	private final String eventName = "DevEvent"; // name of event
	private int maxParticipants; // number of participants to event
	private ArrayList<Guest> participantsList; // list of participants type // Guest
	private ArrayList<Guest> waitingList; // list of waiting participants type Guest

	// constructor create a guest list & a wait list
	public GuestList(int maxParticipants) {
		this.maxParticipants = maxParticipants;
		this.participantsList = new ArrayList<Guest>();
		this.waitingList = new ArrayList<Guest>();
	}

	// method to print list of commands
	public void help() {

		System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");

		System.out.println("help - Afiseaza aceasta lista de comenzi\r\n"
				+ "add - Adauga o noua persoana (inscriere)\r\n"
				+ "check - Verifica daca o persoana este inscrisa la eveniment\r\n"
				+ "remove - Sterge o persoana existenta din lista\r\n"
				+ "update - Actualizeaza detaliile unei persoane\r\n"
				+ "guests - Lista de persoane care participa la eveniment\r\n"
				+ "waitlist - Persoanele din lista de asteptare\r\n" + "available - Numarul de locuri libere\r\n"
				+ "guests_no - Numarul de persoane care participa la eveniment\r\n"
				+ "waitlist_no - Numarul de persoane din lista de asteptare\r\n"
				+ "subscribe_no - Numarul total de persoane inscrise\r\n"
				+ "search - Cauta toti invitatii conform sirului de caractere introdus\r\n"
				+ "quit - Inchide aplicatia");
	}

	// check
	public boolean check(String option, String filter) {
		if (option.equals("1")) {
			String[] fullName = filter.split(",");
			String lastName = fullName[0];
			String firstName = fullName[1];
			for (int i = 0; i < participantsList.size(); i++) {
				if (participantsList.get(i).checkByName(lastName, firstName)) {
					return true;
				}
			}
			for (int i = 0; i < waitingList.size(); i++) {
				if (waitingList.get(i).checkByName(lastName, firstName)) {
					return true;
				}
			}
		} else if (option.equals("2")) {
			for (int i = 0; i < participantsList.size(); i++) {
				if (participantsList.get(i).checkByEmail(filter)) {
					return true;
				}
			}
			for (int i = 0; i < waitingList.size(); i++) {
				if (waitingList.get(i).checkByEmail(filter)) {
					return true;
				}
			}
		} else if (option.equals("3")) {
			for (int i = 0; i < participantsList.size(); i++) {
				if (participantsList.get(i).checkByPhoneNumber(filter)) {
					return true;
				}
			}
			for (int i = 0; i < waitingList.size(); i++) {
				if (waitingList.get(i).checkByPhoneNumber(filter)) {
					return true;
				}
			}
		} else {
			System.out.println("Option Error!");
		}
		return false;
	}

	// 1. method add a enroll guest
	public int add(String option, Guest guest) {
		String fullName = guest.getLastName() + "," + guest.getFirstName();
		String email = guest.getEmail();
		String phoneNumber = guest.getPhoneNumber();
		String filter = "";
		if (option.equals("1")) {
			filter = fullName;
		} else if (option.equals("2")) {
			filter = email;
		} else if (option.equals("3")) {
			filter = phoneNumber;
		}
		if (check(option, filter)) {
			return -1;
		} else if (participantsList.size() < maxParticipants) {
			this.participantsList.add(guest);
			System.out.println("[ " + guest.getFirstName() + " " + guest.getLastName()
					+ "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		} else {
			this.waitingList.add(guest);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "
					+ (waitingList.indexOf(guest) + 1) + ". Te vom notifica daca un loc devine disponibil");
			return (this.waitingList.indexOf(guest) + 1);
		}

	}

	// method remove

	public boolean remove(String option, String filter) {
		if (!check(option, filter)) {
			System.out.println("Nu exista persoana");
			return false;
		} else {
			if (option.equals("1")) {
				String[] fullName = filter.split(",");
				String lastName = fullName[0];
				String firstName = fullName[1];
				for (int i = 0; i < participantsList.size(); i++) {
					if (participantsList.get(i).checkByName(lastName, firstName)) {

						participantsList.remove(participantsList.get(i));
						System.out.println("Persoana a fost stearsa cu succes!");
						if (waitingList.size() > 0) {
							System.out.println(
									"[ " + waitingList.get(0).getFirstName() + " " + waitingList.get(0).getLastName()
											+ "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
							participantsList.add(waitingList.get(0));

						}
						return true;

					}
				}
				for (int i = 0; i < waitingList.size(); i++) {
					if (waitingList.get(i).checkByName(lastName, firstName)) {
						waitingList.remove(waitingList.get(i));
						System.out.println("Persoana a fost stearsa cu succes!");
						return true;
					}
				}
			} else if (option.equals("2")) {
				for (int i = 0; i < participantsList.size(); i++) {
					if (participantsList.get(i).checkByEmail(filter)) {

						participantsList.remove(participantsList.get(i));
						System.out.println("Persoana a fost stearsa cu succes!");
						if (waitingList.size() > 0) {
							System.out.println(
									"[ " + waitingList.get(0).getFirstName() + " " + waitingList.get(0).getLastName()
											+ "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
							participantsList.add(waitingList.get(0));

						}
						return true;

					}
				}
				for (int i = 0; i < waitingList.size(); i++) {
					if (waitingList.get(i).checkByEmail(filter)) {
						waitingList.remove(waitingList.get(i));
						System.out.println("Persoana a fost stearsa cu succes!");
						return true;
					}
				}
			} else if (option.equals("3")) {
				for (int i = 0; i < participantsList.size(); i++) {
					if (participantsList.get(i).checkByPhoneNumber(filter)) {

						participantsList.remove(participantsList.get(i));
						System.out.println("Persoana a fost stearsa cu succes!");
						if (waitingList.size() > 0) {
							System.out.println(
									"[ " + waitingList.get(0).getFirstName() + " " + waitingList.get(0).getLastName()
											+ "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
							participantsList.add(waitingList.get(0));

						}
						return true;

					}
				}
				for (int i = 0; i < waitingList.size(); i++) {
					if (waitingList.get(i).checkByPhoneNumber(filter)) {
						waitingList.remove(waitingList.get(i));
						System.out.println("Persoana a fost stearsa cu succes!");
						return true;
					}
				}
			}
		}

		return false;
	}

	// update method
	public boolean update(String searchOption, String filter, String updateOption, String updateText) {
		if (!check(searchOption, filter)) {
			System.out.println("Nu exista persoana");
			return false;
		} else {
			if (searchOption.equals("1")) {
				String[] fullName = filter.split(",");
				String lastName = fullName[0];
				String firstName = fullName[1];
				for (int i = 0; i < participantsList.size(); i++) {

					if (participantsList.get(i).checkByName(lastName, firstName)) {
						update(updateOption, updateText, participantsList.get(i));
						return true;

					}
				}
				for (int i = 0; i < waitingList.size(); i++) {
					if (waitingList.get(i).checkByName(lastName, firstName)) {
						update(updateOption, updateText, waitingList.get(i));
						return true;
					}
				}
			} else if (searchOption.equals("2")) {
				for (int i = 0; i < participantsList.size(); i++) {
					if (participantsList.get(i).checkByEmail(filter)) {
						update(updateOption, updateText, participantsList.get(i));
						return true;
					}
				}
				for (int i = 0; i < waitingList.size(); i++) {
					if (waitingList.get(i).checkByEmail(filter)) {
						update(updateOption, updateText, waitingList.get(i));
						return true;
					}
				}
			} else if (searchOption.equals("3")) {
				for (int i = 0; i < participantsList.size(); i++) {
					if (participantsList.get(i).checkByPhoneNumber(filter)) {
						update(updateOption, updateText, participantsList.get(i));
						return true;
					}
				}
				for (int i = 0; i < waitingList.size(); i++) {
					if (waitingList.get(i).checkByPhoneNumber(filter)) {
						update(updateOption, updateText, waitingList.get(i));

						return true;
					}
				}
			}
		}

		return false;
	}

	public void update(String updateOption, String updateText, Guest guest) {
		if (updateOption.equals("1")) {
			guest.setLastName(updateText);
		} else if (updateOption.equals("2")) {
			guest.setFirstName(updateText);
		} else if (updateOption.equals("3")) {
			guest.setEmail(updateText);
		} else if (updateOption.equals("4")) {
			guest.setPhoneNumber(updateText);
		}

	}
	
	//method of print a participant list
	public void guests () {
		System.out.println("Lista de participanti este:");
		if(participantsList.size() == 0) {
			System.out.println("Nu exista persoane inscrise la eveniment!");
		}
		
		for (int i = 0; i < participantsList.size(); i++) {
		System.out.println("Prenume: " + participantsList.get(i).getFirstName() + " , "
							+ " Nume: " + participantsList.get(i).getLastName() + " , "
							+ " Email: " + participantsList.get(i).getEmail() + " , "
							+ " Telefon: " + participantsList.get(i).getPhoneNumber());
		}
	}
	
	//method of print a waiting list
		public void waitlist () {
			System.out.println("Lista de asteptare este:");
			if(waitingList.size() == 0) {
				System.out.println("Nu exista persoane in lista de asteptare!");
			}
			
			for (int i = 0; i < waitingList.size(); i++) {
			System.out.println("Prenume: " + waitingList.get(i).getFirstName() + " , "
					+ " Nume: " + waitingList.get(i).getLastName() + " , "
					+ " Email: " + waitingList.get(i).getEmail() + " , "
					+ " Telefon: " + waitingList.get(i).getPhoneNumber());
			}
		}
		
	//method of return number of free sets to event
		public int available(){
			System.out.print("Locuri ramase la eveniment: ");
			return maxParticipants - participantsList.size();
		}
		
		//method returns number of participants to event
		public int guests_no() {
			System.out.print("Numarul de participanti: ");
			return participantsList.size();
		}
		
		//method returns number of enroll people in waiting list
		public int waitlist_no() {
			System.out.print("Numarul de persoane aflate pe lista de asteptare: ");
			return waitingList.size();
		}
		
		//method returns number of all guests enroll to event
		public int subscribe_no() {
			System.out.print("Numarul total de persoane inscrise: ");
			return participantsList.size() + waitingList.size();
		}
		
		//method search all guests by substring
		public boolean search (String subText) {
			for (int i = 0; i < participantsList.size(); i++) {
				if (participantsList.get(i).getLastName().contains(subText)) {
					System.out.println("Contactul contine Nume: " + participantsList.get(i).getLastName());
					return true;
				}
				else if (participantsList.get(i).getFirstName().contains(subText)) {
					System.out.println("Contactul contine Prenume: " + participantsList.get(i).getFirstName());
					return true;
				}
				else if (participantsList.get(i).getEmail().contains(subText)) {
					System.out.println("Contactul contine Email: " + participantsList.get(i).getEmail());
					return true;
				}
				else if (participantsList.get(i).getPhoneNumber().contains(subText)) {
					System.out.println("Contactul contine Telefon: " + participantsList.get(i).getPhoneNumber());
					return true;
				}
			}
			for (int i = 0; i < waitingList.size(); i++) {
				if (waitingList.get(i).getLastName().contains(subText)) {
					System.out.println("Contactul contine Nume :" + waitingList.get(i).getLastName());
					return true;
				}
				else if (waitingList.get(i).getFirstName().contains(subText)) {
					System.out.println("Contactul contine Prenume: " + waitingList.get(i).getFirstName());
					return true;
				}
				else if (waitingList.get(i).getEmail().contains(subText)) {
					System.out.println("Contactul contine Email: " + waitingList.get(i).getEmail());
					return true;
				}
				else if (waitingList.get(i).getPhoneNumber().contains(subText)) {
					System.out.println("Contactul contine Telefon: " + waitingList.get(i).getPhoneNumber());
					return true;
				}
			}
			System.out.println("Nu exista persoana cu datele pe care le cautati!");
			return false;
		}
		
		//method of quit aplication
		public void quit() {
			System.out.println("Aplicatia se inchide..");
		}

}
