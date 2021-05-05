/**********************************************
Workshop 5
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 02, 2021
**********************************************/

package ca.senecacollege.jac433.workshop07;

/**
 * Class: Address
 * Objective: objectg that holds address informations
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Address {

	// class attributes
	private String city;
	private String province;
	private String postalCode;
	
	/**
	 * Constructor
	 * @param city
	 * @param province
	 * @param postalCode
	 */
	public Address(String city, String province, String postalCode) {
		super();
		
		// use setter because of the assign validation
		setCity(city);
		setProvince(province);
		setPostalCode(postalCode);
	}

	/**
	 * Method: getCity
	 * Objective: return city name
	 * @return String: city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Method: setCity
	 * Objective: set city name
	 * @param city
	 */
	public void setCity(String city) {
		
		// fill the string with spaces until 25 characters
		if (city.length() > 25) {
			this.city = city.substring(0, 25);
		} else {
			this.city = city;
		
		} while (this.city.length() != 25) {
				this.city += " ";
		}
	}

	/**
	 * Method: getProvince
	 * Objective: get province abbreviation with two letters
	 * @return String: province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * Method: setProvince
	 * Objective: set province abbreviation
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * Method: getPostalCode
	 * Objective: get postal code value
	 * @return String: postalcode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Method: setPostalCode
	 * Objective: set postal code value
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		if (postalCode.length() > 6) {
			this.postalCode = postalCode.substring(0, 6);
		} else {
			this.postalCode = postalCode;
		
		} while (this.postalCode.length() != 6) {
				this.postalCode += " ";
		}
	}
}
