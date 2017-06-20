package com.mygdx.game.Helpers.Pieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Helpers.PLAYER_COLOR;
import com.mygdx.game.Helpers.Position;

/**
 * Created by Anders-Hopland on 16.06.2017.
 */

public class Bishop extends AbstractPiece {
    private PLAYER_COLOR color;

    public Bishop(PLAYER_COLOR color) {
        Sprite sprite;
        Texture texture;

        this.color = color;
        if (color == PLAYER_COLOR.BLACK) {
            texture = new Texture(Gdx.files.internal("chess.png"));
            TextureRegion region = new TextureRegion(texture, 256, 0, 128, 128);
            sprite = new Sprite(region);
        }
        else  {
            texture = new Texture(Gdx.files.internal("chess.png"));
            TextureRegion region = new TextureRegion(texture, 256, 128, 128, 128);
            sprite = new Sprite(region);
        }

        super.setSprite(sprite);
    }

    @Override
    public void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos) {
        super.renderPiece(batch, pieceWidth, pieceHeight, xPos, yPos);
    }

    @Override
    public boolean legalShadamMove() {
        return false;
    }

    @Override
    public boolean legalChessMove() {
        return false;
    }

}
