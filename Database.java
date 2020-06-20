import java.util.Scanner;
import java.io.*;

public class Database {
	private final int Num_Room = 40;
	Hash<Hotel>ht = new Hash<>(Num_Room*2);
	BST<Hotel> bst = new BST<>();
	
	public static void main(String[]args) {
		Database d = new Database();
		Hotel h = null;
		String roomNumber;
		String occupants;
		String res="";
		String a = "";
		String roomType;
		String stayDuration;
		int numGuest;
		int floor;
		double price;
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
			price = input1.nextDouble();
			
			if (input1.hasNextLine()) {
				input1.nextLine();
				input1.nextLine();
			}
			
			h= new Hotel(roomNumber, occupants, stayDuration, roomType, numGuest, floor, price);
			d.ht.insert(h);
			d.bst.insert(h);
		}
		input1.close();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to ADT Hotel");
		while(!(res.equalsIgnoreCase("q"))) {
			System.out.println("Please select from one of the following options: \n");

			System.out.println(
					"A. Make a Reservation\nD. Display all Rooms\nR. Check out\nS. Search for a Room\nX. Exit\n");
			System.out.print("Enter your choice: ");
			res = input.nextLine();
			if(res.equalsIgnoreCase("A")) {
				System.out.print("Please enter what type of room you want: ");
				
			}
		}
		
		
	}
}
