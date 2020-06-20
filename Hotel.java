public class Hotel implements Comparable<Hotel> {
	private String roomNumber; // unique Key
	private String occupants; // secondary Key
	private String roomType;
	private int stayDuration;
	private int numOfGuests;
	private int price;

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
	public Hotel(String roomNumber, String occupants, String roomType, int stayDuration, int numOfGuests,
			int price) {
		this.roomNumber = roomNumber;
		this.occupants = occupants; // guest name
		this.roomType = roomType;
		this.stayDuration = stayDuration;
		this.numOfGuests = numOfGuests;
		this.price = price;
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
	public int getStayDuration() {
		return stayDuration;
	}

	/**
	 * Access the number of guests
	 * 
	 * @return number of guests
	 */
	public int getNumOfGuests() {
		return numOfGuests;
	}

	/**
	 * Sets the price
	 * 
	 * @return price
	 */
	public int getPrice() {
		return price;
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
	public void setStayDuration(int stayDuration) {
		this.stayDuration = stayDuration;
	}

	/**
	 * Sets the number of guests
	 * 
	 * @param number of guests
	 */
	public void setNumOfGuests(int numOfGuests) {
		this.numOfGuests = numOfGuests;
	}

	/**
	 * Sets the price
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Creates a String of the Hotel information the following format: Room Number:
	 * <roomNumber> Occupant: <occupants> Room Type: <roomType> Duration of staying:
	 * $<stayDuration>
	 */
	@Override
	public String toString() {
		String result = "Room Number: " + roomNumber + "\nOccupant: " + occupants + "\nDuration of Stay: "
				+ stayDuration +  " days" + "\nRoom Type: " + roomType + "\nNumber of Guests: " + numOfGuests;
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
	 * Compares two when room number objects to determine ordering Returns 0 if the
	 * two items are equal Return -1 if this Hotel's room number comes before the
	 * other Hotel's room number. Returns 1 if the other Hotel's room number comes
	 * before this Hotel's room number If the two Hotel's room numbers are the same,
	 * will differentiate by occupants (alphabetical comparison)
	 * 
	 * @param the other Hotel object to compare to this
	 * @return 0 (same room), -1 (this room ordered first) or 1 (the other room
	 *         ordered first)
	 */
	@Override
	public int compareTo(Hotel otherRoom) {
		if (this.equals(otherRoom)) {
			return 0;
		} else if (!(this.roomNumber.equals(otherRoom.roomNumber))) {
			return this.roomNumber.compareTo(otherRoom.roomNumber); // when room numbers are different
		} else {
			return this.occupants.compareTo(otherRoom.occupants); // guest name is secondary key
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

}
