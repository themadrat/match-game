import javax.swing.ImageIcon;
import java.util.Random;

public class MatchGameManager {
	
	private int checkIndex = 0;
	
	private int colorMatch = 0;
	
	private int playerScore;

	private int colorsInSequence = 3;
	
	private int levelProgress = 0;
	
	private Random randomSequence;
	
	private int currentLevel = 1;
	
	private int levelSuccessScore = 10;
	
	private int levelFailScore = 20;
	
	private int[] generatedSequence;
	
	private boolean allColorsMatch;
	
	private boolean scoreUnderZero;

	
	public int getColorsInSequence() {
		return colorsInSequence;
	}

	public void setColorsInSequence(int colorsInSequence) {
		this.colorsInSequence = colorsInSequence;
	}
	
	public int[] getGeneratedSequence() {
		return generatedSequence;
	}

	public void setGeneratedSequence(int[] generatedSequence) {
		this.generatedSequence = generatedSequence;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	
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
	
	public void generateColorSequence() {
		/*
		 * Method:				:	generateColorSequence()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	ImageIcon[]
		 * 
		 * Synopsis				:	This method stores the colors that will be used to form
		 * 							generated sequence that the player must match each round
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Initial Setup
		 * 							05/06/2021	Jared Shaddick	Separated getTheColors()'s theColors Array From This Method 
		 * 							05/10/2021	Jared Shaddick	Added 4 To Line 67 at [randomSequence.nextInt()] To Prevent 
		 * 														Going Beyond The Length of generatedSequence (Defined At Line 62)
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 * 							05/11/2021	Jared Shaddick	Added Conditional To Determine If The Method Should Generate A Sequence
		 */
		randomSequence = new Random();
		
		int indexGenerationCounter = 0;
		
		generatedSequence = new int[colorsInSequence];
		do {

			generatedSequence[indexGenerationCounter] = setColorNumbers()[randomSequence.nextInt(4)];
			indexGenerationCounter++;
		}
		while (indexGenerationCounter < colorsInSequence);
	}
	
	public void numberOfColors() {
		/*
		 * Method				:	numberOfColors()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	int
		 * 
		 * Synopsis				:	This method will allow User Interface to know how many colors will be present in
		 * 							a sequence for tracking purposes
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Intitial Setup
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 * 							05/15/2021	Jared Shaddick	Modified Method
		 */
		if (scoreUnderZero) {
			colorsInSequence = 3;
		}
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
		 *  						05/15/2021	Jared Shaddick	Modified Method
		 */
		if (colorsReplicated) {
			playerScore += levelSuccessScore;
			return playerScore;
		}
		
		if (!colorsReplicated) {
			playerScore -= levelFailScore;
			return playerScore;
		}
		
		if (scoreUnderZero) {
			playerScore = 0;
			levelSuccessScore = 10;
			levelFailScore = 20;
			return playerScore;
		}
		return playerScore;
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
		 * 							05/15/2021	Jared Shaddick	Modified Method
		 */
		allColorsMatch = false;
		do {
			if (generatedSequence[checkIndex] == replicaColors[checkIndex]) {
				colorMatch++;
			}
			checkIndex++;
		}
		while (checkIndex < generatedSequence.length);
	
		if(colorMatch == generatedSequence.length) {
			allColorsMatch = true;
		}
		else
		allColorsMatch = false;
		
		if (!allColorsMatch || allColorsMatch) {
			checkIndex = 0;
			colorMatch = 0;
		}
		return allColorsMatch;
	}
	public boolean checkPoints() {
		
		if (playerScore < 0) {
			scoreUnderZero = true;
			playerScore = 0;
		}
		if (playerScore >= 0) {
			scoreUnderZero = false;
		}
		return scoreUnderZero;
	}
	public boolean checkLevel() {
		boolean playerLeveledUp;
		
		if (allColorsMatch && levelProgress < 4) {
			levelProgress++;
			playerLeveledUp = false;
		}
		
		if(levelProgress == 4) {
			levelProgress = 0;
			currentLevel++;
			colorsInSequence++;
			levelSuccessScore = levelSuccessScore*2;
			levelFailScore = levelFailScore*2;
			playerLeveledUp = true;
		}
		
		else {
		playerLeveledUp = false;
		}
		
		if (scoreUnderZero) {
			levelProgress = 0;
			currentLevel = 1;
		}
		
		return playerLeveledUp;
	}
}
