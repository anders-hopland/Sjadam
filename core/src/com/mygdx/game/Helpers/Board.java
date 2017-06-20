package com.mygdx.game.Helpers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Helpers.Pieces.Bishop;
import com.mygdx.game.Helpers.Pieces.IPiece;
import com.mygdx.game.Helpers.Pieces.King;
import com.mygdx.game.Helpers.Pieces.Knight;
import com.mygdx.game.Helpers.Pieces.Pawn;
import com.mygdx.game.Helpers.Pieces.Queen;
import com.mygdx.game.Helpers.Pieces.Rook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public class Board implements IBoard {

    private IPiece[][] pieceList;

    private PLAYER_COLOR[][] boardColors;

    public Board() {
        pieceList = new IPiece[8][8];

        pieceList[0][0] = new Rook(PLAYER_COLOR.WHITE);
        pieceList[1][0] = new Knight(PLAYER_COLOR.WHITE);
        pieceList[2][0] = new Bishop(PLAYER_COLOR.WHITE);
        pieceList[3][0] = new Queen(PLAYER_COLOR.WHITE);
        pieceList[4][0] = new King(PLAYER_COLOR.WHITE);
        pieceList[5][0] = new Bishop(PLAYER_COLOR.WHITE);
        pieceList[6][0] = new Knight(PLAYER_COLOR.WHITE);
        pieceList[7][0] = new Rook(PLAYER_COLOR.WHITE);

        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);
        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);
        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);
        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);
        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);
        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);
        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);
        pieceList[0][1] = new Pawn(PLAYER_COLOR.WHITE);


        boardColors = new PLAYER_COLOR[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    boardColors[i][j] = PLAYER_COLOR.BLACK;
                }
                else if (i % 2 == 0 && j % 2 != 0) {
                    boardColors[i][j] = PLAYER_COLOR.WHITE;
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    boardColors[i][j] = PLAYER_COLOR.BLACK;
                }
                else if (i % 2 != 0 && j % 2 == 0){
                    boardColors[i][j] = PLAYER_COLOR.WHITE;
                }
            }
        }

    }

    @Override
    public boolean legalChessMove() {
        return false;
    }

    @Override
    public boolean legalShadamMove() {
        return false;
    }

    public void renderPieces(SpriteBatch batch, int width, int height) {
        int pieceWidth = width / 8;
        int pieceHeight = height / 8;
        for (int i = 0; i < pieceList.length; i++) {
            for (int j = 0; j < pieceList[i].length; j++) {
                if (pieceList[i][j] != null) {
                    pieceList[i][j].renderPiece(batch, pieceWidth, pieceHeight, j, i);
                }
            }
        }
    }

    public void renderBoard(ShapeRenderer renderer, int width, int height) {
        int rectWidth = width / 8;
        int rectHeight = height / 8;
        for (int i = 0; i < boardColors.length; i++) {
            for (int j = 0; j < boardColors[i].length; j++) {
                if (boardColors[i][j] == PLAYER_COLOR.BLACK) {
                    renderer.setColor(Color.BROWN);
                    renderer.rect(rectWidth * j, rectHeight * i, rectWidth, rectHeight);
                }
                else {
                    renderer.setColor(Color.WHITE);
                    renderer.rect(rectWidth * j, rectHeight * i, rectWidth, rectHeight);
                }
            }
        }
    }
}
