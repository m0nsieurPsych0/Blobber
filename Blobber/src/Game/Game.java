package Game;

import Blob.ABlob;
import Blob.BlobFactory;
import Cursor.ACursorDecorator;
import Cursor.BaseCursor;
import Cursor.ICursor;
import HighScore.HighScoresManager;
import HighScore.Score;
import UI.*;

public class Game implements LoopObserver {
	private int ticksBeforeNewBlob, ticksBeforeNewBlobCounter;
	private ICursor c;
	private AppWindow appWindow;
	private Player player;
	private GameFrame gameFrame;
	private BlobFactory blobFactory; 
	private HighScoresManager hsm;
	
	public Game () {
		hsm = new HighScoresManager();
		appWindow = new AppWindow(this);
		appWindow.showScore(hsm.getScores());
		gameFrame = new GameFrame();
	}
	
	public void startGame(String name) {
		blobFactory = new BlobFactory(gameFrame.getWidth(), gameFrame.getHeight());
		c = new BaseCursor();
		player = new Player(name);
		GameLoop.getInstance().registerObserver(this);
		gameFrame.setVisible(true);
		Thread t = new Thread(GameLoop.getInstance());
		t.start();
		ticksBeforeNewBlobCounter = 20;
		ticksBeforeNewBlob = 0;
	}
	
	public void endGame() {
		hsm.addScore(new Score(player.getScore(), player.getName()));
		appWindow.showScore(hsm.getScores());
		gameFrame.setVisible(false);
		GameLoop.getInstance().endGame();
		gameFrame.removeAllBlobs();
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public void tick() {

		gameFrame.addPlayerStatus(player); //Player Ui

		if (player.getHP() <0) {
			endGame();
		}
		if (ticksBeforeNewBlob > 0) {
			ticksBeforeNewBlob--;
		} else {	
			System.out.println("Creation d'un blob");
			ABlob b = blobFactory.createBlob(this); //Création d'un blob
			gameFrame.addBlob(b);
			
			// logique de creation des blobs
			ticksBeforeNewBlobCounter -= 1;
			ticksBeforeNewBlob = ticksBeforeNewBlobCounter;
		}

	}

	public void removeBlobFromGame(ABlob b) {
		gameFrame.removeBlob(b);
	}
	
	public void decorateCursor(ACursorDecorator cd) {
		cd.decorate(c);
		c = cd;
	}

	public int getCursorDamage() {
		return c.getDamage();
	}
}
