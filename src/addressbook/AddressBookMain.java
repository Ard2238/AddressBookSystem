package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
	
	static Scanner sc= new Scanner(System.in);
	private static List<AddressBook> contacts = new ArrayList<AddressBook>();
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Address Book Program");
		AddressBookMain person1 = new AddressBookMain();
		int choice = 1;
		
		while(choice != 4) {
			System.out.println("1. Add a Contact");
			
			choice = sc.nextInt(); sc.nextLine();
			
			switch(choice) {
				case 1:{
					person1.addContact();
					break;
				}
				default: {
					
				}
			}
		}

	}

}
