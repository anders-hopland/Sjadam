package com.mygdx.SjadamGame.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.mygdx.SjadamGame.SjadamGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(SjadamGame.VIRTUAL_WIDTH, SjadamGame.VIRTUAL_HEIGHT);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new SjadamGame();
        }
}