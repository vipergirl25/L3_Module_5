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
	int life = 5;
	int tries;
	boolean decrementlife;
	String word;
	int puzzle;
	String underscore;
	Stack<String>words = new Stack<String>();
	JPanel panel = new JPanel();
	JLabel underscores = new JLabel();
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
		System.out.println(words.size());
		JFrame frame = new JFrame();
		panel.add(underscores);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
		frame.setSize(400, 300);
		
		play();
		
	}
	void play() {
		destroyBoxes();
		System.out.println("boxes of destruction");
		panel.removeAll();
		String play = JOptionPane.showInputDialog("do you want to play with me? 1 for yes, 2 for no.");
		if(play.equals("1")) {
			addPuzzles();
		}else {
			JOptionPane.showMessageDialog(null, "i'm hurt. we aren't friends anymore. bye.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	void addPuzzles() {
		drawBoxes();
	}
	private void updateSpacesWithUserInput(char keyChar) { for (int i = 0; i < word.length(); i++) {
		if (word.charAt(i) == keyChar) { 
			underscore.substring(0, i);
			//work on substring next week
		} }
		}
	private String getCurrentAnswer() {
		StringBuffer answer = new StringBuffer(); for (int i = 0; i<underscore.length(); i++) {
		answer.append(underscore); }
		return answer.toString(); }

	public static void main(String[] args) {
		new Hangman().UI();
	}
	void newWord() {
		puzzle = new Random().nextInt(1001);
		word = words.get(puzzle);
		System.out.println(word);
	}
	void hasCorrectAnswer() {
		if(getCurrentAnswer().equals(word)) {
			JOptionPane.showMessageDialog(null, "you win :):):)");
			play();
		}
	}
	void drawBoxes() {
		destroyBoxes();
		newWord();
		panel.removeAll();
		for (int i = 0; i < word.length(); i++) {
			underscore+="_";
		}
		underscores.setText(underscore);
	}
	void destroyBoxes() {
		underscore="";
	}
	@Override
	public void keyTyped(KeyEvent e) {
		decrementlife=false;
		hasCorrectAnswer();
		updateSpacesWithUserInput(e.getKeyChar());
		for (int i = 0; i < word.length(); i++) {
			if(e.getKeyChar() == word.charAt(i)) {
				System.out.println("hiheykdaj;fksldj");
				decrementlife=false;
				break;
			}else if(i==word.length()-1 && e.getKeyChar() !=word.charAt(i)) {
				tries++;
			}
		}
		if(tries==10) {
			System.out.println("hi");
			System.exit(0);
		}
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
