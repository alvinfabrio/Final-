/**
 * Hotel2.java
 * 
 * @author Rida Abdulwasay – Pro Team Coordinator
 * @author Ameya Dighe – Screen Output Expert
 * @author Alvin Fabrio – Hash Table Whiz
 * @author Daozhen (Leslie) Liu – BST Algorithms Specialist
 * @author Samantha Tancio – Presentation Guru
 * @author Vinh Vu – File I/O Ace
 * 
 * CIS 22C Project
 * 
 */

public class Hotel2 extends Hotel implements Comparable<Hotel> {

	/**
	 * Constructor for the Hotel class
	 * 
	 * @param roomNumber   the room number
	 * @param occupants    the name of the occupant
	 * @param roomType     the room type
	 * @param stayDuration the staying duration of the occupant
	 * @param numOfGuests  the number of guests
	 * @param floor        the floor number of the room
	 * @param price        the price of the room
	 * 
	 */
	public Hotel2(String roomNumber, String occupants, String roomType, int stayDuration, int numOfGuests,
			int price) {
		
		super (roomNumber, occupants, roomType, stayDuration, numOfGuests, price);
	}

	
	@Override
	public boolean equals(Object o) {
		if (this == o) { // same memory address (nulls also)
			return true;
		} else if (!(o instanceof Hotel2)) {
			return false;
		} else {
			Hotel2 otherHotel = (Hotel2) o;
			return this.getOccupants().equals(otherHotel.getOccupants());
		}

	}

	/**
	 * Compares two when room number objects to determine ordering Returns 0 if the
	 * two items are equal 
	 * Return -1 if this Hotel's room number comes before the
	 * other Hotel's room number. 
	 * Returns 1 if the other Hotel's room number comes before
	 * this Hotel's room number 
	 * If the two Hotel's room numbers are the same, will
	 * differentiate by occupants (alphabetical comparison)
	 * 
	 * @param the other Hotel object to compare to this
	 * @return 0 (same room), -1 (this room ordered first) or 1 (the other room
	 *         ordered first)
	 */
	@Override
	public int compareTo(Hotel otherRoom) {
		if (this.equals(otherRoom)) {
			return 0;
		} else if (!(this.getOccupants().equals(otherRoom.getOccupants()))) {
			return this.getOccupants().compareTo(otherRoom.getOccupants()); // when room numbers are different
		} else {
			return this.getOccupants().compareTo(otherRoom.getOccupants()); // guest name is secondary key
		}

	}

	

}
