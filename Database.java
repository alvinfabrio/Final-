import java.util.Scanner;
import java.io.*;

public class Database {
	private final int Num_Room = 0;
	Hash<Hotel>ht = new Hash<>(Num_Room*2);
	BST<Hotel> bst = new BST<>();
	
	public static void main(String[]args) {
		Database d = new Database();
		Hotel h = null;
		String roomNumber;
		String occupants;
		String res;
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
		
		
	}
}
