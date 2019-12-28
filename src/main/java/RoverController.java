
public class RoverController {
	
	public RoverController(Rover rover){
        
	}
    Rover rover = new Rover(); 
	public String excute(String mission) {
	 
		String [] commond = mission.split(",");
        Area area = new Area(Integer.valueOf(commond[0]),Integer.valueOf(commond[1]));
        
        char dir = commond[4].charAt(0);
        System.out.print(commond[4]);
        int facing = 0;
        if (dir == 'N') {
           facing = 1;
        } else if (dir == 'E') {
           facing = 2;
        } else if (dir == 'S') {
           facing = 3;
        } else if (dir == 'W') {
           facing = 4;
        } 
        System.out.print(facing);
        rover.land(area,Integer.valueOf(commond[2]),Integer.valueOf(commond[3]),facing);
        for (int idx = 5; idx < commond.length; idx++) {
            process(commond[idx]);
            System.out.print(commond[idx]);
        }
        return rover.getPosition();
       }
    public void process(String commond) {
    	char dir = commond.charAt(0);
        if (dir == 'L') {
        	rover.turnLeft();
        } else if (dir == 'R') {
        	rover.turnRight();
        } else if (dir == 'M') {
        	rover.move();
        } else {
         throw new IllegalArgumentException(
           "Speak in Mars language, please!");
        }
    }
}