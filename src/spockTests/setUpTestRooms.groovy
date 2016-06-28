package spockTests;

import static org.junit.Assert.*;

import models.Booking
import models.Customer
import models.HotelManager
import models.Room
import org.joda.time.LocalDate
import org.junit.Test;
import models.RoomFeatures

class setUpTestRooms {

	@Test
	public void shouldCountAllTheRoomsThatExist() {
		// given
		HotelManager hotel = new HotelManager()

		// when
		hotel.setUpTestRooms()

		// then
		assert hotel.rooms.size()==14


	}

	@Test
	public void shouldAddNewBook(){
		// given
		HotelManager hotel = new HotelManager()
		// and
		Booking book = new Booking()
		Booking book2 = new Booking()
		Booking book3 = new Booking()
		Booking book4 = new Booking()
		Booking book5 = new Booking()

		//when
		hotel.addBooking(book)
		hotel.addBooking(book2)
		hotel.addBooking(book3)
		hotel.addBooking(book4)
		hotel.addBooking(book5)

		//then
		hotel.bookings.get(0) == book
		hotel.bookings.get(1) == book2
		hotel.bookings.get(2) == book3
		hotel.bookings.get(3) == book4
		hotel.bookings.get(4) == book5


	}

	@Test
	public void shouldFindABook(){
		// give
		HotelManager hotel = new HotelManager()

		Room room = new Room(roomNumber: 30, doubleBeds: 1, features: [RoomFeatures.NON_SMOKING,RoomFeatures.WHEELCHAIR_ACCESS,RoomFeatures.SEA_VIEW] )
		LocalDate date = new LocalDate(2016,06,28)
		def book2 = new Booking(
				customer:new Customer(name: "Matt Greencroft",address: "1 Some Road,  My Town",eMail: "matt@somecompany.com",phoneNumber: "012345")
				,
				room:room,
				date:new LocalDate(2016,06,28))

		def book3 = new Booking(
				customer:new Customer(name: "David Williams",address: "3 High Street,  My Town",eMail: "david@somecompany.com",phoneNumber: "012345" )
				,room:new Room(),date:new LocalDate())

		def book4 = new Booking(
				customer:new Customer(name: "Michelle Black",address: "17 Low Avenue,  My Town",eMail: "michelle@somecompany.com",phoneNumber: "012345" ),
				,room:new Room(),date:new LocalDate())

		// and
		hotel.addBooking(book2)
		hotel.addBooking(book3)
		hotel.addBooking(book4)
	
		// when
		def subject = hotel.getBooking(room,date)
		

		// then
		assert subject == book2


	}
}
