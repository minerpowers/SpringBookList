package dmacc.beans;

import javax.persistence.Embeddable;


@Embeddable
public class Author {
	private String firstName;
	private String lastName;
	/**
	 * Constructor: no parameters
	 */
	public Author() {
		super();
	}
	/**
	 * Constructor: 
	 * @param first_name
	 * @param last_name
	 */
	public Author(String first_name, String last_name) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	
}
