package Game;

import javax.swing.*;
import java.awt.*;

public class Player extends JLabel { //player extends Jlabel pour son score
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
	
	public void removeHp(int hp) {
		currentHp-=hp;
		repaint();
	}

	public void showScore(int score){}

	public void showHealth(Graphics g){
		g.setColor(Color.black);
		g.drawRect(10, 570, MAX_HP * 5, 10);
		g.fillRect(10, 570, currentHp * 5, 10);

	}
	public void paintComponent(Graphics g){
		showHealth(g);
	}
}


