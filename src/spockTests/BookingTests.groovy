package spockTests

import models.Booking
import models.BookingClashException
import models.Customer
import models.HotelManager
import models.Room
import org.joda.time.DateTime
import org.joda.time.LocalDate
import spock.lang.*

class BookingTests extends Specification {

	def "add and retrieve a booking" () {
		setup:
		def room1 = new Room(roomNumber: 1)
		def room2 = new Room(roomNumber: 2)
		
		def date1 = new LocalDate(2015,5,3)
		def date2 = new LocalDate(2015,5,4)
		
		def customer = new Customer(name: "Sandra Taylor")
		
		HotelManager hm = new HotelManager()
		def newBooking = new Booking(customer: customer, date: date1, room: room1)
		hm.addBooking(newBooking)
		
		expect:
		hm.bookings.size() == 1
		hm.getBooking(room1, date1) == newBooking
		hm.getBooking(room2, date1) == null
		hm.getBooking(room1, date2) == null
		hm.getBooking(room2, date2) == null
	}

	def "booking fails due to a clash" () {
		def room1 = new Room(roomNumber: 1)
		def date1 = new LocalDate(2015,5,3)
		def customer = new Customer(name: "Sandra Taylor")
		
		HotelManager hm = new HotelManager()
		def newBooking = new Booking(customer: customer, date: date1, room: room1)
		hm.addBooking(newBooking)
		
		when:
		hm.addBooking(newBooking)
		
		then:
		BookingClashException ex = thrown()
		hm.bookings.size() == 1
	}


}
