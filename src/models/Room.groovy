package models

class Room {
	int roomNumber
	int singleBeds 
	int doubleBeds
	ArrayList<RoomFeatures> features = []
	
	
	def getMaxOccupancy(){
		return (2 * doubleBeds) + singleBeds
	}
}
