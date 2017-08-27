package com.mygdx.SjadamGame.Util;

import com.mygdx.SjadamGame.Screen.AbstractScreen;
import com.mygdx.SjadamGame.Screen.HowToPlayScreen;
import com.mygdx.SjadamGame.Screen.RulesScreen;

/**
 * Created by Anders-Hopland on 22.07.2017.
 */

public enum ScreenType {
    NEW_GAME_SCREEN {
        public com.mygdx.SjadamGame.Screen.AbstractScreen getScreen() {
            return new com.mygdx.SjadamGame.Screen.GameScreen();
        }
    },
    RESUME_GAME_SCREEN {
        @Override
        public com.mygdx.SjadamGame.Screen.AbstractScreen getScreen() {
            return new com.mygdx.SjadamGame.Screen.GameScreen();
        }
    },
    PAUSE_SCREEN {
        @Override
        public com.mygdx.SjadamGame.Screen.AbstractScreen getScreen() {
            return new com.mygdx.SjadamGame.Screen.PauseScreen();
        }
    },
    START_SCREEN {
        @Override
        public com.mygdx.SjadamGame.Screen.AbstractScreen getScreen() {
            return new com.mygdx.SjadamGame.Screen.StartScreen();
        }
    },
    RULES_SCREEN{
        @Override
        public com.mygdx.SjadamGame.Screen.AbstractScreen getScreen() {
            return new RulesScreen();
        }
    },
    CREDITS_SCREEN{
        @Override
        public com.mygdx.SjadamGame.Screen.AbstractScreen getScreen() {
            return new com.mygdx.SjadamGame.Screen.CreditsScreen();
        }
    },
    HOW_TO_PLAY_SCREEN{
        @Override
        public AbstractScreen getScreen() {
            return new HowToPlayScreen();
        }
    };

    public abstract com.mygdx.SjadamGame.Screen.AbstractScreen getScreen();
}
