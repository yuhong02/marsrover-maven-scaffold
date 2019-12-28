
public class Rover {
	public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    Integer x = 0;
    Integer y = 0;
    Integer facing = N;
    public void Rover() {
    }
    public void setPosition(Integer x, Integer y, Integer facing) {
     this.x = x;
     this.y = y;
     this.facing = facing;
    }
    public void printPosition() {
     char dir = 'N';
     if (facing == 1) {
      dir = 'N';
     } else if (facing == 2) {
      dir = 'E';
     } else if (facing == 3) {
      dir = 'S';
     } else if (facing == 4) {
      dir = 'W';
     }
     System.out.println(x  + " "  + y   +" "  + dir);
    }
    public void land(Area area, int x1, int y1, Integer facing) {
    	if (x > 10 || y > 10)
        {
    		throw new IllegalArgumentException("x=" + x1 + "is out of area with 10");
    	}
    	if (x < 10 && y < 10){
        	this.x = x1;
        	this.y = y1;
        	this.facing = facing;
        }

    }
    
    public String getPosition(){
        char dir = 'N';
        if (facing == 1) {
         dir = 'N';
        } else if (facing == 2) {
         dir = 'E';
        } else if (facing == 3) {
         dir = 'S';
        } else if (facing == 4) {
         dir = 'W';
        }
        System.out.println(x  + " "  + y   +" "  + dir);      
    	String postion = " " +x  + y  + dir;
		return postion.trim();
    }
    
    public void process(String commands) {
     for (int idx = 0; idx < commands.length(); idx++) {
      process(commands.charAt(idx));
     }
    }
    public void process(Character command) {
     if (command.equals('L')) {
      turnLeft();
     } else if (command.equals('R')) {
      turnRight();
     } else if (command.equals('M')) {
      move();
     } else {
      throw new IllegalArgumentException(
        "Speak in Mars language, please!");
     }
    }
    public void move() {
     if (facing == N) {
      this.y ++  ;
     } else if (facing == E) {
      this.x ++ ;
     } else if (facing == S) {
      this.y--;
     } else if (facing == W) {
      this.x--;
     }
    }
    public void turnLeft() {
     facing = (facing - 1) < N ? W : facing - 1;
    }
    public void turnRight() {
     facing = (facing  - 1) > W ? N : facing - 1;
    }
    public static void main(String args[]) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        rover.printPosition(); // prints 1 3 N
        rover.setPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        rover.printPosition(); // prints 5 1 E
       }
}
