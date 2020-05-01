package Blob;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import Game.*;

public abstract class ABlob extends JLabel implements LoopObserver {

	protected int ticksCounter;
	protected int damage;
	protected int hp;
	protected int score;
	protected Game game;
	protected Color color;
	
	public ABlob(int ticksCounter, int damage, int hp, int score, Game game) {
		super();
		this.ticksCounter = ticksCounter;
		this.damage = damage;
		this.hp = hp;
		this.score = score;
		this.game = game;
		GameLoop.getInstance().registerObserver(this);
	}
	
	public void tick() {
		ticksCounter--;
		if (ticksCounter <= 0)
			pop();
	}
	
	
	public void paintComponent(Graphics g){
		drawBlob(g);
		drawHealthBar(g);
	}

	protected abstract void drawBlob(Graphics g);

	protected void drawHealthBar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, hp * 10, 2);
	}

	public void pop() {
		game.removeBlobFromGame(this);
		GameLoop.getInstance().unregisterObserver(this);
	}
	
	public void hit() {
		hp -= 1;
		if (hp <= 0)
			pop();

		// redessine la barre de vie du blob
		repaint();
	}
}