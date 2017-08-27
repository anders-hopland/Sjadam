package com.mygdx.SjadamGame.Helpers.Pieces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.SjadamGame.Helpers.BOARD_COLOR;

/**
 * Created by Anders-Hopland on 14.06.2017.
 */

public class King extends AbstractPiece {


    public King(BOARD_COLOR color) {
        super(color);
        TextureRegion region;
        Texture texture;

        if (color == BOARD_COLOR.BLACK) {
            texture = new Texture(Gdx.files.internal("chess.png"));
            region = new TextureRegion(texture, 640, 0, 128, 128);
        }
        else  {
            texture = new Texture(Gdx.files.internal("chess.png"));
            region = new TextureRegion(texture, 640, 128, 128, 128);
        }

        super.setTextureRegion(region);
    }

    @Override
    public void renderPiece(SpriteBatch batch, int pieceWidth, int pieceHeight, int xPos, int yPos) {
        super.renderPiece(batch, pieceWidth, pieceHeight, xPos, yPos);
    }

    @Override
    public BOARD_COLOR[][] findMoves(BOARD_COLOR[][] board, com.mygdx.SjadamGame.Helpers.Pieces.IPiece[][] pieces, int xPos, int yPos) {

        if (board.length != pieces.length && board[0].length != pieces[0].length) {
            throw new IllegalStateException();
        }

        //regular chess moves
        for (int y = - 1; y <= 1; y++) {
            for (int x = - 1; x <= 1; x++) {
                if (super.isLegalBoardPosition(xPos + x, yPos + y)) {
                    if (pieces[yPos + y][xPos + x] == null) {
                        board[yPos + y][xPos + x] = BOARD_COLOR.PURPLE;
                    }
                    //not same player color
                    else if (pieces[yPos + y][xPos + x].getColor() != pieces[yPos][xPos].getColor()) {
                        board[yPos + y][xPos + x] = BOARD_COLOR.PURPLE;
                    }
                }
            }
        }

        //castling
        if (super.hasMoved() == false) { //king cannot have moved for castling
            //long castling
            if (pieces[yPos][0] instanceof com.mygdx.SjadamGame.Helpers.Pieces.Rook) {
                if (pieces[yPos][0].hasMoved() == false) {
                    if (pieces[yPos][1] == null && pieces[yPos][2] == null && pieces[yPos][3] == null) {
                        board[yPos][2] = BOARD_COLOR.ORANGE;
                    }
                }
            }

            //short castling
            if (pieces[yPos][7] instanceof com.mygdx.SjadamGame.Helpers.Pieces.Rook) {
                if (pieces[yPos][7].hasMoved() == false) {
                    if (pieces[yPos][6] == null && pieces[yPos][5] == null) {
                        board[yPos][6] = BOARD_COLOR.ORANGE;
                    }
                }
            }
        }
        
        return board;
    }
}
