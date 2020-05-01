package Popper;

import Blob.ABlob;
import Game.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEnterPopper implements MouseListener {

    private ABlob b;
    public MouseEnterPopper(ABlob b) {
        this.b = b;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Poison blob player damage as the cursor touch the blob
        b.hit();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}

