package dijkstratests;

public class TimeAndDistance  {
	int time;
	int distance;
	
	TimeAndDistance(int time, int distance) {
		this.time = time;
		this.distance = distance;
	}
	
	public String toString() {
		return time + ", " + distance;
	}
	
	public boolean equals(Object other) {
		if (! (other instanceof TimeAndDistance)) {
			return false;
		}
		return time == ((TimeAndDistance) other).time &&
		distance == ((TimeAndDistance) other).distance ;
	}
}
