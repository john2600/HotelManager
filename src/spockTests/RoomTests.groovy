package spockTests

import models.Room
import org.junit.Test
import spock.lang.*
import models.RoomFeatures

public class RoomTests extends Specification {

	@Test
	def "room max occupancy"() {
		setup:
		Room room = new Room()
		
		when:
		room.doubleBeds = doublebeds
		room.singleBeds = singlebeds
		
		
		then:
		room.getMaxOccupancy()==occupancy
		
		
		where:
		doublebeds |singlebeds |occupancy
		2		   |0  		   |4
		1		   |0		   |2
		2		   |0		   |4
		1		   |3  		   |5
		2		   |2		   |6
		3		   |1		   |7
			
		
		
	}

}
