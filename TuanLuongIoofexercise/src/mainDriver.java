import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class mainDriver {
	public static void main(String[] args) {
		RobotDriver driver = new RobotDriver();
		try {
			FileReader fr = new FileReader("src/sampleinput.txt"); //Read data from input text
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line!=null) {
				String [] arr = line.split(" ");//Splits current line into array
				String selection = arr[0].toUpperCase(); //Makes the selection  uppercase
				switch (selection) { //Switch statements on selections
				case "PLACE": 
					String parameterstring = arr[1]; //Gets the string of parameters
					String [] params = parameterstring.split(","); //Further splits this string into individual parameters
					int x = Integer.parseInt(params[0]); //Assigns each parameter to coordinate and direction 
					int y = Integer.parseInt(params[1]);
					driver.placeRobot(x, y, params[2].toUpperCase());
					break;
				case "MOVE":
					driver.Move();
					break;
				case "LEFT":
					driver.Left();
					break;
				case "REPORT":
					driver.Report();
					break;
				case "ROBOT":
					int robotselection = Integer.parseInt(arr[1]);
					driver.setRobot(robotselection);
				
				}
			line = br.readLine();
			}
			br.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
}
