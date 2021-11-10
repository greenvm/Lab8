import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener{
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel guessLabel;
  JLabel feedbackLabel;
  JLabel prevGuessLabel;
  JFrame frame = new JFrame ("");

  Random rand = new Random();
  int randNum; 

  GuessingGame() {
    randNum = rand.nextInt(101);

    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    guessLabel = new JLabel("Enter your guess");
    feedbackLabel = new JLabel("");
    prevGuessLabel = new JLabel("");

    frame.add(guessLabel);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(feedbackLabel);
    frame.add(prevGuessLabel);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    int guess = Integer.parseInt(userGuess.getText());

    if(ae.getActionCommand().equals("Guess")){
      if(guess > randNum){
        feedbackLabel.setText("Too high!");
      }
      else if(guess < randNum){
        feedbackLabel.setText("Too low!");
      }
      else if(guess == randNum){
        feedbackLabel.setText("You got it!");
      }
      prevGuessLabeL.setText("Last guess" + guess)
    }
    else if(ae.getActionCommand().equals("Play Again")){
      randNum = rand.nextInt(101); 
    }

  }
}