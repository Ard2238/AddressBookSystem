package addressbook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	
	static Scanner sc= new Scanner(System.in);
	private static HashMap<String, AddressBookMain> addressbook_map = new HashMap<String, AddressBookMain>();
	private List<Contact> contacts = new ArrayList<Contact>();
	private String bookName;	
	
	public AddressBookMain(String bookName) {
		super();
		this.bookName = bookName;
	}

	public Contact findContact(String fname, String lname) {		
		Contact find_con = null;
		for(Map.Entry entry : addressbook_map.entrySet()) {			
			for(Contact ab : ((AddressBookMain)entry.getValue()).contacts) {
				if(fname.equals(ab.getFirstName()) && lname.equals(ab.getLastName()))
					find_con = ab;
			}
		}
		return find_con;
	}
	
	public static List<Contact> findBook(String name){
		List<Contact> foundBook = null;
		for(Map.Entry<String, AddressBookMain> entry: addressbook_map.entrySet()) {
			if(name.equals(entry.getKey()))
				foundBook = entry.getValue().contacts;
		}
		if(foundBook == null)
			System.out.println("No addressbook by the given name found.");
		return foundBook;
	}	
	
	/* UC1 -- Create a contact */
	/* UC2 -- Add a contact */
	/* UC7 -- Check for duplicate contact in a particular book */
	public static void addContact(List<Contact> foundBook){	
		System.out.println("Enter the first name of the person : ");
		String fname = sc.nextLine();
		System.out.println("Enter the last name of the person  : ");
		String lname = sc.nextLine();
		System.out.println("Enter the address of the person : ");
		String address = sc.nextLine();
		System.out.println("Enter the city of the person  : ");
		String city = sc.nextLine();
		System.out.println("Enter the state of the person : ");
		String state = sc.nextLine();
		System.out.println("Enter the zip code : ");
		int zip = sc.nextInt(); sc.nextLine();
		System.out.println("Enter the phone no of the person : ");
		int phno = sc.nextInt(); sc.nextLine();
		System.out.println("Enter the email of the person  : ");
		String mail = sc.nextLine();
		
		Contact person = new Contact(fname,lname,city,state,zip,phno,address,mail);
		
		/* UC7 -- checking for duplicate contact */
		if(!foundBook.isEmpty()) {
			foundBook.stream().forEach(contact -> {				
				if(person.equals(contact)){
					System.out.println("Duplicate Contact Found.");
					return;
				}
			});		
		}
		foundBook.add(person);	
		return;
	}
	
	/* UC3 -- Edit any contact details */
	public void editDetails(String name) {
		List<Contact> foundBook = findBook(name);		
		Contact edit_con = null;
		System.out.println("Enter the name of the person");
		String edit_name = sc.nextLine();
		for(Contact adb : foundBook) {
			if(edit_name.equals(adb.getFirstName()))
				edit_con = adb;
		}
		if(edit_con == null) 
			System.out.println("No contact found to edit.");
		else {
			int choice = 1;
			while(choice != 9) {
				System.out.println("1. Edit First Name");
				System.out.println("2. Edit Last Name");
				System.out.println("3. Edit Address");
				System.out.println("4. Edit City");
				System.out.println("5. Edit State");
				System.out.println("6. Edit ZipCode");
				System.out.println("7. Edit Phone No");
				System.out.println("8. Edit Email");
				System.out.println("9. Exit");
				
				choice = sc.nextInt(); sc.nextLine();			
				switch(choice) {
					case 1:{
						edit_con.setFirstName(sc.nextLine()); break;
					}
					case 2:{
						edit_con.setLastName(sc.nextLine()); break;
					}
					case 3:{
						edit_con.setAddress(sc.nextLine()); break;
					}
					case 4:{
						edit_con.setCity(sc.nextLine()); break;
					}
					case 5:{
						edit_con.setState(sc.nextLine()); break;
					}
					case 6:{
						edit_con.setZipcode(sc.nextInt()); break;
					}
					case 7:{
						edit_con.setPhNo(sc.nextInt()); break;
					}
					case 8:{
						edit_con.setEmail(sc.nextLine()); break;
					}
				}
			}
		}
		
	}
	
	/* UC4 -- Delete a contact from any book */
	public void deleteContact(String fname, String lname) {
		Contact to_delete = null;
		List<Contact> contact = null ;
		for(Map.Entry entry : addressbook_map.entrySet()) {	
			contact = ((AddressBookMain)entry.getValue()).contacts;
			for(Contact ab : contact) {
				if(fname.equals(ab.getFirstName()) && lname.equals(ab.getLastName()))
					to_delete = ab;
			}
		}
		if(to_delete == null)
			System.out.println("No Such Contact Found to Delete.");
		else
			contact.remove(to_delete);		
	}
	
	public void viewContact(String fname, String lname) {
		Contact view_con = findContact(fname,lname);
		
		if(view_con == null) {
			System.out.println("No Such Contact Found");
			return;
		}		
		System.out.println("First Name: " + view_con.getFirstName());
		System.out.println("Last Name : " + view_con.getLastName());
		System.out.println("Address   : " + view_con.getAddress());
		System.out.println("City      : " + view_con.getCity());
		System.out.println("State     : " + view_con.getState());
		System.out.println("Zip Code  : " + view_con.getZipcode());
		System.out.println("Phone No  : " + view_con.getPhNo());
		System.out.println("Email     : " + view_con.getEmail());
	}
	
	/* UC8 -- search Person in a city or state across multiple books */
	/* UC9 -- view person in city or state across multiple books */
	public static void searchPersonCityState() {
		System.out.println("Do you wish to search by \n1. City \n2. State");
		int choice = sc.nextInt(); sc.nextLine();
		
		if(choice == 1)
			System.out.println("Enter the City Name: ");
		else
			System.out.println("Enter the State Name:");		
		String input = sc.nextLine();
		switch(choice) {
			case 1:	{
				for(AddressBookMain ad : addressbook_map.values()) {
					ad.contacts.stream().filter(city -> city.getCity().equals(input)).forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
				}
				break;
			}
			case 2:{
				for(AddressBookMain ad : addressbook_map.values()) {
					ad.contacts.stream().filter(state -> state.getState().equals(input)).forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
				}
				break;
			}
		}		
	}
	
	public static long countByCityState() {
		System.out.println("Do you wish to search by \n1. City \n2. State");
		int choice = sc.nextInt(); sc.nextLine();
		long count = 0;
		if(choice == 1)
			System.out.println("Enter the City Name: ");
		else
			System.out.println("Enter the State Name:");		
		String input = sc.nextLine();
		switch(choice) {
			case 1:	{
				for(AddressBookMain ad : addressbook_map.values()) {
					count = ad.contacts.stream().filter(city -> city.getCity().equals(input)).count();
				}
				break;
			}
			case 2:{
				for(AddressBookMain ad : addressbook_map.values()) {
					count = ad.contacts.stream().filter(state -> state.getState().equals(input)).count();
				}
				break;
			}
		}
		return count;
	}
	

	/* UC5 - UC6  -- Add multiple contacts and multiple address book */
	public static void initialize() {
		int addbook_choice = 1;	
		/* UC6 -- Add multiple books */
		while(addbook_choice != 0) {
			System.out.println("Do you want to add an Address Book? \n0. NO \n1. YES");
			addbook_choice = sc.nextInt(); sc.nextLine();			
			if(addbook_choice == 1) {				
				System.out.println("Enter the name of the Address Book");
				String addressbook_name = sc.nextLine();				
				AddressBookMain person1 = new AddressBookMain(addressbook_name);
				addressbook_map.put(addressbook_name, person1);
				System.out.println("Added A New Address Book");
				int choice = 1;
				
				/* UC5 -- Add multiple contacts to one book */
				while(choice != 7) {
					System.out.println("1. Add a Contact");
					System.out.println("2. Edit Details");
					System.out.println("3. Delete a Contact");
					System.out.println("4. View a Contact");
					System.out.println("5. Search Person in a City or State");
					System.out.println("6. Count Person by City or State");
					System.out.println("7. Exit");
					
					choice = sc.nextInt(); sc.nextLine();
					
					switch(choice) {
						case 1:{
							System.out.println("Enter the name of the address book you want to add the contact to: ");
							String name_addbook = sc.nextLine();
							List<Contact> foundBook = findBook(name_addbook);
							if(foundBook != null)
								addContact(foundBook);
							break;
						}
						case 2:{
							System.out.println("Enter the name of the address book you want to edit a contact from: ");
							String name_adbook = sc.nextLine();							
							person1.editDetails(name_adbook);
							break;
						}
						case 3:{
							System.out.println("Enter the first name and last name of the person you want to delete: ");
							String del_fname = sc.nextLine();
							String del_lname = sc.nextLine();
							person1.deleteContact(del_fname, del_lname);
							break;
						}
						case 4:{
							System.out.println("Enter the first name and last name of the person: ");
							String view_fname = sc.nextLine();
							String view_lname = sc.nextLine();
							person1.viewContact(view_fname, view_lname);							
						}
						case 5:{
							searchPersonCityState(); break;
						}
						case 6:{
							countByCityState(); break;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Address Book Program");
		initialize();		
		return;
	}
}