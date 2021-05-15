import java.awt.BorderLayout;
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
import java.util.Arrays;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class UserInterface extends JFrame implements ActionListener {

	
	private final Integer ButtonTimer = 1000;
	
	private Boolean timeToShowColor = true;
	
	private Timer showColor = new Timer(ButtonTimer, this);
	
	private JPanel contentPane;
	
	private boolean gameStarted = false;
	
	private boolean colorsMatch;
	
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
	
	MatchGameManager MGM = new MatchGameManager();
	
	private JButton btnStartButton = new JButton("Start");

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
			 * Method Parameters	:	ActionEvent e1
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
		lblScoreDisplay.setBounds(352, 585, 229, 64);
		contentPane.add(lblScoreDisplay);
		
		lblMessageBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageBoard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMessageBoard.setBounds(401, 284, 150, 50);
		contentPane.add(lblMessageBoard);

		btnStartButton.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		btnStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent f) {
				
				btnStartButton.setEnabled(false);
				gameStarted = true;
				btnRedButton.setEnabled(true);
				btnBlueButton.setEnabled(true);
				btnYellowButton.setEnabled(true);
				btnGreenButton.setEnabled(true);
				showColor.start();
			}
		});
		btnStartButton.setBounds(401, 345, 150, 50);
		
		contentPane.add(btnStartButton);
		
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
			lblMessageBoard.setText("Success");
			String successSound = "Audio/Success.wav";
			playTheSound(successSound);
		}
		else if (!colorsMatch) {
			lblMessageBoard.setText("Failure");
			String failSound = "Audio/Nelson.wav";
			playTheSound(failSound);
		}
	}
	private void playTheSound(String sound) {
		try {
			File successFile = new File(sound);
			
			AudioInputStream successAudioFile = AudioSystem.getAudioInputStream(successFile);
			
			Clip winClip = AudioSystem.getClip();
			
			winClip.open(successAudioFile);
			winClip.start();
		
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Problem playing sound");
		}
		btnRedButton.setEnabled(false);
		btnBlueButton.setEnabled(false);
		btnYellowButton.setEnabled(false);
		btnGreenButton.setEnabled(false);
		btnStartButton.setEnabled(true);
		gameStarted = false;
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
		 */
		int[] replicaSequence = new int[MGM.numberOfColors()];
		replicaSequence[replicaIndex] = pressedColor;
		System.out.println(replicaSequence[replicaIndex]);
		replicaIndex++;
		
		if (replicaIndex == replicaSequence.length) {
			colorsMatch = MGM.checkColors(replicaSequence);
			
			playerScore = MGM.calculatePoints(colorsMatch);
			lblScoreDisplay.setText("Score" + playerScore);
			getGameNotificationString();
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
		 */
		
		if (gameStarted) {
			if (timeToShowColor) {
				int colorToDisplay = MGM.setTheSequence()[colorIndex];
				if(colorIndex < MGM.numberOfColors()) {
					do {	
						switch (colorToDisplay) {
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
					} while (colorIndex < MGM.numberOfColors());
				}
				else {
					gameStarted = false;
					colorIndex = 0;
				}
			}
			else {
				colorIndex++;
				btnRedButton.setIcon(lowRed);
				btnBlueButton.setIcon(lowBlue);
				btnGreenButton.setIcon(lowGreen);
				btnYellowButton.setIcon(lowYellow);
			}
		
		}
		timeToShowColor = !timeToShowColor;
	}
}