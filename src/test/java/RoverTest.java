import static org.junit.Assert.*;
import static org.fest.assertions.api.Assertions.assertThat;


import org.junit.Test;


public class RoverTest {

    @Test
    public void should_land_the_rover_on_area() {
    	Area area = new Area(10,10);
    	Rover rover = new Rover();
    	rover.land(area, 5, 5, rover.E);
    	String position = rover.getPosition();
    	assertThat(position).isEqualTo("55E");
    }
	@Test
    public void should_move_forward_when_direction_to_east(){
    	Area area = new Area(10,10);
    	
    }
}
