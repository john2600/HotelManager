package UI

import models.HotelManager
import models.RoomFeatures;

import org.joda.time.LocalDate

class HotelReports {

	void runRoomReports(HotelManager hm) {
		println "Hotel Room Report - ${new LocalDate()}"
		println ""
		def totalGuests = hm.rooms.sum {it.getMaxOccupancy()}
		println "The hotel can sleep $totalGuests guests."
		println ""
		def foundRooms = hm.rooms.findAll {it.getMaxOccupancy() >= 2}
		println "The following ${foundRooms.size()} rooms can sleep 2 or more people:"
		foundRooms.each { println "Room number $it.roomNumber - sleeps ${it.getMaxOccupancy()}"}
		println ""
		
		foundRooms = hm.rooms.findAll {it.features.contains(RoomFeatures.SEA_VIEW)}
		println "The following ${foundRooms.size()} rooms have a sea view:"
		foundRooms.each { println "Room number $it.roomNumber - sleeps ${it.getMaxOccupancy()}"}
		println ""
	}

	void printTodaysBookings(HotelManager hm) {
		def today = new LocalDate()
		def todaysBookings = hm.bookings.findAll {it.date == today}
		println "Today's bookings: ${todaysBookings.size()}"
		todaysBookings.each {
			println "Customer: $it.customer.name - Room: $it.room.roomNumber"
		}
	}
}
