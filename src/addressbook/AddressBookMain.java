package addressbook;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
	
	static Scanner sc= new Scanner(System.in);
	private static HashSet set = new HashSet();
	private List<AddressBook> contacts = new ArrayList<AddressBook>();
	
	/*
	public List<AddressBook> createAddressBook(String name){
		
		AddressBookMain name = new AddressBookMain();
	}
	*/
	
	public void addContact(){
		
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
		
		AddressBook person = new AddressBook(fname,lname,city,state,zip,phno,address,mail);
		
		this.contacts.add(person);
	}

	public AddressBook findContact(String name) {
		
		AddressBook con = null;
		for(AddressBook contact: contacts) {
			if(contact.getFirstName().equals(name)) {
				con = contact;
			}
		}
		
		return con;
	}
	
	public void editDetails(String name) {
		
		AddressBook edit_con = findContact(name);
		
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
	
	public void deleteContact(String name) {
		
		AddressBook del_con = findContact(name);
		contacts.remove(del_con);
		
	}
	
	public void viewContact(String name) {
		AddressBook view_con = findContact(name);
		
		System.out.println("First Name: " + view_con.getFirstName());
		System.out.println("Last Name : " + view_con.getLastName());
		System.out.println("Address   : " + view_con.getAddress());
		System.out.println("City      : " + view_con.getCity());
		System.out.println("State     : " + view_con.getState());
		System.out.println("Zip Code  : " + view_con.getZipcode());
		System.out.println("Phone No  : " + view_con.getPhNo());
		System.out.println("Email     : " + view_con.getEmail());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Address Book Program");
		int addbook_choice = 1;
		
		while(addbook_choice != 0) {
			System.out.println("Do you want to add an Address Book? \n0. NO \n1. YES");
			addbook_choice = sc.nextInt();
			sc.nextLine();
			
			if(addbook_choice == 1) {
				
				System.out.println("Added A New Address Book");
				
				//System.out.println("Enter the name of the Address Book");
				//String addressbook_name = sc.nextLine();
				AddressBookMain person1 = new AddressBookMain();
				set.add(person1);
				int choice = 1;
				
				while(choice != 5) {
					System.out.println("1. Add a Contact");
					System.out.println("2. Edit Details");
					System.out.println("3. Delete a Contact");
					System.out.println("4. View a Contact");
					System.out.println("5. Exit");
					
					choice = sc.nextInt(); sc.nextLine();
					
					switch(choice) {
						case 1:{
							person1.addContact();
							break;
						}
						case 2:{
							System.out.println("Enter the name of the person");
							String edit_name = sc.nextLine();
							person1.editDetails(edit_name);
							break;
						}
						case 3:{
							System.out.println("Enter the name of the person");
							String del_name = sc.nextLine();
							person1.deleteContact(del_name);
							break;
						}
						case 4:{
							System.out.println("Enter the name of the person");
							String view_name = sc.nextLine();
							person1.viewContact(view_name);
							
						}
					}
				}
			}
		}
		
		return;
	}
}