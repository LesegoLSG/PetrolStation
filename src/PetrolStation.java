import java.io.Serializable;


public class PetrolStation implements Serializable {

	private String name;
	private String description;
	private GPSPoint location;
	
	public PetrolStation(){
		new PetrolStation("","",new GPSPoint(27.998614,-26.183000));
	}
	
	public PetrolStation(String name,String description,GPSPoint location){
		this.name = name;
		this.description = description;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public GPSPoint getLocation() {
		return location;
	}

	public void setLocation(GPSPoint location) {
		this.location = location;
	}
	
	public String toString(){
		return name + ":" + description + "\n" + location;
	}
}
