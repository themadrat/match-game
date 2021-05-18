import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class UserInterface extends JFrame implements ActionListener {
	
	private final Integer ButtonTimer = 1000;																							//integer variable, used for the timer 
																																		//length in the @Override ActionPerformed() 
																																		//method
	
	private Boolean timeToShowColor = true;																								//boolean variable, used for alternating between
																																		//"ticks" in the timer
	
	private Timer showColor = new Timer(ButtonTimer, this);																				//Timer object, instantiated here and used
																																		//in btnStartButton to start it and utilized
																																		//in the @Override ActionPerformed() method
	
	private JPanel contentPane;																											//Used to create the window where the game 
																																		//is played
	
	private boolean gameStarted = false;																								//boolean variable, used in various places
																																		//within the User Interface class for
																																		//determining when vital processes relating
																																		//to the start of the game or round occur
	
	private boolean colorsMatch;																										//boolean variable, used to both inform
																																		//the User Interface class and pass information
																																		//to the Match Game Manager class using
																																		//parameterization
	
	private boolean colorsShown;																										//boolean variable, used to tell the @Override
																																		//ActionPerformed() method when to display
																																		//the random sequence of colors from the
																																		//Match Game Manager class
																																		
	
	private int colorIndex = 0;																											//integer variable, used in the @Override
																																		//ActionPerformed() method to count the amount
																																		//of times any color was displayed
	
	private int replicaIndex = 0;																										//integer variable, used in the replicateColors()
																																		//method to count the amount of times a color was
																																		//added the the player made array of colors
	
	private int playerScore = 0;																										//integer variable, used to keep track of the
																																		//player's score, which is determined in the
																																		//Match Game Manager class
	
	private ImageIcon lowRed = new ImageIcon("Images/LowRed.png");																		//ImageIcon instantiation
	
	private ImageIcon lowBlue = new ImageIcon("Images/LowBlue.png");																	//ImageIcon instantiation
	
	private ImageIcon lowGreen = new ImageIcon("Images/LowGreen.png");																	//ImageIcon instantiation
	
	private ImageIcon lowYellow = new ImageIcon("Images/LowYellow.png");																//ImageIcon instantiation
	
	private JButton btnRedButton = new JButton(lowRed);																					//JButton instantiation
	
	private JButton btnBlueButton = new JButton(lowBlue);																				//JButton instantiation
	
	private JButton btnGreenButton = new JButton(lowGreen);																				//JButton instantiation
	
	private JButton btnYellowButton = new JButton(lowYellow);																			//JButton instantiation
	
	private JLabel lblMessageBoard = new JLabel("");																					//JLabel instantiation
	
	private JLabel lblScoreDisplay = new JLabel("Score: ");																				//JLabel instantiation
	
	private JLabel lblLevelUpNotifier = new JLabel("");																					//JLabel instantiation
	
	MatchGameManager MGM = new MatchGameManager();																						//Instantiation of the Match Game Manager class
																																		//which will be utilize throughout the
																																		//User Interface class
	
	private JButton btnStartButton = new JButton("Start");																				//JButton instantiation
	
	private JLabel lblLevelDisplay = new JLabel("Level: ");																				//JLabel instantiation
	
	private int[] replicaSequence;																										//integer array variable, used to store the
																																		//player made array for replicating a given
																																		//random color sequence

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRedButton.setEnabled(false);
		btnRedButton.setPressedIcon(MGM.getTheColors()[0]);
		btnRedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				/*
				 * Method				:	actionPerformed
				 * 
				 * Method Parameters	:	ActionEvent e3
				 * 
				 * Method Return		:	Void
				 * 
				 * Synopsis				:	This is the first of four colored buttons that the player will use
				 * 							to replicate the colors in the generated sequence from Match Game Manager
				 * 
				 * Modifications		:	Date:		Developer:		Notes:
				 * 							05/05/2021	Jared Shaddick	Initial Setup
				 * 							05/10/2021	Jared Shaddick	Modified Method
				 * 							05/15/2021	Jared Shaddick	Modified Method
				 */

				if (!gameStarted) {
					replicateColors(0);																									//Adds the number 0 to the replica sequence array
																																		//when the boolean, gameStarted, is false
				}
				
			}
		});
		btnRedButton.setBounds(10, 11, 250, 250);
		contentPane.add(btnRedButton);
		
		btnBlueButton.setEnabled(false);
		btnBlueButton.setPressedIcon(MGM.getTheColors()[1]);
		btnBlueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				/*
				 * Method				:	actionPerformed
				 * 
				 * Method Parameters	:	ActionEvent e2
				 * 
				 * Method Return		:	Void
				 * 
				 * Synopsis				:	This is the second of four colored buttons that the player will use
				 * 							to replicate the colors in the generated sequence from Match Game Manager
				 * 
				 * Modifications		:	Date:		Developer:		Notes:
				 * 							05/05/2021	Jared Shaddick	Initial Setup
				 * 							05/10/2021	Jared Shaddick	Modified Method
				 * 							05/15/2021	Jared Shaddick	Modified Method
				 */
				
				if (!gameStarted) {
					replicateColors(1);																									//Adds the number 1 to the replica sequence array
																																		//when the boolean, gameStarted, is false
				}
			}
		});
		btnBlueButton.setBounds(679, 0, 250, 250);
		contentPane.add(btnBlueButton);
		
		btnGreenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				/*
				 * Method				:	actionPerformed
				 * 
				 * Method Parameters	:	ActionEvent e3
				 * 
				 * Method Return		:	Void
				 * 
				 * Synopsis				:	This is the third of four colored buttons that the player will use
				 * 							to replicate the colors in the generated sequence from Match Game Manager
				 * 
				 * Modifications		:	Date:		Developer:		Notes:
				 * 							05/05/2021	Jared Shaddick	Initial Setup
				 * 							05/10/2021	Jared Shaddick	Modified Method
				 * 							05/15/2021	Jared Shaddick	Modified Method
				 */
				
				if (!gameStarted) {
					replicateColors(2);																									//Adds the number 2 to the replica sequence array
																																		//when the boolean, gameStarted, is false
				}
			}
		});

		
		btnGreenButton.setEnabled(false);
		btnGreenButton.setBounds(10, 399, 250, 250);
		btnGreenButton.setPressedIcon(MGM.getTheColors()[2]);
		contentPane.add(btnGreenButton);
		
		btnYellowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				/*
				 * Method				:	actionPerformed
				 * 
				 * Method Parameters	:	ActionEvent e3
				 * 
				 * Method Return		:	Void
				 * 
				 * Synopsis				:	This is the fourth of four colored buttons that the player will use
				 * 							to replicate the colors in the generated sequence from Match Game Manager
				 * 
				 * Modifications		:	Date:		Developer:		Notes:
				 * 							05/05/2021	Jared Shaddick	Initial Setup
				 * 							05/10/2021	Jared Shaddick	Modified Method
				 * 							05/15/2021	Jared Shaddick	Modified Method
				 */
				
				if (!gameStarted) {
					replicateColors(3);																									//Adds the number 3 to the replica sequence array
																																		//when the boolean, gameStarted, is false
				}
				
			}
		});
		btnYellowButton.setEnabled(false);
		btnYellowButton.setBounds(679, 399, 250, 250);
		btnYellowButton.setPressedIcon(MGM.getTheColors()[3]);
		contentPane.add(btnYellowButton);

		
		lblScoreDisplay.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblScoreDisplay.setBounds(270, 615, 184, 34);
		lblScoreDisplay.setText("Score: " + playerScore);
		contentPane.add(lblScoreDisplay);
		
		lblMessageBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageBoard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMessageBoard.setBounds(270, 284, 400, 50);
		contentPane.add(lblMessageBoard);

		btnStartButton.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		btnStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				/*
				 * Method				:	actionPerformed
				 * 
				 * Method Parameters	:	ActionEvent f
				 * 
				 * Method Return		:	void
				 * 
				 * Synopsis				:	This method serves as a means to begin playing the game 
				 * 							as well as provide a means of generating a new sequence
				 * 							for the player to replicate a generated sequence of colors
				 * 							each time a sequence replication attempt is completed so
				 * 							that the game may continue when the player is ready.
				 * 
				 * Modifications		:	Date:		Developer:		Notes:
				 * 							05/05/2021	Jared Shaddick	Initial Setup
				 * 							05/15/2021	Jared Shaddick	Modified Method
				 * 							05/15/2021	Jared Shaddick	Modified Method
				 * 							05/17/2021	Jared Shaddick	Modified Method
				 * 							05/18/2021	Jared Shaddick	Added Comments
				 */
				
				btnStartButton.setEnabled(false);																						//When btnStartButton is pressed, it will be
																																		//disabled until that round has finished
				
				gameStarted = true;																										//Makes the boolean, gameStarted true. This will
																																		//prevent the player from cheating by pressing
																																		//the colored buttons while the generated color 
																																		//sequence is being displayed
				
				timeToShowColor = true;																									//Makes the boolean, timeToShowColor, true.
																																		//Ensuring that the generated color sequence
																																		//is displayed in the @Override ActionPerformed()
																																		//method
				
				btnRedButton.setEnabled(true);																							//Enables btnRedButton
				
				btnBlueButton.setEnabled(true);																							//Enables btnBlueButton
				
				btnYellowButton.setEnabled(true);																						//Enables btnYellowButton
				
				btnGreenButton.setEnabled(true);																						//Enables btnGreenButton
				
				showColor.start();																										//Starts the timer for the @Override
																																		//ActionPerformed() method
				
				replicaSequence = new int[MGM.getColorsInSequence()];																	//Instantiates a new replicaSequence array
																																		//to ensure that the array is empty at the
																																		//start of each round
				
				MGM.generateColorSequence();																							//Calls the generateColorSequence() method from
																																		//the Match Game Manager class to ensure that a
																																		//new sequence of random colors is generated
			}
		});
		btnStartButton.setBounds(401, 345, 150, 50);
		
		contentPane.add(btnStartButton);
		
		lblLevelUpNotifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelUpNotifier.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblLevelUpNotifier.setBounds(352, 80, 250, 50);
		contentPane.add(lblLevelUpNotifier);
		lblLevelDisplay.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblLevelDisplay.setBounds(464, 615, 184, 34);
		lblLevelDisplay.setText("Level: " + MGM.getCurrentLevel());
		contentPane.add(lblLevelDisplay);
		
	}
	
	private void getGameNotificationString() {
		/*
		 * Method				:	getGameNotificationString()
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		: 	Void
		 * 
		 * Synopsis				:	This method will be responsible for displaying an event in the game
		 * 							that indicates if the player failed to replicate the colors or if
		 * 							they were successful
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/09/2021	Jared Shaddick	Initial Setup
		 * 							05/10/2021	Jared Shaddick	Modified Method
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 */
		if (colorsMatch) {
			MGM.calculatePoints(colorsMatch);																							//Calls the calculatePoints() method from the
																																		//Match Game Manager class and passes the
																																		//boolean, colorsMatch, into the method's
																																		//parameter
			
			lblScoreDisplay.setText("Score: " + MGM.getPlayerScore());																	//Updates the score by calling the getter method
																																		//for calculatePoints(), getPlayerScore(), 
																																		//from the Match Game Manager class
			
			lblMessageBoard.setText("Success");																							//Sets the text for lblMessageBoard to "Success"
			
			String successSound = "Audio/Success.wav";																					//Creates a String that points to the location
																																		//of a sound file
			
			playTheSound(successSound);																									//Passes the String into the playTheSound()
																																		//method
		}
		
		if (!colorsMatch && MGM.checkPoints() == false) {
			MGM.calculatePoints(colorsMatch);																							//Calls the calculatePoints() method from the
																																		//Match Game Manager class and passes the
																																		//boolean, colorsMatch, into the method's
																																		//parameter
			
			lblScoreDisplay.setText("Score: " + MGM.getPlayerScore());																	//Updates the score by calling the getter method
																																		//for calculatePoints(), getPlayerScore(), 
																																		//from the Match Game Manager class
			
			lblMessageBoard.setText("Failure");																							//Sets the text for lblMessageBoard to "Failure"
			
			String failSound = "Audio/Nelson.wav";																						//Creates a String that points to the location
																																		//of a sound file
			
			playTheSound(failSound);																									//Passes the String into the playTheSound()
																																		//method
		}
		
		if (!colorsMatch && MGM.checkPoints() == true) {
			MGM.calculatePoints(colorsMatch);																							//Calls the calculatePoints() method from the
																																		//Match Game Manager class and passes the
																																		//boolean, colorsMatch, into the method's
																																		//parameter
			
			lblScoreDisplay.setText("Score: " + MGM.getPlayerScore());																	//Updates the score by calling the getter method
																																		//for calculatePoints(), getPlayerScore(), 
																																		//from the Match Game Manager class
			
			lblMessageBoard.setText("Game Over");																						//Sets the text for lblMessageBoard to 
																																		//"Game Over"
			
			String gameOverSound = "Audio/GameOver.wav";																				//Creates a String that points to the location
																																		//of a sound file
			
			playTheSound(gameOverSound);																								//Passes the String into the playTheSound()
																																		//method
		}
		
		if (MGM.checkLevel() == true && colorsMatch) {
			lblLevelDisplay.setText("Level: " + MGM.getCurrentLevel());																	//Updates the score by calling the getter method
																																		//for the variable currentLevel, 
																																		//getCurrentLevel() from the 
																																		//Match Game Manager class
			
			lblLevelUpNotifier.setText("Level Up!!!");																					//Sets the text for lblMessageBoard to 
																																		//"Level Up!!!"
			
			lblMessageBoard.setText("Success");																							//Sets the text for lblMessageBoard to 
																																		//"Success"
			
			String successSound = "Audio/Success.wav";																					//Creates a String that points to the location
																																		//of a sound file
			
			playTheSound(successSound);																									//Passes the String into the playTheSound()
																																		//method
		}
	}
	private void playTheSound(String gameStateSound) {
		/*
		 * Method				:	playTheSound()
		 * 
		 * Method Parameters	:	String gameStateSound
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	Takes the String parameter which is set by the
		 * 							getGameNotificationString() method (Line 295) and
		 * 							plays the sound requested by the getGameNotificationString()
		 * 							method.
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/13/2021	Jared Shaddick	Initial Setup (Taken from the getGameNotificationString()
		 * 																	   and modified to take any String that points
		 * 																	   to an audio file)
		 * 							05/18/2021	Jared Shaddick	Added Comments
		 */
		
		try {
			File soundFile = new File(gameStateSound);																					//Instantiates a file for using sounds
																																		//creating the instantiated name, soundFile,
																																		//which acquires a specific sound from the
																																		//String parameter, gameStateSound, which gets
																																		//assigned sounds from the 
																																		//getGameNotificationString() method
			
			AudioInputStream soundAudioFile = AudioSystem.getAudioInputStream(soundFile);												//Creates a variable that the method will use
																																		//to save and play audio
			
			Clip winClip = AudioSystem.getClip();																						//Creates a variable that is used to load the
																																		//audio prior to being used
			
			winClip.open(soundAudioFile);																								//Opens the audio file so that it can be played
																																		//when the program is told to play it.
			
			winClip.start();																											//Plays the audio file
		
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");																//Informs mainly the developer that the sound
																																		//could not be played
		}
		btnRedButton.setEnabled(false);																									//disables btnRedButton
		btnBlueButton.setEnabled(false);																								//disables btnBlueButton
		btnYellowButton.setEnabled(false);																								//disables btnYellowButton
		btnGreenButton.setEnabled(false);																								//disables btnGreenButton
		btnStartButton.setEnabled(true);																								//enables btnStartButton
	}
	
	private void startIndicator(String startSound) {
		/*
		 * Method				:	startIndicator()
		 * 
		 * Method Parameters	:	String startSound
		 * 
		 * Method Return		:	void
		 * 
		 * Synopsis				:	This method has been made separate from the getGameNotificationString() 
		 * 							method on Line 340 as the location and the means by which this sound 
		 * 							occurs differs from the getGameNotificationString() method.
		 * 							
		 * Modifications		:	Dates:		Developer:		Notes:
		 * 							05/14/2021	Jared Shaddick	Initial Setup
		 * 							05/18/2021	Jared Shaddick	Comments Added
		 */
		try {
			File startSoundFile = new File(startSound);																					//Instantiates a file for using sounds
																																		//creating the instantiated name, startSoundFile,
																																		//which acquires a specific sound from the
																																		//String parameter, startSound, which gets
																																		//assigned sounds from the 
																																		//@Override ActionPerformed() method
			
			AudioInputStream startSoundAudioFile = AudioSystem.getAudioInputStream(startSoundFile);										//Creates a variable that the method will use
																																		//to save and play audio
			
			Clip winClip = AudioSystem.getClip();																						//Creates a variable that is used to load the
																																		//audio prior to being used
			
			winClip.open(startSoundAudioFile);																							//Opens the audio file so that it can be played
																																		//when the program is told to play it.
			
			winClip.start();																											//Plays the audio file
		
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");																//Informs mainly the developer that the sound
																																		//could not be played
		}
	}
	
	private void replicateColors(int pressedColor) {
		/*
		 * Method				:	replicateColors
		 * 
		 * Method Parameters	:	int pressedColor
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method will be responsible for forming the replica sequence that the player will make
		 * 							and will provide information to the parameters checkColors() and calculatePoints() in
		 * 							Match Game Manager
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Initial Setup Started
		 * 							05/10/2021	Jared Shaddick	Initial Setup Complete
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 * 							05/17/2021	Jared Shaddick	Modified Method
		 * 							05/18/2021	Jared Shaddick	Modified Method
		 * 							05/18/2021	Jared Shaddick	Added New Comments
		 */
		
		replicaSequence[replicaIndex] = pressedColor;																					//Sets the current index for the replicaSequence
																																		//array
		
		replicaIndex++;																													//adds 1 to the replicaIndex each time the method
																																		//is called
		
		if (replicaIndex == replicaSequence.length) {
			colorsMatch = MGM.checkColors(replicaSequence);																				//Sets the boolean, colorsMatch, to either true
																																		//or false depending on if the replicaSequence
																																		//array, which is passed to the parameter
																																		//for the checkColors() method in the Match Game
																																		//Manager class

			getGameNotificationString();																								//Calls the getGameNotificationString() method
			
			replicaIndex = 0;																											//Ensures that the replicaIndex counter is set
																																		//back to zero if the conditional on line 557
																																		//is met
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Method				:	actionPerformed
		 * 
		 * Method Parameters	:	ActionEvent e
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method is responsible for controlling the displaying of the
		 * 							color sequence that the player will have to replicate
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/10/2021	Jared Shaddick	Initial Setup
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 * 							05/14/2021	Jared Shaddick	Modified Method
		 * 							05/15/2021	Jared Shaddick	Modified Method
		 * 							05/18/2021	Jared Shaddick	Modified Method
		 *							05/18/2021	Jared Shaddick	Added New Comments
		 */
		if (gameStarted && timeToShowColor) {
			if (colorsShown) {
				colorIndex = 0;																											//Ensures that colorIndex is zero before
																																		//displaying the colors
				
				colorsShown = false;																									//Sets the boolean, colorShown to false
																																		//so that the program does not set the
																																		//colorIndex variable back to zero before
																																		//it has finished displaying the colors
			}
			if(colorIndex < MGM.getColorsInSequence()) {
				switch (MGM.getGeneratedSequence()[colorIndex]) {																		//Switch statement for displaying colors
				
					case 0:																												//Displays red on btnRedButton if
																																		//MGM.getGeneratedSequence()[colorIndex] is 0
						btnRedButton.setIcon(MGM.getTheColors()[0]);
						break;
					case 1:																												//Displays blue on btnBlueButton if
																																		//MGM.getGeneratedSequence()[colorIndex] is 1
						btnBlueButton.setIcon(MGM.getTheColors()[1]);
						break;
					case 2:																												//Displays green on btnGreenButton if
																																		//MGM.getGeneratedSequence()[colorIndex] is 2
						btnGreenButton.setIcon(MGM.getTheColors()[2]);
						break;
					case 3:																												//Displays yellow on btnYellowButton if
																																		//MGM.getGeneratedSequence()[colorIndex] is 3
						btnYellowButton.setIcon(MGM.getTheColors()[3]);
						break;
				}
				lblMessageBoard.setText("Please Wait");																					//Displays "Please Wait" until the sequence has
																																		//finished displaying
			}
			else if (colorIndex == MGM.getColorsInSequence()){
			gameStarted = false;																										//Sets gameStarted to false to prevent the color
																																		//sequence from being shown twice
			
			colorIndex = 0;																												//Sets colorIndex to 0 so that it can display the
																																		//next sequence of colors properly
			
			lblMessageBoard.setText("GO!");																								//Sets lblMessageBoard's text to inform the
																																		//player that they can start
			
			String goSound = "Audio/Go.wav";																							//Creates a String that points to an audio file
			
			startIndicator(goSound);																									//Passes the String to the parameter in the
																																		//startIndicator() method
			
			colorsShown = true;																											//Sets boolean, colorsShown to false
			}
		}
		else {
			if (colorIndex < MGM.getColorsInSequence()) {
				colorIndex++;																											//Increases the colorIndex counter by 1
			}
			lblMessageBoard.setText("");																								//Allows the text for lblMessageBoard to
																																		//after it is displayed and the timer has ticked
			
			lblLevelUpNotifier.setText("");																								//Allows the text for lblLevelUpNotifier to
																																		//after it is displayed and the timer has ticked
			
			btnRedButton.setIcon(lowRed);																								//Reverts the button color back to default
																																		//after the color is displayed and the timer 
																																		//has ticked
			
			btnBlueButton.setIcon(lowBlue);																								//Reverts the button color back to default
																																		//after the color is displayed and the timer 
																																		//has ticked
			
			btnGreenButton.setIcon(lowGreen);																							//Reverts the button color back to default
																																		//after the color is displayed and the timer 
																																		//has ticked
			
			btnYellowButton.setIcon(lowYellow);																							//Reverts the button color back to default
																																		//after the color is displayed and the timer 
																																		//has ticked
		}
		timeToShowColor = !timeToShowColor;																								//Alternates between true and false for each time
																																		//the timer ticks
	}
}