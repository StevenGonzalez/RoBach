/*
 * Author: Steven Gonzalez
 * Last modified: 11/2/2016 * 
 */

import java.util.ArrayList;

public final class KeyDB {
	
	// Creating Array Lists for the possible types of keys.
	private static ArrayList<String> scale = new ArrayList<String>();	
	
	// Get the scale.
	public static ArrayList<String> getScale() {
		return scale;
	}
	
	// Assigning the keys available for each scale..\
	public static void generateKey(String key) {
		scale = new ArrayList<String>();
		
		switch (key) {
		case "Amajor":
			scale.add("A");
			scale.add("B");
			scale.add("C#");
			scale.add("D");
			scale.add("E");
			scale.add("F#");
			scale.add("G#");
			break;
			
		case "Aminor":
			scale.add("A");
			scale.add("B");
			scale.add("C");
			scale.add("D");
			scale.add("E");
			scale.add("F");
			scale.add("G");
			break;
			
		case "Bmajor":
			scale.add("B");
			scale.add("C#");
			scale.add("D#");
			scale.add("E");
			scale.add("F#");
			scale.add("G#");
			scale.add("A#");
			break;
			
		case "Bminor":
			scale.add("B");
			scale.add("C#");
			scale.add("D");
			scale.add("E");
			scale.add("F#");
			scale.add("G");
			scale.add("A");
			break;
			
		case "Cmajor":
			scale.add("C");
			scale.add("D");
			scale.add("E");
			scale.add("F");
			scale.add("G");
			scale.add("A");
			scale.add("B");
			break;
			
		case "Cminor":
			scale.add("C");
			scale.add("D");
			scale.add("D#");
			scale.add("F");
			scale.add("G");
			scale.add("G#");
			scale.add("A#");
			break;
			
		case "Dmajor":
			scale.add("D");
			scale.add("E");
			scale.add("F#");
			scale.add("G");
			scale.add("A");
			scale.add("B");
			scale.add("C#");
			break;
			
		case "Dminor":
			scale.add("D");
			scale.add("E");
			scale.add("F");
			scale.add("G");
			scale.add("A");
			scale.add("A#");
			scale.add("C");
			break;
			
		case "Emajor":
			scale.add("E");
			scale.add("F#");
			scale.add("G#");
			scale.add("A");
			scale.add("B");
			scale.add("C#");
			scale.add("D#");
			break;
			
		case "Eminor":
			scale.add("E");
			scale.add("F#");
			scale.add("G");
			scale.add("A");
			scale.add("B");
			scale.add("C");
			scale.add("D");
			break;
			
		case "Fmajor":
			scale.add("F");
			scale.add("G");
			scale.add("A");
			scale.add("A#");
			scale.add("C");
			scale.add("D");
			scale.add("E");
			break;
			
		case "Fminor":
			scale.add("F");
			scale.add("G");
			scale.add("G#");
			scale.add("A#");
			scale.add("C");
			scale.add("C#");
			scale.add("D#");
			break;
			
		default:
			System.out.println("You did not input a valid option for Robach. He is now leaving.");
			System.exit(0);			
		}
	}		
}
