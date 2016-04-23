package dijkstratests;

import dijkstra.Adder;

public class TimeAndDistanceAdder implements Adder<TimeAndDistance> {
	public TimeAndDistance add(TimeAndDistance t1,
								TimeAndDistance t2) {
		return new TimeAndDistance(t1.time+t2.time, t1.distance+t2.distance);
	}
	
	public TimeAndDistance getZero() {
		return new TimeAndDistance(0,0);
	}

}
