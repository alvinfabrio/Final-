import java.util.Scanner;
import java.io.*;

public class Database {
	private final int Num_Room = 40;
	Hash<Hotel> ht = new Hash<>(Num_Room * 2);
	BST<Hotel> bst = new BST<>();
	BST<Hotel> bst2 = new BST<>();
	List<Hotel>list = new List<>();

	public static void main(String[] args) {
		Database d = new Database();

		Hotel h = null;
		Hotel h2 = null;
		String roomNumber;
		String occupants;
		String res = "";
		String a = "";
		String roomType;

		int stayDuration;
		int numGuest;
		int suiteav = 5, standardav = 9, queenav = 7, kingav = 8, doubleav = 11;
		int floor;
		int price, suiteprice = 250, standardprice = 30, doubleprice = 50, queenprice = 90, kingprice = 120;
		int roomnumincrement = 0;

		File file = new File("hotel.txt");
		Scanner input1 = null;

		try {
			input1 = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.print("File not found, please import one or create a new one.");
		}

		while (input1.hasNextLine()) {
			roomNumber = input1.nextLine();
			occupants = input1.nextLine();
			roomType = input1.nextLine();
			stayDuration = input1.nextInt();
			numGuest = input1.nextInt();
			price = input1.nextInt();
			if (input1.hasNextLine()) {
				input1.nextLine();
				input1.nextLine();
			}

			h = new Hotel(roomNumber, occupants, roomType, stayDuration, numGuest, price);
			h2 = new Hotel2(roomNumber, occupants, roomType, stayDuration, numGuest, price);
			d.ht.insert(h);
			d.bst.insert(h);
			d.list.addLast(h2);
			d.bst2.insert(h2);
		    roomnumincrement++;
		}

		input1.close();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to ADT Hotel");
		while (!(res.equalsIgnoreCase("X"))) {
			System.out.println("Please select from one of the following options:");
			System.out.println(
					"\nA. Make a Reservation\nD. Display all Rooms\nR. Check out\nS. Search for a Room\nX. Exit\n");
			System.out.print("Enter your choice: ");
			res = input.nextLine();
			if (res.equalsIgnoreCase("A")) {
				System.out.println(
						"Here are the types of rooms we have: \n\n1.Double($50 per night per person)\n\n2.Standard($30 per night per person)\n\n3.Queen($90 per night per person)\n\n4.King($120 per night per person)\n\n5.Suite($250 per night per person)\n");
				System.out.print("Please enter what type of room you want: ");
				res = input.nextLine();
				if (res.equalsIgnoreCase("1")) {
					if (doubleav == 0) {
						System.out.print("Sorry there are no more Double rooms available!");
					} else {
						roomnumincrement++;
						roomNumber = "" + roomnumincrement;
						price = doubleprice;
						System.out.println("There are " + doubleav + " double rooms available");
						System.out.print("What is the name for the reservation?: ");
						occupants = input.nextLine();
						System.out.print("How many nights will you be staying?: ");
						stayDuration = input.nextInt();
						System.out.print("How many people will be staying in this room?: ");
						numGuest = input.nextInt();
						input.nextLine();
						System.out.println("Thank You!, We hope you enjoy your stay in room "+roomNumber+"!");
						d.ht.insert(new Hotel(roomNumber, occupants, "Double", stayDuration, numGuest, price));
						d.bst.insert(new Hotel(roomNumber, occupants, "Double", stayDuration, numGuest, price));
						d.bst2.insert(new Hotel2(roomNumber, occupants, "Double", stayDuration, numGuest, price));
						d.list.addLast(new Hotel2(roomNumber, occupants, "Double", stayDuration, numGuest, price));
						doubleav--;
					}
				} else if (res.equalsIgnoreCase("2")) {
					if (standardav == 0) {
						System.out.print("Sorry there are no more Standard rooms available!");
					} else {
						roomnumincrement++;
						roomNumber = "" + roomnumincrement;
						price = standardprice;
						System.out.println("There are " + standardav + " standard rooms available");
						System.out.print("What is the name for the reservation?: ");
						occupants = input.nextLine();
						System.out.print("How many nights will you be staying?: ");
						stayDuration = input.nextInt();
						System.out.print("How many people will be staying in this room?: ");
						numGuest = input.nextInt();
						input.nextLine();
						System.out.println("Thank You!, We hope you enjoy your stay in room "+roomNumber+"!");
						d.ht.insert(new Hotel(roomNumber, occupants, "Standard", stayDuration, numGuest, price));
						d.bst.insert(new Hotel(roomNumber, occupants, "Standard", stayDuration, numGuest, price));
						d.bst2.insert(new Hotel2(roomNumber, occupants, "Standard", stayDuration, numGuest, price));
						d.list.addLast(new Hotel2(roomNumber, occupants, "Standard", stayDuration, numGuest, price));
						standardav--;
					}

				} else if (res.equalsIgnoreCase("3")) {
					if (queenav == 0) {
						System.out.print("Sorry there are no more Queen rooms available!");
					} else {
						roomnumincrement++;
						roomNumber = "" + roomnumincrement;
						price = queenprice;
						System.out.println("There are " + queenav + " queen rooms available");
						System.out.print("What is the name for the reservation?: ");
						occupants = input.nextLine();
						System.out.print("How many nights will you be staying?: ");
						stayDuration = input.nextInt();
						System.out.print("How many people will be staying in this room?: ");
						numGuest = input.nextInt();
						input.nextLine();
						System.out.println("Thank You!, We hope you enjoy your stay in room "+roomNumber+"!");
						d.ht.insert(new Hotel(roomNumber, occupants, "Queen", stayDuration, numGuest, price));
						d.bst.insert(new Hotel(roomNumber, occupants, "Queen", stayDuration, numGuest, price));
						d.bst2.insert(new Hotel2(roomNumber, occupants, "Queen", stayDuration, numGuest, price));
						d.list.addLast(new Hotel2(roomNumber, occupants, "Queen", stayDuration, numGuest, price));
						queenav--;
					}

				} else if (res.equalsIgnoreCase("4")) {
					if (kingav == 0) {
						System.out.print("Sorry there are no more King rooms available!");
					} else {
						roomnumincrement++;
						roomNumber = "" + roomnumincrement;
						price = kingprice;
						System.out.println("There are " + kingav + " King rooms available");
						System.out.print("What is the name for the reservation?: ");
						occupants = input.nextLine();
						System.out.print("How many nights will you be staying?: ");
						stayDuration = input.nextInt();
						System.out.print("How many people will be staying in this room?: ");
						numGuest = input.nextInt();
						input.nextLine();
						System.out.println("Thank You!, We hope you enjoy your stay in room "+roomNumber+"!");
						d.ht.insert(new Hotel(roomNumber, occupants, "King", stayDuration, numGuest, price));
						d.bst.insert(new Hotel(roomNumber, occupants, "King", stayDuration, numGuest, price));
						d.bst2.insert(new Hotel2(roomNumber, occupants, "King", stayDuration, numGuest, price));
						d.list.addLast(new Hotel2(roomNumber, occupants, "King", stayDuration, numGuest, price));
						kingav--;
					}

				} else if (res.equalsIgnoreCase("5")) {
					if (suiteav == 0) {
						System.out.print("Sorry there are no more Suite rooms available!");
					} else {
						roomnumincrement++;
						roomNumber = "" + roomnumincrement;
						price = suiteprice;
						System.out.println("There are " + suiteav + " Suite rooms available");
						System.out.print("What is the name for the reservation?: ");
						occupants = input.nextLine();
						System.out.print("How many nights will you be staying?: ");
						stayDuration = input.nextInt();
						System.out.print("How many people will be staying in this room?: ");
						numGuest = input.nextInt();
						input.nextLine();
						System.out.println("Thank You!, We hope you enjoy your stay in room "+roomNumber+"!");
						d.ht.insert(new Hotel(roomNumber, occupants, "Suite", stayDuration, numGuest, price));
						d.bst.insert(new Hotel(roomNumber, occupants, "Suite", stayDuration, numGuest, price));
						d.bst2.insert(new Hotel2(roomNumber, occupants, "Suite", stayDuration, numGuest, price));
						d.list.addLast(new Hotel2(roomNumber, occupants, "Suite", stayDuration, numGuest, price));
						
						suiteav--;
					}
				}
			} else if (res.equalsIgnoreCase("D")) {
				System.out.print("Please select the number on how the data should be displayed:"
						+ "\nA. By the room number" + "\nB. By the guest name" + "\nC. As it is (unsorted database)\n");
				System.out.print("Type your answer:");
				res = input.nextLine();

				while (!((res.equalsIgnoreCase("A")) || res.equalsIgnoreCase("B") || res.equalsIgnoreCase("C"))) {
					System.out.print("Invalid selection!\n");
					System.out.print("Please enter A or B or C: ");
					res = input.nextLine();
					System.out.println();
				}

				if (res.equalsIgnoreCase("A")) {
					System.out.println();
					System.out.println("Displaying Hotel Data: ");
					System.out.println();
					d.bst.inOrderPrint();
				} else if (res.equalsIgnoreCase("B")) {
					System.out.println();
					System.out.println("Displaying Hotel Data: ");
					System.out.println();
					d.bst2.inOrderPrint();
				}

				else if (res.equalsIgnoreCase("C")) {
					System.out.println();
					System.out.println("Displaying Hotel Data: ");
					System.out.println();
					System.out.print(d.ht);
				}

			} else if(res.equalsIgnoreCase("R")) {
				System.out.print("What room number is being checked out of?: ");
				roomNumber = input.nextLine();
				int t = d.ht.search(new Hotel(roomNumber,"","",0,0,0));
				if(t==-1) {
					System.out.println("There is no one in checked in that room.\n");
				}
				else {
					d.ht.getBucket(t).placeIterator();
					for(int i =0; i<d.ht.getBucket(t).getLength();i++) {
						if(!(d.ht.getBucket(t).getIterator().getRoomNumber().equals(roomNumber))) {
							d.ht.getBucket(t).advanceIterator();
						}
					}
					System.out.print("We Hope you enjoyed your stay "+d.ht.getBucket(t).getIterator().getOccupants()+"! The total cost of your stay is $"+(d.ht.getBucket(t).getIterator().getPrice()*d.ht.getBucket(t).getIterator().getNumOfGuests()*d.ht.getBucket(t).getIterator().getStayDuration()+"\n"));
					d.ht.remove(new Hotel(roomNumber,"","",0,0,0));
					d.bst.remove(new Hotel(roomNumber,"","",0,0,0));
				}
			} else if (res.equalsIgnoreCase("S")) {
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
					while(true) {
					System.out.print("Room number you are looking for (01 - 80)[Double Digits Only!]: ");
					roomNumber = input.nextLine();
					Hotel temp = new Hotel(roomNumber, "", "", 0, 0, 0 );
					int inTable = d.ht.search(temp);
					if (inTable != -1) {
						System.out.println("Room "+roomNumber+" is occupied by "+d.ht.getBucket(inTable).getIterator().getOccupants());
						break;

					}else if(roomNumber.length()<2) {
						System.out.println("Invalid room number, must be double digits");
					}
					else {
						if(Integer.parseInt(roomNumber)<=80) {
						System.out.println("This room is available!");
						break;
						}
						else {
						System.out.println("There is no room with that room number!");
						}
					}
					}

				} else if (choice.equalsIgnoreCase("B")) {
					System.out.println("Searching by occupant's name!");
					System.out.println();
					System.out.print("Name of the occupant: ");
					occupants = input.nextLine();

					Hotel2 temp = new Hotel2("", occupants, "", 0, 0, 0 );
					int t = d.list.linearSearch(temp);
					if (t==-1) {
						System.out.println("There is no room occupied by " + occupants + "!");
					} else {
						d.list.placeIterator();
						for(int i=1; i<t;i++) {
							d.list.advanceIterator();
						}
						System.out.println(occupants+" is in room "+d.list.getIterator().getRoomNumber());
						
					}
				} else if (res.equalsIgnoreCase("X")) {
					break;
				}
			}
			

		}
		System.out.print("\nWould you like all room information to be updated to the current file? (Y/N):");
		res = input.nextLine();
		if (res.equalsIgnoreCase("y")) {
			System.out.print("\nPlease enter the name of the file you want to create: ");
			String filename = input.nextLine();
			File fileo = new File(filename);
			ObjectOutputStream out;
			String str = d.ht.toString();
			try {
				out = new ObjectOutputStream(new FileOutputStream(fileo));
				out.writeObject(str);
			} catch (Exception e) {
				System.out.printf("\nCannot Serialize");
			}
		} 
		System.out.print("GoodBye!");
		
	}
}
