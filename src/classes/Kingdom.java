package classes;

import java.util.ArrayList;

public class Kingdom {
	private String king; // Ruler of the Kingdom
	private ArrayList<String> princes; // Heirs to the throne
	private int countriesOwned; // Countries currently under control of the Kingdom
	private int capital; // Money left on the Kingdom
	private int army; // Current Soldiers on the Kingdom
	
	public Kingdom(String king, ArrayList<String> princes, int countriesConquered, int capital, int army) {
		this.king = king;
		this.princes = princes;
		this.countriesOwned = countriesConquered;
		this.capital = capital;
		this.army = army;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Kingdom) {
			Kingdom k = (Kingdom) obj;
			return this.king.equals(k.king) && this.princes.equals(k.princes) && 
					this.countriesOwned == k.countriesOwned && this.capital == k.capital && this.army == k.army;
		}
		return false;
	}
	
	/**
	 * Exercise 1: The Kingdom wants to expand across the land. Nearby Kingdoms are selling some nearby lands and they plan
	 * to buy as much as possible. Complete the maxExpansion() method below. You must use loops to solve this exercise.
	 * @param The cost of the countries that are going to be purchased.
	 * @return The amount of countries that the Kingdom bought
	 */
	
	public int maxExpansion(int costOfCountry) {
		// 	YOUR CODE HERE
		return 0; // Dummy Return
	}
	
	/**
	 * Exercise 2: One of the nearby Kingdoms took over one of the recent bought lands. Help the king decide whether they must go to war or not by 
	 * completing the goToWar() method below.
	 * The conditions are the following: If the enemy has more than 1.5 times this Kingdom's soldiers don't go. If the enemy has the same or up to 1.5 times 
	 * this Kingdom's soldiers, check for the amount of princes and only if less, attack. If the enemy has less soldiers, attack.
	 * @param The enemy this Kingdom is facing
	 * @return True if they must go to war, false if they must not go.
	 */
	
	public boolean goToWar(Kingdom enemy) {
		// YOUR CODE HERE
		return false; // Dummy return
	}
	
	/**
	 * Exercise 3: The king has passed away after the war and now one of the princes must take the throne. He left some names, for different positions, 
	 * on his will. If no valid names are found, return the first prince of the kingdom. Complete the newKing() method below to see who the new king will be.
	 * Hint: You don't know which name is which so you must verify all of them.
	 * @param The names left behind by the king
	 * @return The new ruler of the Kingdom
	 */
	
	public String newKing(ArrayList<String> names) {
		// YOUR CODE HERE
		return null; // Dummy return
	}

	/**
	 * Exercise 4: The Kingdom suffered terrible loses after the war, but they managed to defend themselves. A plate containing the king's name was 
	 * partially damaged during the war. Search for those damaged letters and fix them by completing the fixLetters() method below. Don't forget to use loops.
	 * Hint: Remember that a String is composed of Characters.
	 * @param The plate to be fixed.
	 * @return A new plate with the fixed letters
	 */
	
	public String fixLetters(String damagedPlate) {
		// YOUR CODE HERE
		return null; // Dummy return
	}
		
	/**
	 * Exercise 5: Recently, rumors about the appearance of new princes spread across the Kingdom. The rumors were accompanied by a document which
	 * contained the supposedly new princes. Now, the king wants to spread a new document which contains the names of those fake princes to properly 
	 * inform the Kingdom. Help him by completing the spreadFakePrinces() method below.
	 * Hint: Check the ArrayList Class on the Java API if you feel stuck.
	 * NOTE: This method returns an Array, not an ArrayList.
	 * @param The fake document that has been spread out.
	 * @return A new document with the fake princes names.
	 */
	
	public String[] spreadFakePrinces(ArrayList<String> fakeDocument) {
		// YOUR CODE HERE
		return null; // Dummy return
	}

	// Getters and Setters	
	public String getKing() {return king;}
	public void setKing(String newKing) {this.king = newKing;}

	public ArrayList<String> getPrinces() {return princes;}
	public void setPrinces(ArrayList<String> newPrinces) {this.princes = newPrinces;}

	public int getCountriesOwned() {return countriesOwned;}
	public void setCountriesOwned(int newCountriesOwned) {this.countriesOwned = newCountriesOwned;}
	
	public int getCapital() {return capital;}
	public void setCapital(int newCapital) {this.capital = newCapital;}

	public int getArmy() {return army;}
	public void setArmy(int newArmy) {this.army = newArmy;}
	
}