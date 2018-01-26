
import java.util.ArrayList;

public class Flight {
	private String name;
	private ArrayList airports;
	private String date;

	public Flight(String name, String date) {
		this.name = name;
		this.date = date;
		this.airports = new ArrayList();
	}

	public String getName() {

		return this.name;
	}

	public String getDate() {

		return this.date;
	}

	public void addAirport(Object a) {
		this.getAirports().add((Airport) a);
		if (!((Airport) a).getFlights().contains(this)) {
			((Airport) a).addFlight(this);
		}
	}

	public ArrayList getAirports() {

		return this.airports;
	}

	public boolean equals(Object other) {
		if (other instanceof Flight && this.name.equals(((Flight) other).name) &&
				this.date.equals(((Flight) other).date)) {
			return true;
		}
		return false;
	}

	public String toString() {
		String str;
		str = this.name + ", " + this.date;
		for (Object air : this.airports) {
			str = str + "\n" + ((Airport) air).getName();
		}
		return str;
	}
}