
package models

import org.joda.time.DateTime;
import org.joda.time.LocalDate

class HotelManager {
	ArrayList<Room> rooms = []
	ArrayList<Booking> bookings = []

	void setUpTestRooms() {
		Room room1 = new Room(roomNumber: 1, doubleBeds: 1, features: [RoomFeatures.NON_SMOKING,RoomFeatures.WHEELCHAIR_ACCESS,RoomFeatures.SEA_VIEW] )
		Room room2 = new Room(roomNumber: 2, singleBeds: 1, features: [RoomFeatures.WHEELCHAIR_ACCESS] )
		Room room3 = new Room(roomNumber: 3, singleBeds: 2, features: [RoomFeatures.NON_SMOKING,RoomFeatures.SEA_VIEW] )
		Room room4 = new Room(roomNumber: 4, doubleBeds: 1, features: [RoomFeatures.NON_SMOKING,RoomFeatures.HAS_JACCUZI] )
		Room room5 = new Room(roomNumber: 5, doubleBeds: 2,  features: [RoomFeatures.NON_SMOKING,RoomFeatures.WHEELCHAIR_ACCESS,RoomFeatures.SEA_VIEW] )
		Room room6 = new Room(roomNumber: 6, doubleBeds: 1, singleBeds: 2, features: [RoomFeatures.WHEELCHAIR_ACCESS,RoomFeatures.SEA_VIEW] )
		Room room7 = new Room(roomNumber: 7, doubleBeds: 1, singleBeds: 2, features: [RoomFeatures.NON_SMOKING,RoomFeatures.SEA_VIEW] )
		Room room8 = new Room(roomNumber: 8, doubleBeds: 2, features: [RoomFeatures.NON_SMOKING,RoomFeatures.SEA_VIEW] )
		Room room9 = new Room(roomNumber: 9, doubleBeds: 1, features: [RoomFeatures.NON_SMOKING,RoomFeatures.WHEELCHAIR_ACCESS,RoomFeatures.SEA_VIEW] )
		Room room10 = new Room(roomNumber: 10, singleBeds: 1, features: [RoomFeatures.NON_SMOKING,RoomFeatures.SEA_VIEW] )
		Room room11 = new Room(roomNumber: 11, doubleBeds: 1, features: [RoomFeatures.WHEELCHAIR_ACCESS,RoomFeatures.HAS_JACCUZI] )
		Room room12 = new Room(roomNumber: 12, singleBeds: 1, features: [RoomFeatures.NON_SMOKING,RoomFeatures.SEA_VIEW] )
		Room room13 = new Room(roomNumber: 13, singleBeds: 2, features: [RoomFeatures.WHEELCHAIR_ACCESS] )
		Room room14 = new Room(roomNumber: 14, doubleBeds: 1, features: [RoomFeatures.SEA_VIEW] )
		
		rooms << room1 << room2 << room3 << room4 << room5 << room6 << room7 << room8 << room9 << room10 << room11 << room12 << room13 << room14
	}

	void addBooking(Booking booking) {
		if(!isRoomBooked(booking.room, booking.date)){
			bookings << booking
		} else {
			throw new BookingClashException()
		}
		
	}
	Booking retrieveBooking(Booking booking){
		bookings.find{ it.room.equals(booking)}
		
	}

	Booking getBooking(Room room,LocalDate date) {
		bookings.find{ it.room == room && it.date == date}
	}

	boolean isRoomBooked(Room room,LocalDate date) {
		 getBooking(room, date)!=null?true:false
	}
	
	def getListBooking(){
		bookings
	}


}