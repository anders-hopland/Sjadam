package com.mygdx.SjadamGame.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Anders-Hopland on 01.09.2017.
 */

public class AssetManager {

    //white
    private  TextureRegion whitePawn;
    private  TextureRegion whiteKnight;
    private  TextureRegion whiteBishop;
    private  TextureRegion whiteRook;
    private  TextureRegion whiteQueen;
    private  TextureRegion whiteKing;
    
    //black
    private  TextureRegion blackPawn;
    private  TextureRegion blackKnight;
    private  TextureRegion blackBishop;
    private  TextureRegion blackRook;
    private  TextureRegion blackQueen;
    private  TextureRegion blackKing;
    private  Texture texture;

    public AssetManager() {
        texture = new Texture(Gdx.files.internal("chessMinimized.png"));

        //white pawn
        whitePawn = new TextureRegion(texture, 0, 64, 64, 64);
        
        //white knight
        whiteKnight = new TextureRegion(texture, 64, 64, 64, 64);

        //white bishop
        whiteBishop = new TextureRegion(texture, 128, 64, 64, 64);

        //white rook
        whiteRook = new TextureRegion(texture, 192, 64, 64, 64);
        
        //white queen
        whiteQueen = new TextureRegion(texture, 256, 64, 64, 64);

        //white king
        whiteKing = new TextureRegion(texture, 320, 64, 64, 64);
        
        //black pawn
        blackPawn = new TextureRegion(texture, 0, 0, 64, 64);

        //black knight
        blackKnight = new TextureRegion(texture, 64, 0, 64, 64);

        //black bishop
        blackBishop = new TextureRegion(texture, 128, 0, 64, 64);

        //black rook
        blackRook = new TextureRegion(texture, 192, 0, 64, 64);

        //black queen
        blackQueen = new TextureRegion(texture, 256, 0, 64, 64);

        //black king
        blackKing = new TextureRegion(texture, 320, 0, 64, 64);
    }

    public TextureRegion getWhitePawn() {
        return whitePawn;
    }

    public  TextureRegion getWhiteKnight() {
        return whiteKnight;
    }

    public  TextureRegion getWhiteBishop() {
        return whiteBishop;
    }

    public  TextureRegion getWhiteRook() {
        return whiteRook;
    }

    public  TextureRegion getWhiteQueen() {
        return whiteQueen;
    }

    public  TextureRegion getWhiteKing() {
        return whiteKing;
    }

    public  TextureRegion getBlackPawn() {
        return blackPawn;
    }

    public  TextureRegion getBlackKnight() {
        return blackKnight;
    }

    public  TextureRegion getBlackBishop() {
        return blackBishop;
    }

    public  TextureRegion getBlackRook() {
        return blackRook;
    }

    public  TextureRegion getBlackQueen() {
        return blackQueen;
    }

    public  TextureRegion getBlackKing() {
        return blackKing;
    }
}
