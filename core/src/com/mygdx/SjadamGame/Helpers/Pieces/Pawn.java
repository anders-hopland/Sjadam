package com.mygdx.SjadamGame.Helpers.Pieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.SjadamGame.SjadamGame;

/**
 * Created by Anders-Hopland on 16.06.2017.
 */

public class Pawn extends AbstractPiece {

    public Pawn(com.mygdx.SjadamGame.Helpers.BOARD_COLOR color) {
        super(color);
        TextureRegion region;

        if (color == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
            super.setTextureRegion(SjadamGame.assetManager.getBlackPawn());
        }
        else  {
            super.setTextureRegion(SjadamGame.assetManager.getWhitePawn());
        }
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

        //no need to check fro legal position since piece has not moved yet
        if (super.hasMoved() == false) {
            if (super.getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
                if (pieces[yPos - 1][xPos] == null) {
                    board[yPos - 1][xPos] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                    if (pieces[yPos - 2][xPos] == null) {
                        board[yPos - 2][xPos] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                    }
                }
            }
            else if (super.getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.WHITE) {
                if (pieces[yPos + 1][xPos] == null) {
                    board[yPos + 1][xPos] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                    if (pieces[yPos + 2][xPos] == null) {
                        board[yPos + 2][xPos] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                    }
                }
            }
        }
        else {
            if (super.getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
                if (pieces[yPos - 1][xPos] == null) {
                    board[yPos - 1][xPos] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                }
                if (super.isLegalBoardPosition(xPos + 1, yPos - 1)) {
                    if (pieces[yPos - 1][xPos + 1] != null) {
                        if (pieces[yPos - 1][xPos + 1].getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
                            board[yPos - 1][xPos + 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                        }
                    }
                }
                if (super.isLegalBoardPosition(xPos - 1, yPos - 1)) {
                    if (pieces[yPos - 1][xPos - 1] != null) {
                        if (pieces[yPos - 1][xPos - 1].getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
                            board[yPos - 1][xPos - 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                        }
                    }
                }
            }
            else if (super.getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.WHITE) {
                if (super.isLegalBoardPosition(xPos, yPos + 1)) {
                    if (pieces[yPos + 1][xPos] == null) {
                        board[yPos + 1][xPos] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                    }
                }
                if (super.isLegalBoardPosition(xPos + 1, yPos + 1)) {
                    if (pieces[yPos + 1][xPos + 1] != null) {
                        if (pieces[yPos + 1][xPos + 1].getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
                            board[yPos + 1][xPos + 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                        }
                    }
                }
                if (super.isLegalBoardPosition(xPos - 1, yPos + 1)) {
                    if (pieces[yPos + 1][xPos - 1] != null) {
                        if (pieces[yPos + 1][xPos - 1].getColor() == com.mygdx.SjadamGame.Helpers.BOARD_COLOR.BLACK) {
                            board[yPos + 1][xPos - 1] = com.mygdx.SjadamGame.Helpers.BOARD_COLOR.PURPLE;
                        }
                    }
                }
            }
        }

        return board;
    }
}
