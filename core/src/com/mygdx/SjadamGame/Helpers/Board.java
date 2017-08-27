package com.mygdx.SjadamGame.Helpers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.SjadamGame.Helpers.Pieces.Bishop;
import com.mygdx.SjadamGame.Helpers.Pieces.Knight;
import com.mygdx.SjadamGame.Helpers.Pieces.Pawn;
import com.mygdx.SjadamGame.Helpers.Pieces.Rook;

import java.util.HashMap;

/**
 * Created by Anders-Hopland on 08.06.2017.
 */

public class Board extends Actor implements IBoard {

    private com.mygdx.SjadamGame.Helpers.Pieces.IPiece[][] pieceList;

    //holding colors including sjadammoves and chessmoves
    private BOARD_COLOR[][] boardColors;
    //holding only board colors
    private BOARD_COLOR[][] boardWithoutMoves;

    //if player has clicked on screen
    private boolean activeClick;

    private Vector2 clickPosition;
    private java.util.Map colorMap;

    private boolean playing;

    //max 1 jump over opponent
    private boolean jumpedOverOpponent;
    private int jumpedOverOpponentX;
    private int jumpedOverOpponentY;

    //which player is eligble to make a move
    private BOARD_COLOR playerTurn;

    //managing which piece was clicked and resetting piece if player aborts move
    private com.mygdx.SjadamGame.Helpers.Pieces.IPiece pieceClicked;
    private int xPositionPieceClicked;
    private int yPositionPieceClicked;
    private int currentXPositionPieceClicked;
    private int currentYPositionPieceClicked;


    public Board() {
        activeClick = false;
        clickPosition = new Vector2();

        playing = true;
        jumpedOverOpponent = false;

        playerTurn = BOARD_COLOR.WHITE;

        setUpBoard();

        colorMap = new HashMap<BOARD_COLOR, Color>();
        colorMap.put(BOARD_COLOR.BLACK, new Color(139f/255f, 69f/255f, 19f/255f, 1f));
        colorMap.put(BOARD_COLOR.WHITE, new Color(255f/255f, 235f/255f, 205f/255f, 1f));
        colorMap.put(BOARD_COLOR.BLUE, Color.BLUE);
        colorMap.put(BOARD_COLOR.RED, Color.RED);
        colorMap.put(BOARD_COLOR.PURPLE, Color.PURPLE);
        colorMap.put(BOARD_COLOR.ORANGE, Color.ORANGE);
        colorMap.put(BOARD_COLOR.LIGHT_BLUE, new Color(102f/255f, 163f/255f, 255f/255f, 1f));
        colorMap.put(BOARD_COLOR.DARK_BLUE, new Color(0f/255f, 102f/255f, 255f/255f, 1f));
        colorMap.put(BOARD_COLOR.LIGHT_RED, new Color(255f/255f, 128f/255f, 128f/255f, 1f));
        colorMap.put(BOARD_COLOR.DARK_RED, new Color(255f/255f, 51f/255f, 51f/255f, 1f));
        colorMap.put(BOARD_COLOR.LIGHT_ORANGE, new Color(255f/255f, 194f/255f, 102f/255f, 1f));
        colorMap.put(BOARD_COLOR.DARK_ORANGE, new Color(255f/255f, 163f/255f, 26f/255f, 1f));
        colorMap.put(BOARD_COLOR.LIGHT_PURPLE, new Color(204f/255f, 102f/255f, 255f/255f, 1f));
        colorMap.put(BOARD_COLOR.DARK_PURPLE, new Color(187f/255f, 51f/255f, 255f/255f, 1f));
    }

    private void setUpBoard() {

        pieceList = new com.mygdx.SjadamGame.Helpers.Pieces.IPiece[8][8];

        boardColors = new BOARD_COLOR[8][8];
        boardWithoutMoves = new BOARD_COLOR[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    boardColors[i][j] = BOARD_COLOR.BLACK;
                    boardWithoutMoves[i][j] = BOARD_COLOR.BLACK;
                }
                else if (i % 2 == 0 && j % 2 != 0) {
                    boardColors[i][j] = BOARD_COLOR.WHITE;
                    boardWithoutMoves[i][j] = BOARD_COLOR.WHITE;
                }
                if (i % 2 != 0 && j % 2 != 0) {
                    boardColors[i][j] = BOARD_COLOR.BLACK;
                    boardWithoutMoves[i][j] = BOARD_COLOR.BLACK;
                }
                else if (i % 2 != 0 && j % 2 == 0){
                    boardColors[i][j] = BOARD_COLOR.WHITE;
                    boardWithoutMoves[i][j] = BOARD_COLOR.WHITE;
                }
            }
        }

        //White
        pieceList[0][0] = new Rook(BOARD_COLOR.WHITE);
        pieceList[0][1] = new Knight(BOARD_COLOR.WHITE);
        pieceList[0][2] = new Bishop(BOARD_COLOR.WHITE);
        pieceList[0][3] = new com.mygdx.SjadamGame.Helpers.Pieces.Queen(BOARD_COLOR.WHITE);
        pieceList[0][4] = new com.mygdx.SjadamGame.Helpers.Pieces.King(BOARD_COLOR.WHITE);
        pieceList[0][5] = new Bishop(BOARD_COLOR.WHITE);
        pieceList[0][6] = new Knight(BOARD_COLOR.WHITE);
        pieceList[0][7] = new Rook(BOARD_COLOR.WHITE);

        pieceList[1][0] = new Pawn(BOARD_COLOR.WHITE);
        pieceList[1][1] = new Pawn(BOARD_COLOR.WHITE);
        pieceList[1][2] = new Pawn(BOARD_COLOR.WHITE);
        pieceList[1][3] = new Pawn(BOARD_COLOR.WHITE);
        pieceList[1][4] = new Pawn(BOARD_COLOR.WHITE);
        pieceList[1][5] = new Pawn(BOARD_COLOR.WHITE);
        pieceList[1][6] = new Pawn(BOARD_COLOR.WHITE);
        pieceList[1][7] = new Pawn(BOARD_COLOR.WHITE);

        //Black
        pieceList[7][0] = new Rook(BOARD_COLOR.BLACK);
        pieceList[7][1] = new Knight(BOARD_COLOR.BLACK);
        pieceList[7][2] = new Bishop(BOARD_COLOR.BLACK);
        pieceList[7][3] = new com.mygdx.SjadamGame.Helpers.Pieces.Queen(BOARD_COLOR.BLACK);
        pieceList[7][4] = new com.mygdx.SjadamGame.Helpers.Pieces.King(BOARD_COLOR.BLACK);
        pieceList[7][5] = new Bishop(BOARD_COLOR.BLACK);
        pieceList[7][6] = new Knight(BOARD_COLOR.BLACK);
        pieceList[7][7] = new Rook(BOARD_COLOR.BLACK);

        pieceList[6][0] = new Pawn(BOARD_COLOR.BLACK);
        pieceList[6][1] = new Pawn(BOARD_COLOR.BLACK);
        pieceList[6][2] = new Pawn(BOARD_COLOR.BLACK);
        pieceList[6][3] = new Pawn(BOARD_COLOR.BLACK);
        pieceList[6][4] = new Pawn(BOARD_COLOR.BLACK);
        pieceList[6][5] = new Pawn(BOARD_COLOR.BLACK);
        pieceList[6][6] = new Pawn(BOARD_COLOR.BLACK);
        pieceList[6][7] = new Pawn(BOARD_COLOR.BLACK);
    }

    

    public void renderPieces(SpriteBatch batch, int width, int height) {
        int pieceWidth = width / 8;
        int pieceHeight = height / 8;
        for (int i = 0; i < pieceList.length; i++) {
            for (int j = 0; j < pieceList[i].length; j++) {
                if (pieceList[i][j] != null) {
                    pieceList[i][j].renderPiece(batch, pieceWidth, pieceHeight, j, i + 2);
                }
            }
        }
    }

    @Override
    public void renderBoard(ShapeRenderer renderer, int width, int height) {
        int rectWidth = width / 8;
        int rectHeight = height / 8;
        for (int i = 0; i < boardColors.length; i++) {
            for (int j = 0; j < boardColors[i].length; j++) {
                BOARD_COLOR color = translateBoardColor(boardWithoutMoves[i][j], boardColors[i][j]);
                renderer.setColor((Color) colorMap.get(color));
                renderer.rect(rectWidth * j, rectHeight * (i + 2), rectWidth, rectHeight);
            }
        }
    }

    public void pieceClicked(Vector2 position) {
        if (!isLegalBoardPosition((int)position.x, (int)position.y)) {
            return;
        }
        if (playing == false) {
            clearBoard();
            return;
        }

        if (activeClick == false && pieceList[(int)position.y][(int)position.x] != null) {
            pieceClicked = pieceList[(int)position.y][(int)position.x];
            xPositionPieceClicked = (int)position.x;
            yPositionPieceClicked = (int)position.y;
            currentXPositionPieceClicked = (int)position.x;
            currentYPositionPieceClicked = (int)position.y;
        }

        BOARD_COLOR tileClicked = boardColors[(int)position.y][(int)position.x];

        if (activeClick == false && pieceClicked != null) {
            if (pieceClicked.getColor() != playerTurn) {
                clearBoard();
                return;
            }

            activeClick = true;
            boardColors[(int)position.y][(int)position.x] = BOARD_COLOR.RED;
            findSjadamMoves((int) position.x, (int) position.y);

            boardColors = pieceClicked.findMoves(boardColors, pieceList,
                    (int)position.x, (int)position.y);
            clickPosition = position;
        }
        else if (activeClick == true && isMoveableColor(tileClicked) == false) {
            resetPiece();
            clearBoard();
            activeClick = false;
            pieceClicked = null;
            return;
        }
        else if (activeClick == true && isMoveableColor(tileClicked)) {
            if (pieceClicked.getColor() != playerTurn) {
                clearBoard();
                return;
            }

            movePiece((int)clickPosition.x, (int)clickPosition.y, (int)position.x, (int)position.y);
            boardColors[(int)position.y][(int)position.x] = BOARD_COLOR.RED;
            findSjadamMoves((int) position.x, (int) position.y);

            boardColors = pieceList[(int)position.y][(int)position.x].findMoves(boardColors, pieceList,
                    (int)position.x, (int)position.y);
            clickPosition = position;
        }
        else {
            activeClick = false;
            clearBoard();
        }

        //remove possible moves if changing player turn
        if (pieceClicked != null) {
            if (pieceClicked.getColor() != playerTurn) {
                activeClick = false;
                clearBoard();
            }
        }

    }

    private void findSjadamMoves(int xPos, int yPos) {
        for (int y = - 1; y <= 1; y++) {
            for (int x = - 1; x <= 1; x++) {
                if (isLegalBoardPosition(xPos + x, yPos + y)) {
                    if (pieceList[yPos + y][xPos + x] instanceof com.mygdx.SjadamGame.Helpers.Pieces.IPiece && isLegalBoardPosition(xPos + 2*x, yPos + 2*y)) {
                        if (pieceList[yPos + 2*y][xPos + 2*x] == null && checkForMaxOneJumpOverOpponent(xPos, yPos, xPos + 2 * x, yPos + 2 * y) == true) {
                            boardColors[yPos + 2*y][xPos + 2*x] = BOARD_COLOR.BLUE;
                        }
                    }
                }
            }
        }
    }

    private boolean isLegalBoardPosition(int xPos, int yPos) {
        if (xPos > 7 || xPos < 0 || yPos > 7 || yPos < 0) {
            return false;
        }

        return true;
    }

    private boolean movePiece(int piecePosX, int piecePosY, int moveToX, int moveToY) {

        //checking that we are trying to move an actual piece
        com.mygdx.SjadamGame.Helpers.Pieces.IPiece pieceToMove = pieceList[piecePosY][piecePosX];
        if (pieceToMove instanceof com.mygdx.SjadamGame.Helpers.Pieces.IPiece) {
            //regular chess move
            if (boardColors[moveToY][moveToX] == BOARD_COLOR.PURPLE) {
                if (pieceList[moveToY][moveToX] instanceof com.mygdx.SjadamGame.Helpers.Pieces.King) {
                    playing = false;
                }

                pieceList[piecePosY][piecePosX] = null;
                pieceList[moveToY][moveToX] = pieceToMove;
                pieceList[moveToY][moveToX].setMoved();

                makeQueen(moveToX, moveToY, boardColors[moveToY][moveToX]);

                clearBoard();

                //opponents move after chess move
                shiftTurn();
            }
            //sjadammove
            else if (boardColors[moveToY][moveToX] == BOARD_COLOR.BLUE) {
                sjadamJumpHelper(piecePosX, piecePosY, moveToX, moveToY);
                pieceList[piecePosY][piecePosX] = null;
                pieceList[moveToY][moveToX] = pieceToMove;
                pieceList[moveToY][moveToX].setMoved();

                makeQueen(moveToX, moveToY, boardColors[moveToY][moveToX]);

                clearBoard();
            }
            //stand on the same place
            else if (boardColors[moveToY][moveToX] == BOARD_COLOR.RED) {
                if (moveToX == xPositionPieceClicked && moveToY == yPositionPieceClicked) {
                    return false;
                }
                pieceList[moveToY][moveToX].setMoved();
                activeClick = false;

                makeQueen(moveToX, moveToY, boardColors[moveToY][moveToX]);

                clearBoard();
                shiftTurn();
            }
            else if (boardColors[moveToY][moveToX] == BOARD_COLOR.ORANGE) {
                System.out.println(111111);
                //short castling
                if (moveToX == 6) {
                    pieceToMove.setMoved();
                    pieceList[piecePosY][6] = pieceToMove;
                    pieceList[piecePosY][piecePosX] = null;
                    pieceList[piecePosY][7].setMoved();
                    pieceList[piecePosY][5] = pieceList[piecePosY][7];
                    pieceList[piecePosY][7] = null;

                }
                //long castling
                else {
                    pieceToMove.setMoved();
                    pieceList[piecePosY][2] = pieceToMove;
                    pieceList[piecePosY][piecePosX] = null;
                    pieceList[piecePosY][0].setMoved();
                    pieceList[piecePosY][3] = pieceList[piecePosY][0];
                    pieceList[piecePosY][0] = null;
                }

                clearBoard();
                shiftTurn();
            }

            //updating current x and y position of the piece
            currentXPositionPieceClicked = moveToX;
            currentYPositionPieceClicked = moveToY;
            return true;
        }

        return false;
    }

    private void makeQueen(int xPos, int yPos, BOARD_COLOR board_color) {
        com.mygdx.SjadamGame.Helpers.Pieces.IPiece piece = pieceList[yPos][xPos];

        //King cannot become queen, if queen, do not make a new queen
        if (piece instanceof com.mygdx.SjadamGame.Helpers.Pieces.King || piece instanceof com.mygdx.SjadamGame.Helpers.Pieces.Queen) {
            return;
        }

        boolean madeQueen = false;
        if (piece.getColor() == BOARD_COLOR.BLACK && yPos == 0) {
            pieceList[yPos][xPos] = new com.mygdx.SjadamGame.Helpers.Pieces.Queen(BOARD_COLOR.BLACK);
            madeQueen = true;
        }
        else if (piece.getColor() == BOARD_COLOR.WHITE && yPos == 7) {
            pieceList[yPos][xPos] = new com.mygdx.SjadamGame.Helpers.Pieces.Queen(BOARD_COLOR.WHITE);
            madeQueen = true;
        }

        if (madeQueen == true) {
            clearBoard();
            if (board_color == BOARD_COLOR.BLUE) {
                shiftTurn();
            }
        }


    }

    private void clearBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardColors[i][j] = boardWithoutMoves[i][j];
            }
        }
    }

    private void shiftTurn() {
        if (playerTurn == BOARD_COLOR.BLACK) {
            playerTurn = BOARD_COLOR.WHITE;
        }
        else {
            playerTurn = BOARD_COLOR.BLACK;
        }
        jumpedOverOpponent = false;
    }

    /**
     * Puts piece clisked back to original position
     */
    private void resetPiece() {
        pieceList[currentYPositionPieceClicked][currentXPositionPieceClicked] = null;
        pieceList[yPositionPieceClicked][xPositionPieceClicked] = pieceClicked;
    }

    private boolean isMoveableColor(BOARD_COLOR color) {
        if (color == BOARD_COLOR.PURPLE || color == BOARD_COLOR.RED || color == BOARD_COLOR.BLUE
                || color == BOARD_COLOR.ORANGE) {
            return true;
        }

        return false;
    }

    /**
     * translates color to a light or dark color depending on which color the underlyig ches board tile is
      * @param chessTileColor is the color of the underlying chess board
     * @param movecolor is the color of the possible moves
     * @return
     */
    private BOARD_COLOR translateBoardColor(BOARD_COLOR chessTileColor, BOARD_COLOR movecolor) {
        //if color is black or white, return that color
        if (chessTileColor == movecolor) {
            return movecolor;
        }

        if (chessTileColor == BOARD_COLOR.BLACK) {
            switch (movecolor) {
                case BLUE:
                    return BOARD_COLOR.DARK_BLUE;
                case RED:
                    return BOARD_COLOR.DARK_RED;
                case ORANGE:
                    return BOARD_COLOR.DARK_ORANGE;
                case PURPLE:
                    return BOARD_COLOR.DARK_PURPLE;
                default:
                    return BOARD_COLOR.BLACK;
            }
        }
        else {
            switch (movecolor) {
                case BLUE:
                    return BOARD_COLOR.LIGHT_BLUE;
                case RED:
                    return BOARD_COLOR.LIGHT_RED;
                case ORANGE:
                    return BOARD_COLOR.LIGHT_ORANGE;
                case PURPLE:
                    return BOARD_COLOR.LIGHT_PURPLE;
                default:
                    return BOARD_COLOR.WHITE;
            }
        }
    }

    /**
     * Checking for max 1 jump over opponent
     */
    private boolean checkForMaxOneJumpOverOpponent(int piecePosX, int piecePosY, int moveToX, int moveToY) {
        if (jumpedOverOpponent == false) {
            return true;
        }

        if (piecePosY + ((moveToY - piecePosY) / 2) == jumpedOverOpponentY && piecePosX + ((moveToX - piecePosX) / 2) == jumpedOverOpponentX) {
            return true;
        }

        return false;
    }

    /**
     * Checking for jumping over same opponent piece and allowing more jumps
     * Checking for jumping over
     */
    private void sjadamJumpHelper(int piecePosX, int piecePosY, int moveToX, int moveToY) {
        com.mygdx.SjadamGame.Helpers.Pieces.IPiece jumpingOverPiece = pieceList[piecePosY + ((moveToY - piecePosY) / 2)][piecePosX + ((moveToX - piecePosX) / 2)];

        if (jumpingOverPiece.getColor() == playerTurn) {
            return;
        }
        else if (piecePosY + ((moveToY - piecePosY) / 2) == jumpedOverOpponentY && piecePosX + ((moveToX - piecePosX) / 2) == jumpedOverOpponentX) {
            jumpedOverOpponent = false;
        }
        else {
            jumpedOverOpponent = true;
            jumpedOverOpponentX = piecePosX + ((moveToX - piecePosX) / 2);
            jumpedOverOpponentY = piecePosY + ((moveToY - piecePosY) / 2);
        }
    }

    /**
     * Resetting board and pieces to begin a new game
     */
    public void resetBoardAndPieces() {
        setUpBoard();
        playerTurn = BOARD_COLOR.WHITE;
        activeClick = false;
        playing = true;
    }

    public BOARD_COLOR getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(BOARD_COLOR playerTurn) {
        this.playerTurn = playerTurn;
    }

    public boolean getPlaying() {
        return playing;
    }

    public BOARD_COLOR getWinnerColor() {
        if (playing == false) {
            if (playerTurn == BOARD_COLOR.BLACK) {
                return BOARD_COLOR.WHITE;
            }
            else {
                return BOARD_COLOR.BLACK;
            }
        }

        return null;
    }

    public void setPieceList(com.mygdx.SjadamGame.Helpers.Pieces.IPiece[][] pieceList) {
        this.pieceList = pieceList;
    }

    /**
     * returns piecelist and resets current move to original position
     */
    public com.mygdx.SjadamGame.Helpers.Pieces.IPiece[][] getPieceListAndResetPiece() {
        //to not reset the last move
        if (pieceClicked != null) {
            if (playerTurn == pieceClicked.getColor()) {
                resetPiece();
            }
        }
        return pieceList;
    }
}
