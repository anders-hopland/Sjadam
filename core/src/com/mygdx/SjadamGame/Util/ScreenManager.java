package com.mygdx.SjadamGame.Util;

import com.badlogic.gdx.Screen;

/**
 * Created by Anders-Hopland on 22.07.2017.
 */

public class ScreenManager {

    private com.mygdx.SjadamGame.SjadamGame game;
    private com.mygdx.SjadamGame.Helpers.Pieces.IPiece[][] pieces;
    private com.mygdx.SjadamGame.Helpers.BOARD_COLOR playingColor;
    private boolean alreadyInitializedGameScreen;

    private static ScreenManager screenManager;

    //saving game screen to save progress when pausing
    private com.mygdx.SjadamGame.Screen.AbstractScreen gameScreen;

    private ScreenManager() {

    }

    public void initialize(com.mygdx.SjadamGame.SjadamGame game) {
        this.game = game;
    }

    public static ScreenManager getScreenManager() {
        if (screenManager == null) {
            screenManager = new ScreenManager();
        }

        return screenManager;
    }

    public void showScreen(ScreenType screenType) {
        Screen currentScreen = game.getScreen();

        com.mygdx.SjadamGame.Screen.AbstractScreen newscreen = screenType.getScreen();

        if ((screenType == ScreenType.RESUME_GAME_SCREEN || screenType == ScreenType.NEW_GAME_SCREEN)
                && alreadyInitializedGameScreen == false) {
            alreadyInitializedGameScreen = true;
        }
        else if (screenType == ScreenType.RESUME_GAME_SCREEN && alreadyInitializedGameScreen == true) {
            ((com.mygdx.SjadamGame.Screen.GameScreen) newscreen).setPieces(pieces);
            ((com.mygdx.SjadamGame.Screen.GameScreen) newscreen).setPlayingColor(playingColor);
        }
        else if (game.getScreen() instanceof com.mygdx.SjadamGame.Screen.GameScreen) {
            pieces = ((com.mygdx.SjadamGame.Screen.GameScreen) game.getScreen()).getPieces();
            playingColor = ((com.mygdx.SjadamGame.Screen.GameScreen) game.getScreen()).getPlayingColor();

        }

        game.setScreen(newscreen);

        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

}