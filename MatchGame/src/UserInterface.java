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

	
	private final Integer ButtonTimer = 1000;
	
	private Boolean timeToShowColor = true;
	
	private Timer showColor = new Timer(ButtonTimer, this);
	
	private JPanel contentPane;
	
	private boolean gameStarted = false;
	
	private boolean colorsMatch;
	
	private boolean colorsShown;
	
	private int colorIndex = 0;
	
	private int replicaIndex = 0;
	
	private int playerScore = 0;
	
	private ImageIcon lowRed = new ImageIcon("Images/LowRed.png");
	
	private ImageIcon lowBlue = new ImageIcon("Images/LowBlue.png");
	
	private ImageIcon lowGreen = new ImageIcon("Images/LowGreen.png");
	
	private ImageIcon lowYellow = new ImageIcon("Images/LowYellow.png");
	
	private JButton btnRedButton = new JButton(lowRed);
	
	private JButton btnBlueButton = new JButton(lowBlue);
	
	private JButton btnGreenButton = new JButton(lowGreen);
	
	private JButton btnYellowButton = new JButton(lowYellow);
	
	private JLabel lblMessageBoard = new JLabel("");
	
	private JLabel lblScoreDisplay = new JLabel("Score: ");
	
	private JLabel lblLevelUpNotifier = new JLabel("");
	
	MatchGameManager MGM = new MatchGameManager();
	
	private JButton btnStartButton = new JButton("Start");
	
	private JLabel lblLevelDisplay = new JLabel("Level: ");
	
	private int[] replicaSequence;

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
				 * 							05/10/2021	Jared Shaddick	Added Ability To Change Color When Pressed 
				 * 														And Add The Corresponding Color To An Array
				 * 														And Added Comments
				 * 							05/15/2021	Jared Shaddick	Changed The Way The Array Is Created For The Sake Of Simplicity
				 */

				if (!gameStarted) {
					replicateColors(0);
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
				 * 							05/10/2021	Jared Shaddick	Added Ability To Change Color When Pressed 
				 * 														And Add The Corresponding Color To An Array
				 * 														And Added Comments
				 * 							05/15/2021	Jared Shaddick	Changed The Way The Array Is Created For The Sake Of Simplicity
				 */
				
				if (!gameStarted) {
					replicateColors(1);
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
				 * 							05/10/2021	Jared Shaddick	Added Ability To Change Color When Pressed 
				 * 														And Add The Corresponding Color To An Array
				 * 														And Added Comments
				 * 							05/15/2021	Jared Shaddick	Changed The Way The Array Is Created For The Sake Of Simplicity
				 */
				
				if (!gameStarted) {
					replicateColors(2);
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
				 * 							05/10/2021	Jared Shaddick	Added Ability To Change Color When Pressed 
				 * 														And Add The Corresponding Color To An Array
				 * 														And Added Comments
				 * 							05/15/2021	Jared Shaddick	Changed The Way The Array Is Created For The Sake Of Simplicity
				 */
				
				if (!gameStarted) {
					replicateColors(3);
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
				 * 							05/15/2021	Jared Shaddick	Added A Variable To Ensure The Privately Declared, 
				 * 														Global, boolean Variable, timeToShowColor is true.
				 * 							05/15/2021	Jared Shaddick	Added Line 275 To Create A New Randomly Generated
				 * 														Color Sequence Each Time btnStartButton Is Clicked
				 * 							05/17/2021	Jared Shaddick	Added Line 274 To Ensure That The Array That The
				 * 														Player Creates Is Emptied Each Round.
				 * 							05/18/2021	Jared Shaddick	Added Comments
				 */
				
				btnStartButton.setEnabled(false);
				gameStarted = true;
				timeToShowColor = true;
				btnRedButton.setEnabled(true);
				btnBlueButton.setEnabled(true);
				btnYellowButton.setEnabled(true);
				btnGreenButton.setEnabled(true);
				showColor.start();
				
				replicaSequence = new int[MGM.getColorsInSequence()];
				MGM.generateColorSequence();
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
		 * 							05/10/2021	Jared Shaddick	Merged Success And Fail Sounds
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 */
		if (colorsMatch) {
			MGM.calculatePoints(colorsMatch);
			lblScoreDisplay.setText("Score: " + MGM.getPlayerScore());
			lblMessageBoard.setText("Success");
			String successSound = "Audio/Success.wav";
			playTheSound(successSound);
		}
		if (!colorsMatch && MGM.checkPoints() == false) {
			MGM.calculatePoints(colorsMatch);
			lblScoreDisplay.setText("Score: " + MGM.getPlayerScore());
			lblMessageBoard.setText("Failure");
			String failSound = "Audio/Nelson.wav";
			playTheSound(failSound);
		}
		if (!colorsMatch && MGM.checkPoints() == true) {
			MGM.calculatePoints(colorsMatch);
			lblScoreDisplay.setText("Score: " + MGM.getPlayerScore());
			lblMessageBoard.setText("Game Over");
			String gameOverSound = "Audio/GameOver.wav";
			playTheSound(gameOverSound);
		}
		if (MGM.checkLevel() == true && colorsMatch) {
			lblLevelDisplay.setText("Level: " + MGM.getCurrentLevel());
			lblLevelUpNotifier.setText("Level Up!!!");
			lblMessageBoard.setText("Success");
			String successSound = "Audio/Success.wav";
			playTheSound(successSound);
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
			File soundFile = new File(gameStateSound);
			
			AudioInputStream soundAudioFile = AudioSystem.getAudioInputStream(soundFile);
			
			Clip winClip = AudioSystem.getClip();
			
			winClip.open(soundAudioFile);
			winClip.start();
		
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");
		}
		btnRedButton.setEnabled(false);
		btnBlueButton.setEnabled(false);
		btnYellowButton.setEnabled(false);
		btnGreenButton.setEnabled(false);
		btnStartButton.setEnabled(true);
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
			File startSoundFile = new File(startSound);
			
			AudioInputStream startSoundAudioFile = AudioSystem.getAudioInputStream(startSoundFile);
			
			Clip winClip = AudioSystem.getClip();
			
			winClip.open(startSoundAudioFile);
			winClip.start();
		
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");
		}
	}
	
	private void replicateColors(int pressedColor) {
		/*
		 * Method				:	replicateColors
		 * 
		 * Method Parameters	:	ImageIcon pressedColor
		 * 
		 * Method Return		:	ImageIcon[]
		 * 
		 * Synopsis				:	This method will be responsible for forming the replica sequence that the player will make
		 * 							and will provide information to the parameters checkColors() and calculatePoints() in
		 * 							Match Game Manager
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/05/2021	Jared Shaddick	Initial Setup Started
		 * 							05/10/2021	Jared Shaddick	Initial Setup Complete
		 * 							05/11/2021	Jared Shaddick	Added Comments
		 * 							05/17/2021	Jared Shaddick	Moved Some Lines To Different Methods
		 * 														In The User Interface Class Where It Was
		 * 														More Appropriate And Sensible
		 * 							05/18/2021	Jared Shaddick	Added New Comments
		 */
		
		replicaSequence[replicaIndex] = pressedColor;
		replicaIndex++;
		
		if (replicaIndex == replicaSequence.length) {
			colorsMatch = MGM.checkColors(replicaSequence);

			getGameNotificationString();
			replicaIndex = 0;
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
		 * 							05/14/2021	Jared Shaddick	Changed Method To Read Integer Arrays
		 * 														And Replaced The Conditional Color Display
		 * 														Checks With A Simpler To Understand Switch
		 * 														Statement
		 * 							05/15/2021	Jared Shaddick	Added Lines 483-485 To Tell The Player
		 * 														When They Can Start Replicating The Sequence
		 * 							05/18/2021	Jared Shaddick	Added Line 480 As A Means To Help Remind The
		 * 														Player To Wait Until The Text And Sound Telling
		 * 														The Player To Start Occurs
		 *							05/18/2021	Jared Shaddick	Added Line 498 So That Text Disappears
		 *														After It Is Displayed And Its Purpose
		 *														Was Served
		 *							05/18/2021	Jared Shaddick	Added New Comments
		 */
		if (gameStarted && timeToShowColor) {
			if (colorsShown) {
				colorIndex = 0;
				colorsShown = false;
			}
			if(colorIndex < MGM.getColorsInSequence()) {
				switch (MGM.getGeneratedSequence()[colorIndex]) {
					case 0:
						btnRedButton.setIcon(MGM.getTheColors()[0]);
						break;
					case 1:
						btnBlueButton.setIcon(MGM.getTheColors()[1]);
						break;
					case 2:
						btnGreenButton.setIcon(MGM.getTheColors()[2]);
						break;
					case 3:
						btnYellowButton.setIcon(MGM.getTheColors()[3]);
						break;
				}
				lblMessageBoard.setText("Please Wait");
			}
			else if (colorIndex == MGM.getColorsInSequence()){
			gameStarted = false;
			colorIndex = 0;
			lblMessageBoard.setText("GO!");
			String goSound = "Audio/Go.wav";
			startIndicator(goSound);
			colorsShown = true;
			}
		}
		else {
			if (colorIndex < MGM.getColorsInSequence()) {
				colorIndex++;
			}
			lblMessageBoard.setText("");
			btnRedButton.setIcon(lowRed);
			btnBlueButton.setIcon(lowBlue);
			btnGreenButton.setIcon(lowGreen);
			btnYellowButton.setIcon(lowYellow);
		}
		timeToShowColor = !timeToShowColor;
	}
}