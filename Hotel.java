
/**
 * Hotel.java
 * @author Ezekiel Chow
 * @author Alvin Fabrio
 * CIS 22C, Lab 5
 */



public class Hotel implements Comparable<Hotel> {
	private String roomN;
	private String roomNumber; // unique Key 
	private String occupants; // secondary Key 
	private String roomType; 
	private String stayDuration;

	/**
	 * Constructor for the Hotel class
	 * 
	 * @param roomNumber   the room number
	 * @param occupants    the name of the occupant
	 * @param roomType     the room type
	 * @param stayDuration the staying duration of the occupant
	 *                
	 */
	public Hotel(String roomNumber, String occupants, String roomType, String stayDuration) {
		this.roomNumber = roomNumber;
		this.occupants = occupants;
		this.roomType = roomType;
		this.stayDuration = stayDuration;
	}

	/**
	 * Accesses the room number of the Hotel
	 * 
	 * @return the room number
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Accesses the occupant of the room 
	 * 
	 * @return the occupant
	 */
	public String getOccupants() {
		return occupants;
	}

	/**
	 * Access the room type
	 * 
	 * @return the room type
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Access the staying duration of the occupant
	 * 
	 * @return the staying duration
	 */
	public String getStayDuration() {
		return stayDuration;
	}

	/**
	 * Sets the room Number
	 * 
	 * @param roomNumber the Hotel's roomNumber
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Sets the occupant of the room
	 * 
	 * @param occupants the Hotel's occupant
	 */
	public void setOccupants(String occupants) {
		this.occupants = occupants;
	}

	/**
	 * Sets the room type
	 * 
	 * @param roomType the Hotel's roomType
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * Sets the staying duration
	 * 
	 * @param stayDuration the Occupant's staying duration
	 */
	public void setStayDuration(String stayDuration) {
		this.stayDuration = stayDuration;
	}

	/**
	 * Creates a String of the Hotel information the following format: Room Number:
	 * <roomNumber> Occupant: <occupants> Room Type: <roomType> Duration of staying: $<stayDuration>

	 */
	@Override
	public String toString() {
		String result = "Room Number: " + roomNumber + "\nOccupant: " + occupants + "\nRoom Type: " + roomType + "\nDuration of staying: "
				+ stayDuration + " Days";
		return result;
	}

	/**
	 * Determines whether two Hotel objects are equal by comparing roomNumber and
	 * occupants
	 * 
	 * @param otherHotel the second Hotel object
	 * @return whether the two room in the Hotels are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) { // same memory address (nulls also)
			return true;
		} else if (!(o instanceof Hotel)) {
			return false;
		} else {
			Hotel otherHotel = (Hotel) o;

			return this.roomNumber.equals(otherHotel.roomNumber) && this.occupants.equals(otherHotel.occupants);
		}

	}

	/**
	 * Compares two Hotel objects to determine ordering Returns 0 if the two items
	 * are equal Return -1 if this Hotel's title comes alphabetically before the
	 * other Hotel's title. Returns 1 if the other Hotel's title comes
	 * alphabetically before this Hotel's title If the two Hotel's titles are the
	 * same, will differentiate by director's name (alphabetical comparison)
	 * 
	 * @param the other Hotel object to compare to this
	 * @return 0 (same Hotel), -1 (this Hotel ordered first) or 1 (the other Hotel
	 *         ordered first)
	 */
	@Override
	public int compareTo(Hotel otherRoom) {
		if (this.equals(otherRoom)) {
			return 0;
		} else if (!(this.roomNumber.equals(otherRoom.roomNumber))) {
			return this.roomNumber.compareTo(otherRoom.roomNumber); // when titles are different
		} else {
			return this.occupants.compareTo(otherRoom.occupants);
		}
		
	}

	/**
	 * Returns a consistent hash code for each Hotel by summing the Unicode values
	 * of each character in the key Key = title + director
	 * 
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		String key = roomNumber + occupants;
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		return sum;
	}
	
	/**@Override
	public int hashCode() {
		String key = roomNumber + occupants;
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += (int) key.charAt(i);
		}
		return sum;
	}
	*/

}