package extra;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	String word;
	int puzzle;
	ArrayList<JLabel>underscore = new ArrayList<JLabel>();
	Stack<String>words = new Stack<String>();
	void makeList() {
		try {
			BufferedReader br = new BufferedReader(new  FileReader("/Users/league/git/L3_Module_5/src/extra/wordlistthing"));
			
			String line = br.readLine();
					while(line!=null) {
						words.add(line);
						line = br.readLine();
					}
					br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	void UI() {
		makeList();
		addPuzzles();
		System.out.println(words.size());
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		for (JLabel jLabel : underscore) {
			panel.add(jLabel);
		}
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
	}
	void addPuzzles() {
		System.out.println(words.size());
		puzzle = new Random().nextInt(1001);
		word = words.get(puzzle);
		System.out.println(word);
		for (int i = 0; i < word.length(); i++) {
			underscore.add(new JLabel("_"));
		}
	}
	private void updateSpacesWithUserInput(char keyChar) { for (int i = 0; i < word.length(); i++) {
		if (word.charAt(i) == keyChar) { underscore.get(i).setText("" + keyChar);
		} }
		}
	private String getCurrentAnswer() {
		StringBuffer answer = new StringBuffer(); for (JLabel textBox : underscore) {
		answer.append(textBox.getText()); }
		return answer.toString(); }

	public static void main(String[] args) {
		new Hangman().UI();
	}
	void hasCorrectAnswer() {
		if(getCurrentAnswer().equals(word)) {
			JOptionPane.showMessageDialog(null, "you win :)");
			loadNextPuzzle();
		}
	}
	void removeBoxes() {
		underscore.clear();
	}
	void createBoxes() {
		for (int i = 0; i < word.length(); i++) {
			underscore.add(new JLabel("_"));
		}
	}
	private void loadNextPuzzle() { removeBoxes();
	addPuzzles();
	createBoxes();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		hasCorrectAnswer();
		updateSpacesWithUserInput(e.getKeyChar());
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
