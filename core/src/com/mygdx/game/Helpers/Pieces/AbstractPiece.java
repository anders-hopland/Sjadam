package com.mygdx.game.Helpers.Pieces;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Helpers.Position;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public abstract class AbstractPiece implements IPiece {

    private Position position;
    private Sprite sprite;

    public AbstractPiece() {

    }

    @Override
    public void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos) {
        batch.draw(sprite, xPos * pieceWidth, yPos * pieceHeight,
                pieceWidth, pieceHeight);
    }

    @Override
    public boolean legalShadamMove() {
        return false;
    }

    @Override
    public boolean legalChessMove() {
        return false;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
