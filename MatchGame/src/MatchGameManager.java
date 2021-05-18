import javax.swing.ImageIcon;
import java.util.Random;

public class MatchGameManager {
	
	private int checkIndex = 0;																										//Integer variable for specifying what index to
																																	//examine in the checkColors() method
	
	private int colorMatch = 0;																										//Integer variable for counting the amount of colors
																																	//that match within two sequences
	
	private int playerScore;																										//Integer variable for keeping track of the player's
																																	//score

	private int colorsInSequence = 3;																								//Integer variable for keeping track of how many
																																	//colors should be in each generated and player
																																	//made sequence
	
	private int levelProgress = 0;																									//Integer variable used for keeping track of the
																																	//player's progress in a level
	
	private Random randomSequence;																									//Declaration of a random variable that has yet to be
																																	//instantiated
	
	private int currentLevel = 1;																									//Integer variable that keeps track of the level the
																																	//player is currently on
	
	private int levelSuccessScore = 10;																								//Integer variable for the amount of points the
																																	//player gets for successful matches
	
	private int levelFailScore = 20;																								//Integer variable for the amount of points the
																																	//player gets for unsuccessful matches
	
	private int[] generatedSequence;																								//Integer array used for storing the generated
																																	//sequence of colors
	
	private boolean allColorsMatch;																									//boolean variable for confirming if the generated
																																	//and player made sequences are matching or if they
																																	//are not
	
	private boolean scoreUnderZero;																									//boolean variable used for determining if the player
																																	//has gone below zero and lost or if they have not
																																	//yet lost

	
	public int getColorsInSequence() {
		/*
		 * Method				:	getColorsInSequence()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	int
		 * 
		 * Synopsis				:	This method serves as a getter method which allows User Interface 
		 * 							to refer to	the value of the integer variable, colorsInSequence 
		 * 							that results from the numbersOfColors method without calling the original method itself.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		return colorsInSequence;
	}

	public void setColorsInSequence(int colorsInSequence) {
		/*
		 * Method				:	setColorsInSequence()
		 * 
		 * Method Parameters	:	int colorsInSequence
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method serves as the setter for the getter method, getColorsInSequence().
		 * 
		 * Modifications		:	Dates:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		this.colorsInSequence = colorsInSequence;
	}
	
	public int[] getGeneratedSequence() {
		/*
		 * Method				:	getGeneratedSequence()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	int[]
		 * 
		 * Synopsis				:	This method serves as a getter method which allows User Interface 
		 * 							to refer to	the value of the integer variable, generatedSequence, declared as a 
		 * 							private, global variable (Line 24), Which is modified from the generateColorSequence 
		 * 							method. This getter method serves the purpose of acquiring the color sequence the player 
		 * 							has to replicate without calling the original method itself, which, if were the case, would
		 * 							create a new sequence each time the method is called to display a color.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		return generatedSequence;
	}

	public void setGeneratedSequence(int[] generatedSequence) {
		/*
		 * Method				:	setGeneratedSequence()
		 * 
		 * Method Parameters	:	int[] generatedSequence
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method serves as the setter for the getter method, getGeneratedSequence().
		 * 
		 * Modifications		:	Dates:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		this.generatedSequence = generatedSequence;
	}
	
	public int getPlayerScore() {
		/*
		 * Method				:	getPlayerScore()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	int
		 * 
		 * Synopsis				:	This method serves as a getter method which allows User Interface 
		 * 							to refer to	the value of the integer variable, playerScore, that 
		 * 							is declared as a global, private variable. Which is also modified 
		 * 							from the calculatePoints() method when the player fails to replicate
		 * 							or succeeds to replicate the color sequence that was generated in the
		 * 							generateColorSequence() method.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		/*
		 * Method				:	setPlayerScore()
		 * 
		 * Method Parameters	:	int playerScore
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method serves as the setter for the getter method, getPlayerScore().
		 * 
		 * Modifications		:	Dates:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		this.playerScore = playerScore;
	}
	
	public int getCurrentLevel() {
		/*
		 * Method				:	getCurrentLevel()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	int
		 * 
		 * Synopsis				:	This method serves as a getter method which allows User Interface 
		 * 							to refer to	the value of the integer variable, currentValue, that 
		 * 							is declared as a global, private variable. Which is also modified 
		 * 							from the checkLevel() method when the player achieves the level 
		 * 							progression criteria of four.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		/*
		 * Method				:	setCurrentLevel()
		 * 
		 * Method Parameters	:	int currentLevel
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method serves as the setter for the getter method, getCurrentLevel().
		 * 
		 * Modifications		:	Dates:		Developer:		Notes:
		 * 							05/17/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
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
		 * 							05/06/2021	Jared Shaddick	Modified Method
		 * 							05/07/2021	Jared Shaddick	Modified Method
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 */
		ImageIcon[] theColors = new ImageIcon[4];																						//Creates an array of Image Icons that will be
																																		//used for displaying the generated sequence and
																																		//ensuring the player that their selection has
																																		//occurred
		theColors[0] = new ImageIcon("Images/Red.png");
		theColors[1] = new ImageIcon("Images/Blue.png");
		theColors[2] = new ImageIcon("Images/Green.png");
		theColors[3] = new ImageIcon("Images/Yellow.png");
		
		return theColors;
	}
	
	public int[] colorNumbersArray() {
		/*
		 * Method				:	createColorNumbers()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	int[]
		 * 
		 * Synopsis				:	This method creates an integer array that is used by this class,
		 * 							MatchGameManager, and the class, User Interface.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/15/2021	Jared Shaddick	Inital Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		int[] colorNumbers = new int[4];																							//Creates and instantiates an integer array for use
																																	//with generateColorSequence()
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
		 * 							05/06/2021	Jared Shaddick	Modified Method 
		 * 							05/10/2021	Jared Shaddick	Modified Method
		 * 							05/11/2021	Jared Shaddick	Modified Method
		 * 							05/18/2021	Jared Shaddick	Added Comments
		 */
		randomSequence = new Random();																								//Instantiates a new random object
		
		int indexGenerationCounter = 0;																								//Creates and sets an integer variable to zero
																																	//for determining what index to assign a value to
		
		generatedSequence = new int[colorsInSequence];																				//Instantiates a new integer array for storing a
																																	//randomly generated sequence of colors that uses
																																	//the integer variable colorsInASequence to indicate
																																	//how many colors are in a sequence
		do {

			generatedSequence[indexGenerationCounter] = colorNumbersArray()[randomSequence.nextInt(4)];								//Adds a random value from an index from the
																																	//colorNumbersArray() method to the generatedSequence
																																	//array
			
			indexGenerationCounter++;																								//Increments the counter by 1 so that the program
																																	//will check the next method
		}
		while (indexGenerationCounter < colorsInSequence);																			//if this conditional is met the loop will end
	}
	
	public void numberOfColors() {
		/*
		 * Method				:	numberOfColors()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method will reset the colorsInSequence integer variable back to the level 
		 * 							one default if the player's score is less than zero.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Intitial Setup
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 * 							05/15/2021	Jared Shaddick	Modified Method
		 * 							05/17/2021	Jared Shaddick	Modified Method
		 * 							05/18/2021	Jared Shaddick	Added New Comments
		 */
		if (scoreUnderZero) {
			colorsInSequence = 3;																									//Sets the colorsInASequence to its default if
																																	//the player has gotten a game over
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
		 * 							05/10/2021	Jared Shaddick	Modified Method
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 *  						05/15/2021	Jared Shaddick	Modified Method
		 *  						05/17/2021	Jared Shaddick	Modified Method
		 *  						05/18/2021	Jared Shaddick	Added New Comments
		 */
		if (colorsReplicated) {																								//This conditional, if met, will add to the player's total
																															//score
			playerScore += levelSuccessScore;
			return playerScore;
		}
		
		if (!colorsReplicated) {																							//This conditional, if met, will subtract from the player's
																															//total score
			playerScore -= levelFailScore;
			return playerScore;
		}
		
		if (scoreUnderZero) {																								//This conditional, if met, will allow playerScore,
																															//levelSuccessScore, and levelFailScore to be set back to
																															//their default values so that a new game can begin
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
		 * 							05/18/2021	Jared Shaddick	Added New Comments
		 */
		allColorsMatch = false;																								//Sets the boolean indicating success or failure to false
		do {
			if (generatedSequence[checkIndex] == replicaColors[checkIndex]) {												//If this conditional is met, the colors specified in the
																															//the index counter, checkColors, match and will add to the
																															//colorMatch counter which goes towards confirming if the
																															//sequences are replicas of each other
				colorMatch++;
			}
			checkIndex++;
		}
		while (checkIndex < generatedSequence.length);
	
		if(colorMatch == generatedSequence.length) {																		//If this conditional is met, the player has successfully
																															//replicated the sequence
			allColorsMatch = true;
		}
		else
		allColorsMatch = false;
		
		if (!allColorsMatch || allColorsMatch) {																			//Ensures that regardless of what value the boolean,
																															//allColorsMatch, has been given, it will always reset
																															//checkIndex and colorMatch back to 0
			checkIndex = 0;
			colorMatch = 0;
		}
		return allColorsMatch;
	}
	public boolean checkPoints() {
		/*
		 * Method				:	checkPoints()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	boolean
		 * 
		 * Synopsis				:	This method will be used to determine if the player has lost all of their points
		 * 							and have gone below zero, which results in a game over. It will also determine
		 * 							if the player still has a score value above or equal to zero.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/15/2021	Jared Shaddick	Initial Setup
		 * 							05/17/2021	Jared Shaddick	Modified Method
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		
		if (playerScore < 0) {																										//If this conditional is met the player has achieved
																																	//a game over
			scoreUnderZero = true;
			playerScore = 0;
		}
		if (playerScore >= 0) {																										//If this conditional is met the player is still
																																	//in the game
			scoreUnderZero = false;
		}
		return scoreUnderZero;
	}
	public boolean checkLevel() {
		/*
		 * Method				:	checkLevel()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	boolean
		 * 
		 * Synopsis				:	This method will determine if the player has reached the necessary requirements
		 * 							for proceeding to the next level.
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/15/2021	Jared Shaddick	Initial Setup
		 * 							05/17/2021	Jared Shaddick	Modified Method
		 * 							05/18/2021	Jared Shaddick	Added Comments
		 */
		boolean playerLeveledUp;
		
		if (allColorsMatch && levelProgress < 4) {																		//If this conditional is met the player is still on the current
																														//level and has not reached the four successful round criteria
																														//but has received a point towards the next level, and the
																														//playerLeveledUp boolean has been set to false
			levelProgress++;
			playerLeveledUp = false;
		}
		
		if(levelProgress == 4) {																						//If this conditional is met the player has leveled up
																														//and the levelProgress counter is reset to 0, the currentLevel
																														//variable increases by 1, the colorsInASequence variable has
																														//increased by 1, and the levelSuccessScore and levelFailScore
																														//variables have doubled. playerLeveledUp is also set to true
			levelProgress = 0;
			currentLevel++;
			colorsInSequence++;
			levelSuccessScore = levelSuccessScore*2;
			levelFailScore = levelFailScore*2;
			playerLeveledUp = true;
		}
		
		else {																											//If the two previous conditionals were not met then
																														//playerLeveledUp is set to false
		playerLeveledUp = false;
		}
		
		if (scoreUnderZero) {																							//If this conditional is met, the player has gotten a game over
																														//and the levelProgress counter and currentLevel counter has
																														//reset to default values
			levelProgress = 0;
			currentLevel = 1;
		}
		
		return playerLeveledUp;
	}
}
