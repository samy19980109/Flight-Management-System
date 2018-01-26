import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class FlightSchedule {

	public static void main(String[] args) throws IOException {
		String getInput = new String();
		Scanner x = new Scanner(System.in);
		getInput = "Yes";
		while(!getInput.equals("exit")) {
			ArrayList<Airport> airport = new ArrayList<>();
			ArrayList<String> flights = new ArrayList<>();
			Path path = Paths.get("FlightList.txt");
			try (BufferedReader fileInput = Files.newBufferedReader(path)) {
				String line = fileInput.readLine();
				while (line != null) {
					String arr[] = line.split(" ");
					Flight f = new Flight(new String(arr[0]), new String(arr[1]));
					for (int i = 3; i < arr.length - 1; i = i + 2) {
						Airport a = new Airport(arr[i]);
						if (!(airport.contains(a))) {
							airport.add(a);
						}
						a.addFlight(f);
					}
					line = fileInput.readLine();
				}
			}
			BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the name of an airport: ");
			String input = kbd.readLine();
			String str = new String(" ");
			if (input.equals("exit")){
				System.exit(0);
			}
			for (int i = 0; i < airport.size(); i++) {
				if (airport.get(i).toString().contains(input)) {
					flights.add(airport.get(i).toString().substring(5, 10));
				}
			}
			try (BufferedReader fileInput = Files.newBufferedReader(path)) {
				str = input + " (";
				for (int i = 0; i < flights.size(); i++) {
					str += flights.get(i) + ", ";
				}
				if (str.length() != 5) {
					str = str.substring(0, str.length() - 2);
				} else {
					System.out.println("This is not a valid airport");
				}
				str += ")";
				if (!str.contains("()")) {
					System.out.println(str);
				}
			}
		}
	}
}