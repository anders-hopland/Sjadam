package com.mygdx.SjadamGame.Helpers.Pieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.SjadamGame.Helpers.BOARD_COLOR;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public interface IPiece {
    void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos);

    BOARD_COLOR getColor();

    BOARD_COLOR[][] findMoves(BOARD_COLOR[][] board, IPiece[][] pieces, int posX, int posY);

    void setMoved();

    boolean hasMoved();
}
