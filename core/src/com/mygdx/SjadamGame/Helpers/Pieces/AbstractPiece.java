package com.mygdx.SjadamGame.Helpers.Pieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.SjadamGame.Helpers.BOARD_COLOR;
import com.mygdx.SjadamGame.Helpers.Position;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public abstract class AbstractPiece implements IPiece {

    private Position position;
    private TextureRegion textureRegion;
    private BOARD_COLOR color;
    private boolean hasMoved;

    public AbstractPiece(BOARD_COLOR color) {
        this.color = color;
        hasMoved = false;
    }

    @Override
    public void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos) {
        batch.draw(textureRegion, xPos * pieceWidth, yPos * pieceHeight,
                pieceWidth, pieceHeight);
    }

    public void setTextureRegion(TextureRegion region) {
        this.textureRegion = region;
    }

    @Override
    public BOARD_COLOR getColor() {
        return color;
    }

    @Override
    public abstract BOARD_COLOR[][] findMoves(BOARD_COLOR[][] board, IPiece[][] pieces, int posX, int posY);

    @Override
    public boolean hasMoved() {
        return hasMoved;
    }

    @Override
    public void setMoved() {
        hasMoved = true;
    }

    protected boolean isLegalBoardPosition(int xPos, int yPos) {
        if (xPos > 7 || xPos < 0 || yPos > 7 || yPos < 0) {
            return false;
        }

        return true;
    }
}
