package Game;

import javax.swing.*;
import java.awt.*;

public class Player extends JLabel { //player extends Jlabel pour son score et sa barre de vie
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
		repaint();
	}
	
	public void removeHp(int hp) {
		currentHp-=hp;
		repaint();
	}

	public void showScore(Graphics g){
		g.setColor(Color.black);
		g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 35));
		g.drawString(String.valueOf(score),700, 570);
	}

	public void showHealth(Graphics g){
		g.setColor(Color.black);
		g.drawRect(10, 570, MAX_HP * 5, 10);
		g.fillRect(10, 570, currentHp * 5, 10);

	}
	public void paintComponent(Graphics g){
		showHealth(g);
		showScore(g);
	}

}


