/**********************************************
Workshop 8
Course: JAC 444 - Semester 4
Last Name: Canella Garcia Morale
First Name: Rodrigo
ID: 135297190
Section: NEE
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: March 27, 2021
**********************************************/

package ca.senecacollege.JAC444.workshop08.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class WorldMap
 * Objective: this class handle with a list of countries and its capitals
 * @author Rodrigo Canella Garcia Morale
 *
 */
public class WorldMap {
	
	// class attribute
	Map<String, String> countriesCapitals = new HashMap<>(35);
	List<String> listOfCountries = new ArrayList<>(35);

	/**
	 * Constructor
	 */
	public WorldMap() {
		super();
		
		// add all countries and capitals of americas
		countriesCapitals.put("CANADA", "Ottawa");
		countriesCapitals.put("UNITED STATES OF AMERICA", "Washington D.C.");
		countriesCapitals.put("MEXICO", "Mexico City");
		countriesCapitals.put("BELIZE", "Belmopan");
		countriesCapitals.put("GUATEMALA", "Guatemala City");
		countriesCapitals.put("HONDURAS", "Tegucigalpa");
		countriesCapitals.put("EL SALVADOR", "San Salvador");
		countriesCapitals.put("NICARAGUA", "Managua");
		countriesCapitals.put("COSTA RICA", "San Jose");
		countriesCapitals.put("PANAMA", "Panama City");
		countriesCapitals.put("ANTIGUA E BARBUDA", "St John’s");
		countriesCapitals.put("BAHAMAS", "Nassau");
		countriesCapitals.put("BARBADOS", "Bridgetown");
		countriesCapitals.put("CUBA", "Havana");
		countriesCapitals.put("DOMINICA", "Roseau");
		countriesCapitals.put("DOMINICAN REPUBLIC", "Santo Domingo");
		countriesCapitals.put("GRENADA", "St George’s");
		countriesCapitals.put("HAITI", "Port-au-Prince");
		countriesCapitals.put("JAMAICA", "Kingston");
		countriesCapitals.put("ST KITTS-NEVIS", "Basseterre");
		countriesCapitals.put("ST LUCIA", "Castries");
		countriesCapitals.put("ST VINCENT AND THE GRENADINES", "Kingstown");
		countriesCapitals.put("TRINIDAD AND TOBAGO", "Port-of-Spain");
		countriesCapitals.put("ARGENTINA", "Buenos Aires");
		countriesCapitals.put("BOLIVIA", "Sucre (Judicial) and La Paz (administrative)");
		countriesCapitals.put("BRAZIL", "Brasilia");
		countriesCapitals.put("CHILE", "Santiago");
		countriesCapitals.put("COLOMBIA", "Bogota");
		countriesCapitals.put("ECUADOR", "Quito");
		countriesCapitals.put("GUYANA", "Georgetown");
		countriesCapitals.put("PARAGUAY", "Asuncion");
		countriesCapitals.put("PERU", "Lima");
		countriesCapitals.put("SURINAME", "Paramaribo");
		countriesCapitals.put("URUGUAY", "Montevideo");
		countriesCapitals.put("VENEZUELA", "Caracas");
		
		// fill list of countries
		countriesCapitals.forEach((country, capital)-> { listOfCountries.add(country);});
	}

	/**
	 * Method: getCountryCapital
	 * Objective: get the name of a country capital
	 * @return String: capital
	 */
	public String getCountryCapital(String country) {
		return countriesCapitals.get(country.toUpperCase());
	}
	
	/**
	 * Method: listOfCountries
	 * Objective: retrieve a list with all America countries
	 * @return List1<String>:listOfCountries 
	 */
	public List<String> listOfCountries() {
		return this.listOfCountries;
	}
	
	/**
	 * Method: countryListIndex
	 * Objective: return a country index in the list
	 * @param country
	 * @return int: country index
	 */
	public int countryListIndex(String country) {
		return listOfCountries.indexOf(country);
	}
}
