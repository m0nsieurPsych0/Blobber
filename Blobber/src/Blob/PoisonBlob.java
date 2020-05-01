package Blob;

import java.awt.Color;
import java.awt.Graphics;

import Cursor.CursorBonus;
import Cursor.CursorMalus;
import Game.Game;

public class PoisonBlob extends ABlob {
    private int x, y, w, h;

    public PoisonBlob(int ticksCounter, int damage, int currentHP, int score, int x, int y, int w, int h, Game game) {
        super(ticksCounter, damage, currentHP, score, game);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = Color.RED;
    }

    @Override
    public void pop() {
        super.pop();
        if(hp <= 0){
            game.getPlayer().removeHp(damage);
            game.decorateCursor(new CursorMalus());
        }
    }

    @Override
    protected void drawBlob(Graphics g) {
        setBounds(x, y, w, h);
        g.setColor(color);
        g.fillOval(0, 0, w, h);
    }

}