package com.mygdx.SjadamGame.Helpers.Pieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.SjadamGame.Helpers.BOARD_COLOR;

/**
 * Created by Anders-Hopland on 16.06.2017.
 */

public class Queen extends AbstractPiece {

    public Queen(BOARD_COLOR color) {
        super(color);
        TextureRegion region;
        Texture texture;

        if (color == BOARD_COLOR.BLACK) {
            texture = new Texture(Gdx.files.internal("chess.png"));
            region = new TextureRegion(texture, 512, 0, 128, 128);
        }
        else  {
            texture = new Texture(Gdx.files.internal("chess.png"));
            region = new TextureRegion(texture, 512, 128, 128, 128);
        }

        super.setTextureRegion(region);
    }

    @Override
    public void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos) {
        super.renderPiece(batch, pieceWidth, pieceHeight, xPos, yPos);
    }

    @Override
    public BOARD_COLOR[][] findMoves(BOARD_COLOR[][] board, IPiece[][] pieces, int xPos, int yPos) {
        if (board.length != pieces.length && board[0].length != pieces[0].length) {
            throw new IllegalStateException();
        }

        //vertical upwards
        if (isLegalBoardPosition(xPos, yPos + 1)) {
            for (int i = yPos + 1; i < 8; i++) {
                if (pieces[i][xPos] == null) {
                    board[i][xPos] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[i][xPos].getColor() != super.getColor()) {
                    board[i][xPos] = BOARD_COLOR.PURPLE;
                    break;
                }
                else {
                    break;
                }
            }
        }

        //vertical downwards
        if (isLegalBoardPosition(xPos, yPos - 1)) {
            for (int i = yPos - 1; i >= 0; i--) {
                if (pieces[i][xPos] == null) {
                    board[i][xPos] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[i][xPos].getColor() != super.getColor()) {
                    board[i][xPos] = BOARD_COLOR.PURPLE;
                    break;
                }
                else {
                    break;
                }
            }
        }

        //horizontal right
        if (isLegalBoardPosition(xPos + 1, yPos)) {
            for (int i = xPos + 1; i < 8; i++) {
                if (pieces[yPos][i] == null) {
                    board[yPos][i] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[yPos][i].getColor() != super.getColor()) {
                    board[yPos][i] = BOARD_COLOR.PURPLE;
                    break;
                }
                else {
                    break;
                }
            }
        }

        //horizontal left
        if (isLegalBoardPosition(xPos - 1, yPos)) {
            for (int i = xPos - 1; i >= 0; i--) {
                if (pieces[yPos][i] == null) {
                    board[yPos][i] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[yPos][i].getColor() != super.getColor()) {
                    board[yPos][i] = BOARD_COLOR.PURPLE;
                    break;
                }
                else {
                    break;
                }
            }
        }

        //upwards right
        if (isLegalBoardPosition(xPos + 1, yPos + 1)) {
            for (int i = yPos + 1, j = xPos + 1; i < 8 && j < 8; i++, j++) {
                if (pieces[i][j] == null) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[i][j].getColor() != super.getColor()) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                    break;
                } else {
                    break;
                }
            }
        }

        //upwards left
        if (isLegalBoardPosition(xPos - 1, yPos + 1)) {
            for (int i = yPos + 1, j = xPos - 1; i < 8 && j >= 0; i++, j--) {
                if (pieces[i][j] == null) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[i][j].getColor() != super.getColor()) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                    break;
                } else {
                    break;
                }
            }
        }

        //downwards right
        if (isLegalBoardPosition(xPos + 1, yPos - 1)) {
            for (int i = yPos - 1, j = xPos + 1; i >= 0 && j < 8; i--, j++) {
                if (pieces[i][j] == null) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[i][j].getColor() != super.getColor()) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                    break;
                } else {
                    break;
                }
            }
        }

        //upwards left
        if (isLegalBoardPosition(xPos - 1, yPos - 1)) {
            for (int i = yPos - 1, j = xPos - 1; i >= 0 && j >= 0; i--, j--) {
                if (pieces[i][j] == null) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                }
                //Players can only have two different colors, and rooks can move in all directions regardless
                //of color
                else if (pieces[i][j].getColor() != super.getColor()) {
                    board[i][j] = BOARD_COLOR.PURPLE;
                    break;
                } else {
                    break;
                }
            }
        }

        return board;
    }
}
