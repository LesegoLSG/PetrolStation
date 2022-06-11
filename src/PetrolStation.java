import java.io.Serializable;

/**
 * 
 * @author Mhlongo L
 * 
 *This class is a blueprint of petrol station
 */
@SuppressWarnings("serial")
public class PetrolStation implements Serializable {

	private String name;
	private String description;
	private GPSPoint location;
	
	public PetrolStation(){
		new PetrolStation("","",new GPSPoint(27.998614,-26.183000));
	}
	/**
	 * The overloaded constructor
	 * @param name
	 * @param description
	 * @param location
	 */
	public PetrolStation(String name,String description,GPSPoint location){
		this.name = name;
		this.description = description;
		this.location = location;
	}
	
	/**
	 * Method to get the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method to set the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Method to get petrol station description
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Method to set the description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Method to get the location
	 * @return the location
	 */
	public GPSPoint getLocation() {
		return location;
	}
	
	/**
	 * Method to set the location
	 * @param location
	 */
	public void setLocation(GPSPoint location) {
		this.location = location;
	}
	/**
	 * The overridden to String method used for serialisation
	 */
	public String toString(){
		return name + ":" + description + "\n" + location;
	}
}
