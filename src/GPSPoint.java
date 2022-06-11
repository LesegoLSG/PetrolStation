
import java.io.Serializable;

/**
 * 
 * @author Mhlongo L
 *
 */
@SuppressWarnings("serial")
public class GPSPoint implements Serializable{
	
	double longitude;
	double latitude;
	
	double longitudea;
	
	/**
	 * The constructor
	 * @param longitude
	 * @param latitude
	 */
	public GPSPoint(double longitude,double latitude){
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * Method that calculates the distance from your location to the nearest petrol station
	 * @param otherPoint - Your current location
	 * @return distance
	 */
	public double calculateDistance(GPSPoint otherPoint){
		double deltaLat = Math.toRadians(this.latitude - otherPoint.latitude);
		double deltaLong = Math.toRadians(this.longitude - otherPoint.longitude);
		double s1 = Math.sin(deltaLat/2);
		double s2 = Math.sin(deltaLong/2);
		double a = Math.pow(s1, 2) + Math.pow(s2, 2) * Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(otherPoint.latitude));
		double b = 2* Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		return MARSRADIUS*b;
	}
	/**
	 * overridden toString method
	 */
	public String toString(){
		String str = "{";
		str += this.longitude + "," + this.latitude +"}";
		return str;
	}
	
	final static double MARSRADIUS = 3390;
}
