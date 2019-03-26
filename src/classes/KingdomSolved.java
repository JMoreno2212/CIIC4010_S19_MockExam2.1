package classes;

import java.util.ArrayList;

public class KingdomSolved {
	private String king; // Ruler of the Kingdom
	private ArrayList<String> princes; // Heirs to the throne
	private int countriesOwned; // Countries currently under control of the Kingdom
	private int capital; // Money left on the Kingdom
	private int army; // Current Soldiers on the Kingdom
	
	public KingdomSolved(String king, ArrayList<String> princes, int countriesConquered, int capital, int army) {
		this.king = king;
		this.princes = princes;
		this.countriesOwned = countriesConquered;
		this.capital = capital;
		this.army = army;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof KingdomSolved) {
			KingdomSolved k = (KingdomSolved) obj;
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
		int countriesBought = 0; // Initialize a counter for the countries you will buy
		while(this.getCapital() >= costOfCountry) { // Checks if you still have money left to buy
			this.capital -= costOfCountry; // Subtract the cost
			this.countriesOwned++; // You own a new country
			countriesBought++; // You just bought a country
		}
		return countriesBought;
	}
	
	/**
	 * Exercise 2: One of the nearby Kingdoms took over one of the recent bought lands. Help the king decide whether they must go to war or not by 
	 * completing the goToWar() method below.
	 * The conditions are the following: If the enemy has more than 1.5 times this Kingdom's soldiers don't go. If the enemy has the same or up to 1.5 times 
	 * this Kingdom's soldiers, check for the amount of princes and only if less, attack. If the enemy has less soldiers, attack.
	 * @param The enemy this Kingdom is facing
	 * @return True if they must go to war, false if they must not go.
	 */
	
	public boolean goToWar(KingdomSolved enemy) {
		if(enemy.getArmy() > this.getArmy() * 1.5) return false; // More than 1.5 of your army, don't go
		else if(enemy.getArmy() >= this.getArmy() && enemy.getArmy() <= this.getArmy() * 1.5) { // Same or up o 1.5 times your army
			if(enemy.getPrinces().size() < this.getPrinces().size()) return true; // The have less princes, attack
			else return false; // The have more princes, don't attack
		}
		else return true; // Army is less than yours, so attack
	}
	
	/**
	 * Exercise 3: The king has passed away after the war and now one of the princes must take the throne. He left some names, for different positions, 
	 * on his will. If no valid names are found, return the first prince of the kingdom. Complete the newKing() method below to see who the new king will be.
	 * Hint: You don't know which name is which so you must verify all of them.
	 * @param The names left behind by the king
	 * @return The new ruler of the Kingdom
	 */
	
	public String newKing(ArrayList<String> names) {
		for(String name : names) { // Checks all names given
			for(String prince : this.getPrinces()) { // Checks all Princes
				if(name.equals(prince)) {
					return prince; // If a prince is found return that prince
				}
			}
		}
		return this.getPrinces().get(0); // If no prince is found return the first one on the list
	}

	/**
	 * Exercise 4: The Kingdom suffered terrible loses after the war, but they managed to defend themselves. A plate containing the king's name was 
	 * partially damaged during the war. Search for those damaged letters and fix them by completing the fixLetters() method below. Don't forget to use loops.
	 * Hint: Remember that a String is composed of Characters.
	 * @param The plate to be fixed.
	 * @return A new plate with the fixed letters
	 */
	
	public String fixLetters(String damagedPlate) {
		char[] plateToFix = damagedPlate.toCharArray(); // Converts damaged plate to a char[]
		for(int i = 0; i < plateToFix.length; i++) {
			if(plateToFix[i] != this.getKing().charAt(i)) { // Checks if the char is different 
				plateToFix[i] = this.getKing().charAt(i); // If it's different replace it with the King's one
			}
		}
		String result = ""; // Creates the final String
		for(char letter : plateToFix) { // Adds all chars to the String
			result = result + letter;
		}
		return result;
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
		ArrayList<String> resultList = new ArrayList<>(fakeDocument); // Copies the ArrayList fakeDocument
		for(String prince : this.getPrinces()) {
			if(resultList.contains(prince)) resultList.remove(prince); // Removes real princes from the resultList
		}
		String[] result = new String[resultList.size()]; // Create a String[] with the resulting size
		for(int i = 0; i < resultList.size(); i++) {
			result[i] = resultList.get(i); // Add all elements from the resultList to the Array
		}
		return result;
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