
public class Robot {

	private int x; //Instance Variables
	private int y;
	private Direction direction;
	
	public Robot(int xin, int yin, Direction dir) {
		this.x=xin;
		this.y=yin;
		this.direction=dir;
		
	}
	//Method to move robot left
	public void left() {
		
		switch(this.direction) { //Switch statement to determine the direction robot faces after turning
		case EAST:
			this.direction =Direction.NORTH;
			break;
		case NORTH: 
			this.direction = Direction.WEST;
			break;
		case WEST:
			this.direction = Direction.SOUTH;
			break;
		case SOUTH:
			this.direction = Direction.EAST;
			break;
		
		}
	}
	
	//Method to move right
	public void right() {
		switch(this.direction) { //Switch statement to determine the direction robot faces after turning
		case EAST:
			this.direction =Direction.SOUTH;
			break;
		case NORTH: 
			this.direction = Direction.EAST;
			break;
		case WEST:
			this.direction = Direction.NORTH;
			break;
		case SOUTH:
			this.direction = Direction.WEST;
			break;
		
		}
	}
	
	public void move() { //Method to move robot
		int x=this.x; //Temporary Variables to check if the movement is in range. 
		int y = this.y;
		switch(this.direction) { //Switch statement to determine the position the robot changes. 
		case EAST:
			x++; //Moves robot facing east based on origin of SW of (0,0)
			if(inRange(x)==true) { //Check is move is in range, if it is reassigns instance variable
				this.x=x;
			}
			break;
		case NORTH:
			y++; // Moves robot facing north. 
			
			if(inRange(y)==true) {
				this.y=y;
			}
			break;
		case WEST:
			x--; //Moves robot facing West
			if(inRange(x)==true) {
				this.x=x;
			}
			break;
		case SOUTH:
			y--; //Moves robot facing south
			if(inRange(y)==true) {
				this.y=y;
			}
			break;
		
		}
	}
	
	//Method to report direction.
	public String Report() {
		return this.x +","+this.y+","+this.direction;
	}
	
	//Determines if the variable is within the range of the table
	private boolean inRange(int var) {
		if (var<0 || var>4 ) {
			return false;
		} 
		return true;
	}
	
	
}


