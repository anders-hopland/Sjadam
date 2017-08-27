package com.mygdx.SjadamGame.Helpers.Pieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Anders-Hopland on 16.06.2017.
 */

public class Knight extends AbstractPiece {

    public Knight(com.mygdx.SjadamGame.Helpers.BOARD_COLOR color) {
        super(color);
        TextureRegion region;
        Texture texture;

        if (color == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
            texture = new Texture(Gdx.files.internal("chess.png"));
            region = new TextureRegion(texture, 128, 0, 128, 128);
        }
        else  {
            texture = new Texture(Gdx.files.internal("chess.png"));
            region = new TextureRegion(texture, 128, 128, 128, 128);
        }

        super.setTextureRegion(region);
    }

    @Override
    public void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos) {
        super.renderPiece(batch, pieceWidth, pieceHeight, xPos, yPos);
    }

    @Override
    public com.mygdx.SjadamGame.Helpers.BOARD_COLOR[][] findMoves(com.mygdx.SjadamGame.Helpers.BOARD_COLOR[][] board, IPiece[][] pieces, int xPos, int yPos) {
        //checking for datainvariant
        if (board.length != pieces.length && board[0].length != pieces[0].length) {
            throw new IllegalStateException();
        }

        if (super.isLegalBoardPosition(xPos + 1, yPos + 2)) {
            if (pieces[yPos + 2][xPos + 1] == null) {
                board[yPos + 2][xPos + 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos + 2][xPos + 1].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos + 2][xPos + 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        if (super.isLegalBoardPosition(xPos - 1, yPos + 2)) {
            if (pieces[yPos + 2][xPos - 1] == null) {
                board[yPos + 2][xPos - 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos + 2][xPos - 1].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos + 2][xPos - 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        if (super.isLegalBoardPosition(xPos + 2, yPos + 1)) {
            if (pieces[yPos + 1][xPos + 2] == null) {
                board[yPos + 1][xPos + 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos + 1][xPos + 2].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos + 1][xPos + 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        if (super.isLegalBoardPosition(xPos - 2, yPos + 1)) {
            if (pieces[yPos + 1][xPos - 2] == null) {
                board[yPos + 1][xPos - 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos + 1][xPos - 2].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos + 1][xPos - 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        if (super.isLegalBoardPosition(xPos + 1, yPos - 2)) {
            if (pieces[yPos - 2][xPos + 1] == null) {
                board[yPos - 2][xPos + 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos - 2][xPos + 1].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos - 2][xPos + 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        if (super.isLegalBoardPosition(xPos - 1, yPos - 2)) {
            if (pieces[yPos - 2][xPos - 1] == null) {
                board[yPos - 2][xPos - 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos - 2][xPos - 1].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos - 2][xPos - 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        if (super.isLegalBoardPosition(xPos + 2, yPos - 1)) {
            if (pieces[yPos - 1][xPos + 2] == null) {
                board[yPos - 1][xPos + 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos - 1][xPos + 2].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos - 1][xPos + 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        if (super.isLegalBoardPosition(xPos - 2, yPos - 1)) {
            if (pieces[yPos - 1][xPos - 2] == null) {
                board[yPos - 1][xPos - 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
            else if (pieces[yPos - 1][xPos - 2].getColor() != pieces[yPos][xPos].getColor()) {
                board[yPos - 1][xPos - 2] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
            }
        }

        return board;
    }
}
