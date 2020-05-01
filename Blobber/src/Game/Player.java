package Game;

import javax.swing.*;

public class Player extends JLabel {
	private final int MAX_HP = 50;
	private String name;
	private int currentHp, score;
	
	public Player (String name) {
		this.name = name;
		currentHp = MAX_HP;
		score = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHP() { 
		return currentHp;
	}
	
	public int getScore() { 
		return score;
	}
	
	public void addScore(int score) {
		this.score+=score;
	}
	
	public void removeHp(int hp) { currentHp-=hp;}
}


