import java.util.Scanner;
import java.io.*;


public class HotelDatabase {
	private final int Num_Room = 40;
	Hash<Hotel>ht = new Hash<>(Num_Room*2);
	BST<Hotel> bst = new BST<>();
	
	public static void main(String[]args) {
		HotelDatabase d = new HotelDatabase();
		Hotel h = null;
		String roomNumber;
		String occupants;
		String res="";
		String a = "";
		String roomType;
		String stayDuration;
		int numGuest;
		int suiteav=5, standardav=9, queenav=7, kingav=8, doubleav = 11;
		int floor;
		int price, suiteprice=250,standardprice=30,doubleprice=50,queenprice=90,kingprice=120;
		int roomnumincrement = 40;
		File file = new File("hotel.txt");
		Scanner input1 = null;
		try {
			input1 = new Scanner(file);
		}catch(FileNotFoundException e) {
			System.out.print("File not found, please import one or create a new one.");
		}
		while(input1.hasNextLine()) {
			roomNumber = input1.nextLine();
			occupants = input1.nextLine();
			stayDuration = input1.nextLine();
			roomType = input1.nextLine();
			numGuest = input1.nextInt();
			floor = input1.nextInt();
			price = input1.nextInt();
			
			if (input1.hasNextLine()) {
				input1.nextLine();
				input1.nextLine();
			}
			
			h= new Hotel(roomNumber, occupants, roomType, stayDuration, numGuest, floor, price);
			d.ht.insert(h);
			d.bst.insert(h);
		}
		input1.close();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to ADT Hotel");
		while(!(res.equalsIgnoreCase("X"))) {
			System.out.println("Please select from one of the following options: \n");

			System.out.println(
					"A. Make a Reservation\nD. Display all Rooms\nR. Check out\nS. Search for a Room\nX. Exit\n");
			System.out.print("Enter your choice: ");
			res = input.nextLine();
			if(res.equalsIgnoreCase("A")) {
				System.out.println("Here are the types of rooms we have: \n1.Double($50 per night)\n2.Standard($30 per night)\n3.Queen($90 per night)\n4.King($120 per night)\n5.Suite($250 per night)");
				System.out.print("Please enter what type of room you want: ");
				res=input.nextLine();
				if(res.equalsIgnoreCase("Double")) {
					if(doubleav==0) {
						System.out.print("Sorry there are no more Double rooms available!");
					}else {
						roomnumincrement++;
						roomNumber = ""+roomnumincrement;
						System.out.println("There are "+doubleav+" double rooms available");
						System.out.print("What is the name for the reservation?: ");
						occupants = input.nextLine();
						System.out.print("How long is the stay?: ");
						stayDuration = input.nextLine();
						
					}		
				}else if(res.equalsIgnoreCase("Standard")) {
					
				}else if(res.equalsIgnoreCase("Queen")) {
					
				}else if(res.equalsIgnoreCase("King")) {
					
				}else if(res.equalsIgnoreCase("Suite")) {
					
				}
				
				
				
			}
			else if(res.equalsIgnoreCase("D")) {
				
			}
			else if(res.equalsIgnoreCase("R")) {
				
			}
			else if(res.equalsIgnoreCase("S")) {
				System.out.println("\nLet's search for a room!");
				System.out.println("A. Search by room number.");
				System.out.println("B. Search by guest name.");
				System.out.println();
				System.out.print("How would you like to search: ");
				String choice = input.nextLine();
				
				while (!choice.equalsIgnoreCase("A") && !choice.equalsIgnoreCase("B")) {
					System.out.println("\nInvalid choice!\n");
					System.out.println("A. Search by room number.");
					System.out.println("B. Search by guest name.");
					System.out.println();
					System.out.print("How would you like to search: ");
					choice = input.nextLine();
				}
				if (choice.equalsIgnoreCase("A")) {
					System.out.println("\nSearching by room number!");
					System.out.println();
					System.out.print("Room number you are looking for (1 - 80): ");
					roomNumber = input.nextLine();
					
					Hotel temp = new Hotel(roomNumber, null, null, null, 0, 0, 0);
					int inTable = d.ht.search(temp);
					if (inTable != -1) {
						System.out.println("This room available!");
						
					}
					else {
						System.out.println("This room is not available!");
					}
					
				}
				else if (choice.equalsIgnoreCase("B")) {
					System.out.println("Searching by occupant's name!");
					System.out.println();
					System.out.print("Name of the occupant: ");
					occupants = input.nextLine();
					
					Hotel temp = new Hotel(null, null, occupants, null, 0, 0, 0);
					int inTable = d.ht.search(temp);
					
					if (inTable != -1) {
						System.out.println("This room is occupied by " + occupants + "!");
					}
					else {
						System.out.println("There is no room occupied by " + occupants + "!");
					}
				}
			}
			else if(res.equalsIgnoreCase("X")) {
				break;
			}
		}
		System.out.print("Would you like all room information to be put into a file?(Y/N)");
		res = input.nextLine();
		if(res.equalsIgnoreCase("y")) {
			System.out.print("Please enter the name of the file you want to create: ");
			String filename = input.nextLine();
			File fileo = new File(filename);
			
		}
		else {
			System.out.print("GoodBye!");
		}
		
		
	}
}
