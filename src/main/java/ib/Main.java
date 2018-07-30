package ib;

// RealTimeData Class is an implementation of the
// IB API EWrapper class
public class Main {


	public static void main(String args[]) {
		try {
			// Create an instance
			// At this time a connection will be made
			// and the request for market data will happen
			EWrapperImpl myData = new EWrapperImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end main




} // end public class RealTimeData
