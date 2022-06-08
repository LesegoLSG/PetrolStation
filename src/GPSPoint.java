import java.io.Serializable;


public class GPSPoint implements Serializable{
	double longitude;
	double latitude;
	
	double longitudea;
	
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
	
	public String toString(){
		String str = "{";
		str += this.longitude + "," + this.latitude +"}";
		return str;
	}
	
	final static double MARSRADIUS = 3390;
}
