
import java.util.ArrayList;

public class Airport {
	private String name;
	private ArrayList flights;

	public Airport(String name) {
		this.name = name;
		this.flights = new ArrayList();
	}

	public String getName() {
		return this.name;
	}

	public boolean wasVisitedBy(Flight f) {
		if (this.flights.contains(f)) {
			return true;
		}
		else{
			return false;
		}
	}

	public void addFlight(Flight f) {
		this.flights.add(f);
		if (!(f.getAirports().contains(this))){
			f.addAirport(this);
		}
	}

	public ArrayList getFlights(){
		return this.flights;
	}

	public boolean onSameFlight(Object other) {
		boolean res = false;
		if ( !(other instanceof Airport) ) {
			return false;
		} else {
			for (Object flight : this.flights) {
				if (((Airport) other).flights.contains(flight)) {
					res = true;
				}
			}
		}
		return res;
	}

	public boolean equals(Object other) {
		boolean flag = true;
		if (other instanceof Airport && this.name == ((Airport) other).name &&
				this.flights.size() == ((Airport) other).flights.size()){
			for (int i = 0; i < this.flights.size(); i++){
				if (!((Airport) other).flights.contains(this.flights.get(i))){
					flag = false;
				}

			}
			return flag;
		}
		else{
			return false;
		}
	}

	public String toString() {
		String s = this.name + " (";
		for (int i = 0; i < this.flights.size(); i++){
			s += ((Flight) this.flights.get(i)).getName() + ", ";
		}
		if (s.length() != 5) {
			s = s.substring(0, s.length() - 2);
		}
		return s + ")";

	}
}
