import javax.swing.ImageIcon;

import java.util.Arrays;
import java.util.Random;

public class MatchGameManager {
	
	private int[] theSequence;
	
	private int checkIndex = 0;
	
	private int colorMatch = 0;
	
	RandomColorSequence RCS = new RandomColorSequence();

	public ImageIcon[] getTheColors() {
		/*
		 * Method:				:	getTheColors()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	ImageIcon[]
		 * 
		 * Synopsis				:	This method stores the colors that will be used to form the
		 * 							generated sequence of colors and the player made replica of
		 * 							the given sequence
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Initial Setup
		 * 							05/06/2021	Jared Shaddick	Separated From Generated Sequence
		 * 							05/07/2021	Jared Shaddick	Re-ordered Array In Order Of Button Appearance
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 */
		ImageIcon[] theColors = new ImageIcon[4];
		theColors[0] = new ImageIcon("Images/Red.png");
		theColors[1] = new ImageIcon("Images/Blue.png");
		theColors[2] = new ImageIcon("Images/Green.png");
		theColors[3] = new ImageIcon("Images/Yellow.png");
		
		return theColors;
	}
	
	public int[] setColorNumbers() {
		int[] colorNumbers = new int[4];
		colorNumbers[0] = 0;
		colorNumbers[1] = 1;
		colorNumbers[2] = 2;
		colorNumbers[3] = 3;
		
		return colorNumbers;
	}

	public int numberOfColors() {
		/*
		 * Method				:	numberOfColors()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	int
		 * 
		 * Synopsis				:	This method will determine the number of colors the Match Game Manager will generate
		 * 							and determine the number of buttons that can be pressed when recreating the sequence
		 * 							from Match Game Manager
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Intitial Setup
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 */
		int colorsToReplicate;
		
		colorsToReplicate = 3;
		
		return colorsToReplicate;
	}
	
	public int[] setTheSequence() {
		int[] theSequence = new int[numberOfColors()];
		
		theSequence = RCS.generateColorSequence(numberOfColors(), setColorNumbers());
		
		return theSequence;
	}
	
	public int calculatePoints(boolean colorsReplicated) {
		/*
		 * Method				:	calculatePoints()
		 * 
		 * Method Parameters	:	boolean colorsReplicated
		 * 
		 * Method Return		:	int
		 * 
		 * Synopsis				:	This method will use the determination of the method, checkColors(),
		 * 							to determine if points will be awarded to the player or taken away.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Initial Setup
		 * 							05/10/2021	Jared Shaddick	Added Parameter That Will Only Be Utilized When The 
		 * 														checkColors() Method Returns A Value To The
		 * 														User Interface In The replicateColors() Method
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 */
		int levelSuccessScore = 10;
		int levelFailScore = 20;
		int currentUserScore = 0;

		if (colorsReplicated) {
			currentUserScore = currentUserScore + levelSuccessScore;
		}
		if (!colorsReplicated) {
			currentUserScore = currentUserScore - levelFailScore;
		}
		return currentUserScore;
	}
	
	public boolean checkColors(int[] replicaColors) {
		/*
		 * Method				:	checkColors
		 * 
		 * Method Parameters	:	ImageIcon[] replicaColors
		 * 
		 * Method Return		:	boolean
		 * 
		 * Synopsis				:	This method will use the generateColorSequence()'s ImageIcon array
		 * 							and the ImageIcon array created by the user, which is given to the
		 * 							ImageIcon[] replicaColors parameter by the replicateColors() method 
		 * 							in User Interface.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Initial Setup
		 * 							05/10/2021	Jared Shaddick	Added Parameter
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 */
		boolean AllColorsMatch;
		
		do {
			if (theSequence[checkIndex] == replicaColors[checkIndex]) {
				colorMatch++;
			}
			checkIndex++;
		}
		while (checkIndex < theSequence.length);
	
		if(colorMatch == theSequence.length) {
			AllColorsMatch = true;
		}
		else
		AllColorsMatch = false;
		
		return AllColorsMatch;
	}
	
}
