package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.SjadamGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = SjadamGame.VIRTUAL_WIDTH * 2;
		config.height = SjadamGame.VIRTUAL_HEIGHT * 2;
		config.title = "Sjadam";
		new LwjglApplication(new SjadamGame(), config);
	}
}
