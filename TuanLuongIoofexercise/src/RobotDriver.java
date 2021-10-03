import java.util.HashMap;

public class RobotDriver { //Provides a class to manage multiple robots. 

	private HashMap<Integer, Robot> robotMap; //Hashmap to store current Robots
	private int noRobots; //Number of robots on the map
	private int currentrobot; // Current robot.
	
	public RobotDriver() {
		this.robotMap = new HashMap<Integer, Robot>();
		this.noRobots =0;
		this.currentrobot=0;
	}
	
	public void placeRobot(int x, int y, String dir ) {
		
		Direction direction = parseDirectionString(dir);
		Robot newRobot = new Robot(x,y,direction);
		if(this.noRobots==0) { //If the number of robots is zero, sets the current default robot to 0.
			this.currentrobot=1;
		}
		this.noRobots++; //Increments number of robots
		this.robotMap.put(this.noRobots, newRobot); //Adds the new Robot to the HashMap
	}
	
	
	private Direction parseDirectionString(String dir) {//Method to convert string to direction
		Direction returnDir =Direction.NORTH;
		switch(dir) {
		case "EAST":
			returnDir=Direction.EAST;
			break;
		case "NORTH": 
			returnDir = Direction.NORTH;
			break;
		case "WEST":
			returnDir = Direction.WEST;
			break;
		case "SOUTH":
			returnDir = Direction.SOUTH;
			break;
		}
		
		return returnDir;
	}
	
	private Robot getCurrentRobot() {//Private method to return current robot. 
		return this.robotMap.get(this.currentrobot);
	}
	
	private void placeCurrentRobot(int index, Robot rb) { //Private Method to place current robot after state change
		this.robotMap.put(index, rb);
	}
	
	public void setRobot(int index) {//Sets the current robot
		this.currentrobot=index;
		System.out.println("Robot " + this.currentrobot + " Activivated");
	}
	
	public void Left() { //makes current robot turn left
		Robot rb = getCurrentRobot();
		rb.left();
		placeCurrentRobot(this.currentrobot, rb);
	}
	
	public void Right() { //Makes current robot turn right 
		Robot rb = getCurrentRobot();
		rb.right();
		placeCurrentRobot(this.currentrobot, rb);
	}
	
	public void Move() { //Moves the current Robot 
		Robot rb = getCurrentRobot();
		rb.move();
		placeCurrentRobot(this.currentrobot, rb);
	}
	
	public void Report() { //Reports current robot position and number of Robots. 
		String output="Current Robot: " +this.currentrobot + "\n" + "Number of Robots: " +
		this.noRobots + "\n";
		Robot rb = getCurrentRobot();
		output = output + rb.Report();
		System.out.println(output);
	
	}

	
	
	
	
	
	
	

}
