import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessGame extends JFrame {
	private JTextField textField;
	private JLabel feedback;
	private int theNumber;
	private JLabel countguesses;
	int count;

	public void NewGame() {
		theNumber = (int) (Math.random() * 100 + 1);
		count=7;
	}

	public void CheckGuess() {
		String guessText = textField.getText();
		
		try {
			int guess = Integer.parseInt(guessText);
			count --; 
			if (guess > theNumber) {
				feedback.setText(guess + " was too high. Try again. ");
				countguesses.setText(" You have " + count + " guesses left. ");
			} else if (guess < theNumber) {
				feedback.setText(guess + " was too low. Try again. ");
				countguesses.setText(" You have " + count + " guesses left. ");
			} else {
				feedback.setText(guess + " was correct. You win. Let's play again. ");
				countguesses.setText(" You guessed the right number in " + (7-count) + " guesses. ");
				NewGame();
				count =7;
			}
			if (count <= 0) {
				javax.swing.JOptionPane.showConfirmDialog(null, " Game over. The number was " + theNumber + " . Do you want to play again? ");
				NewGame();
			}
	
		} catch (Exception e) {
			feedback.setText(" Please enter a whole number between 1 and 100. ");
		} finally {
			textField.requestFocus();
			textField.selectAll();
		}
	}

	public GuessGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(128, 0, 0));
		setBackground(new Color(128, 0, 0));
		getContentPane().setLayout(null);

		JLabel lblMyGuessingGame = new JLabel("My guessing game");
		lblMyGuessingGame.setBounds(51, 37, 436, 33);
		lblMyGuessingGame.setForeground(new Color(255, 255, 255));
		lblMyGuessingGame.setBackground(new Color(240, 240, 240));
		lblMyGuessingGame.setFont(new Font("Ravie", Font.BOLD, 18));
		lblMyGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblMyGuessingGame);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.setBounds(197, 182, 144, 23);
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckGuess();
			}
		});
		btnGuess.setFont(new Font("Ravie", Font.BOLD, 18));
		getContentPane().add(btnGuess);

		feedback = new JLabel("Enter a number above and click Guess!");
		feedback.setBounds(20, 242, 499, 57);
		feedback.setForeground(new Color(255, 255, 255));
		feedback.setFont(new Font("Ravie", Font.PLAIN, 13));
		feedback.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(feedback);

		JPanel panel = new JPanel();
		panel.setBounds(20, 107, 499, 38);
		panel.setBackground(new Color(128, 0, 0));
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100: ");
		lblGuessANumber.setForeground(new Color(255, 255, 255));
		lblGuessANumber.setBounds(10, 5, 388, 20);
		panel.add(lblGuessANumber);
		lblGuessANumber.setFont(new Font("Ravie", Font.PLAIN, 16));

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckGuess();
			}
		});
		textField.setBounds(412, 6, 65, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		countguesses = new JLabel("You have 7 guesses.");
		countguesses.setHorizontalAlignment(SwingConstants.CENTER);
		countguesses.setFont(new Font("Ravie", Font.BOLD, 12));
		countguesses.setForeground(new Color(255, 255, 255));
		countguesses.setBounds(61, 336, 417, 33);
		getContentPane().add(countguesses);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessGame theGame = new GuessGame();
		theGame.NewGame();
		theGame.setSize(new Dimension(530, 400));
		theGame.setVisible(true);
	}
}
