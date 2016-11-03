/*
 * Author: Steven Gonzalez
 * Last modified: 11/2/2016
 * 
 * Program: RoBach
 * Description: When this program is started, it will ask the user for a musical key and the beats per minute they would like
 * 		the program to play at. Once the user inputs this information, the program will start playing random notes
 * 		and chords at random lengths in the scale chosen by the user. Note that a third party program that emulates
 * 		an instrument playing by keyboard is required for this to work.
 */


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RoBach {

	  Robot robot = new Robot();	// Primitive object in Java used to make key presses.
	  static int bpm;		// Used to keep track of what BPM RoBach should play at.
	  static String key;		// Used to keep track of which key is going to be played.

	  // Get the scale and bpm the user wants Robach to play at.
	  public static void main(String[] args) throws AWTException {
		  
		  Scanner input = new Scanner(System.in);
		  
		  System.out.println("What key would you like Robach to play in?\n"
		  		+ "Choices: Amajor, Aminor, Bmajor, Bminor, ect...");
		  key = input.next();
		  KeyDB.generateKey(key);
		  
		  System.out.println("How many BPM should RoBach play at?");
		  bpm = input.nextInt();
		  
		  new RoBach();
		  input.close();
	  }	  	  
	  
	  // This is where RoBach actually does actions.
	  public RoBach() throws AWTException
	  {
		// Slight delay before actions take place.
	    robot.setAutoDelay(40);
	    robot.setAutoWaitForIdle(true);
	    
	    // Navigate to keyboard
	    // Position will need to be edited depending on where program exists.
	    // This can be commented out if you want to manually switch focus to the program after starting RoBach.
	    robot.delay(4000);
	    robot.mouseMove(1450, 2000);
	    robot.delay(500);
	 
	    // Click to focus keyboard
	    leftClick();
	    robot.delay(500);
	 
	    // RoBach plays
	    for (int i = 0; i < 1000; i++ ) {
	    	
	    	int r = (int)(2 * Math.random());
	    	
	    	// If random number is 0 play single note
	    	// If 1 play a chord.
	    	if (r == 0) {
		    	int randomkey = randomKey(KeyDB.getScale());
			    robot.keyPress(randomkey);
			    robot.keyRelease(randomkey);
			    robot.delay(randomDelay(bpm));
	    	}
	    	else {
	    		int randomkey1 = randomKey(KeyDB.getScale());
	    		int randomkey2;
	   
	    		do {
	    			randomkey2 = randomKey(KeyDB.getScale());
	    		}while(randomkey2 != randomkey1);
	    		
	    		robot.keyPress(randomkey1);
	    		robot.keyPress(randomkey2);
	    		robot.keyRelease(randomkey1);
	    		robot.keyRelease(randomkey2);
			    robot.delay(randomDelay(bpm));	    		
	    	}
	    }
	    
	    // RoBach stops playing
	    robot.delay(1000);
	    System.exit(0);
	  }
	   
	  // Allows RoBach to left click
	  private void leftClick()
	  {
	    robot.mousePress(InputEvent.BUTTON1_MASK);
	    robot.delay(200);
	    robot.mouseRelease(InputEvent.BUTTON1_MASK);
	    robot.delay(200);
	  }
	   
	  // Type whatever character that is passed in.
	  @SuppressWarnings("unused")
	private void type(int i)
	  {
	    robot.delay(40);
	    robot.keyPress(i);
	    robot.keyRelease(i);
	  }
	 
	  // Type a string that is passed in.
	  @SuppressWarnings("unused")
	private void type(String s)
	  {
	    byte[] bytes = s.getBytes();
	    for (byte b : bytes)
	    {
	      int code = b;
	      // keycode only handles [A-Z] (which is ASCII decimal [65-90])
	      if (code > 96 && code < 123) code = code - 32;
	      robot.delay(40);
	      robot.keyPress(code);
	      robot.keyRelease(code);
	    }
	  }	  
	  
	  // Random key to play on piano.
	  private int randomKey(ArrayList<String> scale) {
		  Random random = new Random();
		  int rndIndex = random.nextInt(scale.size());
		  
		  //Get a random number for the different octaves of the notes.
		  int r = (int)(2 * Math.random());
		  
		  // Play the key on the keyboard.
		  // Uses ASCII keyboard code to press the keys.
		  // Will need to be changed depending on what default program uses.
		  switch (scale.get(rndIndex)) {
		  case "A":
			  if (r == 0) {
				  return 78; 
			  }
			  else {
				  return 69;
			  }
		  case "A#":
			  if (r == 0) {
				  return 74; 
			  }
			  else {
				  return 52;
			  }
		  case "B":
			  if (r == 0) {
				  return 77; 
			  }
			  else {
				  return 82;
			  }
		  case "C":
			  if (r == 0) {
				  return 44; 
			  }
			  else {
				  return 90;
			  }
			  
		  case "C#":
			  if (r == 0) {
				  return 83; 
			  }
			  else {
				  return 76;
			  }
		  case "D":
			  if (r == 0) {
				  return 88; 
			  }
			  else {
				  return 46;
			  }
		  case "D#":
			  if (r == 0) {
				  return 68; 
			  }
			  else {
				  return 59;
			  }
		  case "E":
			  if (r == 0) {
				  return 67; 
			  }
			  else {
				  return 47;
			  }
		  case "F":
			  if (r == 0) {
				  return 86; 
			  }
			  else {
				  return 81;
			  }
		  case "F#":
			  if (r == 0) {
				  return 71; 
			  }
			  else {
				  return 50;
			  }
		  case "G":
			  if (r == 0) {
				  return 66; 
			  }
			  else {
				  return 87;
			  }
		  case "G#":
			  if (r == 0) {
				  return 72; 
			  }
			  else {
				  return 51;
			  }
		  default:
				  return 0; 			  
		  }		  
	  }
	  
	  // Delay is directly dependent on Beats Per Minute(BPM)
	  // Base formula is as follows : 60bpm is equal to 1 beat every 1000 milliseconds(1 second)
	  private int randomDelay(int bpm) {
		  
		  int randomNum = 0 + (int)(Math.random() * 5);
		  
		  switch(randomNum) {
		  
			  // Sixteenth note
			  case 0:
				  return 60000 / 16 / bpm;
			  
			  // Eighth note
			  case 1:
				  return 60000 / 8 / bpm;
			  // Fourth note
			  case 2:
				  return 60000 / 4 / bpm;
			  // Half note
			  case 3:
				  return 60000 / 2 / bpm;
			  // Whole note
			  case 4:
				  return 60000 / 1 / bpm;
			  // Double note
			  case 5:
				  return 60000 * 2 / bpm;
				  
			  default:
				  return 60000 / 1 / bpm;
		  }
	  }
}
