import java.util.Random;

public class RandomColorSequence {
	
	private Random randomSequence;
	
	private int[] generatedSequence;

	public int[] generateColorSequence(int numberOfColors, int[] numberedColors) {
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
		
		do {
			generatedSequence = new int[numberOfColors];
			generatedSequence[indexGenerationCounter] = numberedColors[randomSequence.nextInt(4)];
			System.out.println(generatedSequence[indexGenerationCounter]);
			indexGenerationCounter++;
		}
		while (indexGenerationCounter < numberOfColors);
	
		return generatedSequence;
	}
	
}
