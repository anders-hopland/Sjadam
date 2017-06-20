package com.mygdx.game.Helpers.Pieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Helpers.Position;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public interface IPiece {
    void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos);

    boolean legalShadamMove();

    boolean legalChessMove();

}
