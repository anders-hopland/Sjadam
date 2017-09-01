package com.mygdx.SjadamGame.Util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Anders-Hopland on 01.09.2017.
 */

public class AssetManager {

    private static AssetManager instance = new AssetManager();
    
    //white
    private static TextureRegion whitePawn;
    private static TextureRegion whiteKnight;
    private static TextureRegion whiteBishop;
    private static TextureRegion whiteRook;
    private static TextureRegion whiteQueen;
    private static TextureRegion whiteKing;
    
    //black
    private static TextureRegion blackPawn;
    private static TextureRegion blackKnight;
    private static TextureRegion blackBishop;
    private static TextureRegion blackRook;
    private static TextureRegion blackQueen;
    private static TextureRegion blackKing;

    private Texture texture;
    
    private AssetManager() {
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

    public static AssetManager getAssetManager() {
        return instance;
    }

    public static AssetManager getInstance() {
        return instance;
    }

    public static TextureRegion getWhitePawn() {
        return whitePawn;
    }

    public static TextureRegion getWhiteKnight() {
        return whiteKnight;
    }

    public static TextureRegion getWhiteBishop() {
        return whiteBishop;
    }

    public static TextureRegion getWhiteRook() {
        return whiteRook;
    }

    public static TextureRegion getWhiteQueen() {
        return whiteQueen;
    }

    public static TextureRegion getWhiteKing() {
        return whiteKing;
    }

    public static TextureRegion getBlackPawn() {
        return blackPawn;
    }

    public static TextureRegion getBlackKnight() {
        return blackKnight;
    }

    public static TextureRegion getBlackBishop() {
        return blackBishop;
    }

    public static TextureRegion getBlackRook() {
        return blackRook;
    }

    public static TextureRegion getBlackQueen() {
        return blackQueen;
    }

    public static TextureRegion getBlackKing() {
        return blackKing;
    }
}
