
package UI

import models.*

import org.joda.time.*

def hm = new HotelManager()
hm.setUpTestRooms()

def customer1 = new Customer(name: "Matt Greencroft",address: "1 Some Road,  My Town",eMail: "matt@somecompany.com",phoneNumber: "012345")
def customer2 = new Customer(name: "David Williams",address: "3 High Street,  My Town",eMail: "david@somecompany.com",phoneNumber: "012345" )
def customer3 = new Customer(name: "Michelle Black",address: "17 Low Avenue,  My Town",eMail: "michelle@somecompany.com",phoneNumber: "012345" )

def today = new LocalDate()
def booking1 = new Booking(customer: customer1,date: today, room: hm.rooms[3] )
def booking2 = new Booking(customer: customer2,date: today, room: hm.rooms[7] )
def booking3 = new Booking(customer: customer3,date: today, room: hm.rooms[8] )

hm.addBooking(booking1)
hm.addBooking(booking2)
hm.addBooking(booking3)

def hr = new HotelReports()
hr.printTodaysBookings(hm)
hr.runRoomReports(hm)