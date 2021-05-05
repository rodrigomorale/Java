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
 * Class: Canada
 * Objective: Store information about Canada provinces
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class Canada {

	// class attribute
	private Province[] provinces = new Province[13];

	/**
	 * Constructor
	 */
	public Canada() {
		super();
		
		// add provinces
		this.provinces[0] = new Province("Alberta", "AB");
		this.provinces[1] = new Province("British Columbia", "BC");
		this.provinces[2] = new Province("Manitoba" , "MB");
		this.provinces[3] = new Province("New Brunswick", "NB");
		this.provinces[4] = new Province("Newfoundland and Labrador", "NL");
		this.provinces[5] = new Province("Northwest Territories", "NT");
		this.provinces[6] = new Province("Nova Scotia", "NS");
		this.provinces[7] = new Province("Nunavut", "NU");
		this.provinces[8] = new Province("Ontario", "ON");
		this.provinces[9] = new Province("Prince Edward Island", "PE");
		this.provinces[10] = new Province("Quebec", "QC");
		this.provinces[11] = new Province("Saskatchewan", "SK");
		this.provinces[12] = new Province("Yukon", "YT");
	}
	
	
	/**
	 * Method: getProvinces
	 * Objective: return a list of Canadian provinces
	 * @return Province[]: provinces
	 */
	public Province[] getProvinces() {
		return provinces;
	}


	/**
	 * Method: setProvinces
	 * Objective: set a list of Canadian provinces
	 */
	public void setProvinces(Province[] provinces) {
		this.provinces = provinces;
	}

	/**
	 * Inner Class: Province
	 * Objective: Store provinces names and abbreviations
	 * @author Rodrigo Canella Garcia Morale
	 *
	 */
	public class Province {
		
		// class attributes
		private String name;
		private String abbr;
		
		/**
		 * Constructor
		 * @param name
		 * @param abbr
		 */
		public Province(String name, String abbr) {
			this.name = name;
			this.abbr = abbr;
		}

		/**
		 * Method: getName
		 * Objective: get the name of the province
		 * @return String: name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Method: setName
		 * Objective: set the name of the province
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Method: getAbbr
		 * Objective: get province abbreviation
		 * @return String: abbr
		 */
		public String getAbbr() {
			return abbr;
		}

		/**
		 * Method: setAbbr
		 * Objective: set province abbreviation
		 * @param abbr
		 */
		public void setAbbr(String abbr) {
			this.abbr = abbr;
		}
		
	}
}
