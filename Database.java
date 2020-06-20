import java.util.Scanner;
import java.io.*;

public class Database {
	private final int Num_Room = 40;
	Hash<Hotel> ht = new Hash<>(Num_Room * 2);
	BST<Hotel> bst = new BST<>();

	public static void main(String[] args) {
		Database d = new Database();
		Hotel h = null;
		String roomNumber;
		String occupants;
		String res = "";
		String a = "";
		String roomType;
		String stayDuration;
		int numGuest;
		int suiteav = 5, standardav = 9, queenav = 7, kingav = 8, doubleav = 11;
		int floor;
		int price, suiteprice = 250, standardprice = 30, doubleprice = 50, queenprice = 90, kingprice = 120;
		int roomnumincrement = 40;
		int choice;
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
			stayDuration = input1.nextLine();
			numGuest = input1.nextInt();
			price = input1.nextInt();
			
			if (input1.hasNextLine()) {
				input1.nextLine();
				input1.nextLine();
			}
			
			h = new Hotel(roomNumber, occupants, roomType, stayDuration, numGuest, price);
			d.ht.insert(h);
			d.bst.insert(h);
		}
		input1.close();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to ADT Hotel");
		while (!(res.equalsIgnoreCase("X"))) {
			System.out.println("Please select from one of the following options: \n");

			System.out.println(
					"A. Make a Reservation\nD. Display all Rooms\nR. Check out\nS. Search for a Room\nX. Exit\n");
			System.out.print("Enter your choice: ");
			res = input.nextLine();

			System.out.println();

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
						price = doubleprice;
						System.out.println("There are "+doubleav+" double rooms available");
						System.out.print("What is the name for the reservation?: ");
						occupants = input.nextLine();
						System.out.print("How long is the stay?: ");
						stayDuration=input.nextLine();
						System.out.print("How many people will be staying in this room?: ");
						numGuest = input.nextInt();
						d.ht.insert(new Hotel(roomNumber, occupants, "Double", stayDuration, numGuest, price));
						d.bst.insert(new Hotel(roomNumber, occupants, "Double", stayDuration, numGuest, price));
						doubleav--;
					}		
				}else if(res.equalsIgnoreCase("Standard")) {
					roomnumincrement++;
					roomNumber = ""+roomnumincrement;
					price = standardprice;
					System.out.println("There are "+standardav+" standard rooms available");
					System.out.print("What is the name for the reservation?: ");
					occupants = input.nextLine();
					System.out.print("How long is the stay?: ");
					stayDuration=input.nextLine();
					System.out.print("How many people will be staying in this room?: ");
					numGuest = input.nextInt();
					d.ht.insert(new Hotel(roomNumber, occupants, "Standard", stayDuration, numGuest, price));
					d.bst.insert(new Hotel(roomNumber, occupants, "Standard", stayDuration, numGuest, price));
					standardav--;
					
				}else if(res.equalsIgnoreCase("Queen")) {
					roomnumincrement++;
					roomNumber = ""+roomnumincrement;
					price = queenprice;
					System.out.println("There are "+queenav+" queen rooms available");
					System.out.print("What is the name for the reservation?: ");
					occupants = input.nextLine();
					System.out.print("How long is the stay?: ");
					stayDuration=input.nextLine();
					System.out.print("How many people will be staying in this room?: ");
					numGuest = input.nextInt();
					d.ht.insert(new Hotel(roomNumber, occupants, "Queen", stayDuration, numGuest, price));
					d.bst.insert(new Hotel(roomNumber, occupants, "Queen", stayDuration, numGuest, price));
					queenav--;
					
				}else if(res.equalsIgnoreCase("King")) {
					roomnumincrement++;
					roomNumber = ""+roomnumincrement;
					price = kingprice;
					System.out.println("There are "+kingav+" King rooms available");
					System.out.print("What is the name for the reservation?: ");
					occupants = input.nextLine();
					System.out.print("How long is the stay?: ");
					stayDuration=input.nextLine();
					System.out.print("How many people will be staying in this room?: ");
					numGuest = input.nextInt();
					d.ht.insert(new Hotel(roomNumber, occupants, "King", stayDuration, numGuest, price));
					d.bst.insert(new Hotel(roomNumber, occupants, "King", stayDuration, numGuest, price));
					kingav--;
					
				}else if(res.equalsIgnoreCase("Suite")) {
					roomnumincrement++;
					roomNumber = ""+roomnumincrement;
					price = suiteprice;
					System.out.println("There are "+suiteav+" Suite rooms available");
					System.out.print("What is the name for the reservation?: ");
					occupants = input.nextLine();
					System.out.print("How long is the stay?: ");
					stayDuration=input.nextLine();
					System.out.print("How many people will be staying in this room?: ");
					numGuest = input.nextInt();
					d.ht.insert(new Hotel(roomNumber, occupants, "Suite", stayDuration, numGuest, price));
					d.bst.insert(new Hotel(roomNumber, occupants, "Suite", stayDuration, numGuest, price));
					suiteav--;
				}
				
				
				
			}
				} else if (res.equalsIgnoreCase("Standard")) {

				} else if (res.equalsIgnoreCase("Queen")) {

				} else if (res.equalsIgnoreCase("King")) {

				} else if (res.equalsIgnoreCase("Suite")) {

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
					d.bst.preOrderPrint();
				} else if (res.equalsIgnoreCase("B")) {
					System.out.println();
					System.out.println("Displaying Hotel Data: ");
					System.out.println();
					d.bst.inOrderPrint();
				}

				else if (res.equalsIgnoreCase("C")) {
					System.out.println();
					System.out.println("Displaying Hotel Data: ");
					System.out.println();
					System.out.print(d.ht);
				}

			} else if (res.equalsIgnoreCase("R")) {

			} else if (res.equalsIgnoreCase("S")) {

			} else if (res.equalsIgnoreCase("X")) {
				break;
			}
		}
		System.out.print("Would you like all room information to be put into a file?(Y/N)");
		res = input.nextLine();
		if (res.equalsIgnoreCase("y")) {
			System.out.print("Please enter the name of the file you want to create: ");
			String filename = input.nextLine();
			File fileo = new File(filename);

		} else {
			System.out.print("GoodBye!");
		}

	}
}
